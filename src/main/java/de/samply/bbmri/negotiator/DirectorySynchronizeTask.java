/**
 * Copyright (C) 2016 Medizinische Informatik in der Translationalen Onkologie,
 * Deutsches Krebsforschungszentrum in Heidelberg
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.bbmri.negotiator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimerTask;

import de.samply.bbmri.negotiator.helper.model.DirectorySyncLoggingHelper;
import de.samply.bbmri.negotiator.jooq.tables.records.BiobankRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.CollectionRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.ListOfDirectoriesRecord;
import de.samply.bbmri.negotiator.util.DataCache;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.DirectoryClient;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.directoryclients.DKFZSampleLocatorDirectoryClient;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.dto.DirectoryNetwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.samply.bbmri.negotiator.db.util.DbUtil;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.directoryclients.MolgenisDirectoryClient;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.dto.DirectoryBiobank;
import eu.bbmri.eric.csit.service.negotiator.sync.directory.dto.DirectoryCollection;
import org.slf4j.Marker;

/**
 * Handles the perdiodical synchonization between the directory and our negotiator.
 */
public class DirectorySynchronizeTask extends TimerTask {

    /**
     *
     */
    private static final Logger logger = LoggerFactory.getLogger(DirectorySynchronizeTask.class);
    Marker marker;

    private List<String> defaultNationalNodes = new ArrayList<>(Arrays.asList(
       "no", "se", "fi", "ee", "lv", "lt", "pl", "de", "nl", "uk","be", "cz", "at", "ch", "bg", "it", "ee", "mt", "gr","tr", "cy"
    ));

    @Override
    public void run() {
        try(Config config = ConfigFactory.get()) {
            DirectorySyncLoggingHelper directorySyncLoggingHelper = new DirectorySyncLoggingHelper();
            List<ListOfDirectoriesRecord> directories = DbUtil.getDirectories(config);
            for(ListOfDirectoriesRecord listOfDirectoriesRecord : directories) {
                logger.info(marker, "Synchronization with the directory: {} - {}", listOfDirectoriesRecord.getId(), listOfDirectoriesRecord.getName());
                directorySyncLoggingHelper.addSyncResult(runDirectorySync(listOfDirectoriesRecord));
            }
            updateDefaultNetworks(config);
            NegotiatorStatus.get().newSuccessStatus(NegotiatorStatus.NegotiatorTaskType.DIRECTORY, "Biobanks: " + directorySyncLoggingHelper.getSyncedBiobanks() +
                    ", Collections: " + directorySyncLoggingHelper.getSyncedCollections() + ", Networks: " + directorySyncLoggingHelper.getSyncedNetworks());
            DataCache dataCache = DataCache.getInstance();
            dataCache.createUpdateBiobankList();
        } catch (Exception e) {
            logger.error(marker, "Synchronization of directories failed: {}", e.getMessage());
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.DIRECTORY, e.getMessage());
        }
    }

    public DirectorySyncLoggingHelper runDirectorySync(ListOfDirectoriesRecord listOfDirectoriesRecord) {
        logger.info(marker, "Starting synchronization with the directory: {} - {}", listOfDirectoriesRecord.getId(), listOfDirectoriesRecord.getName());
        DirectorySyncLoggingHelper directorySyncLoggingHelper = new DirectorySyncLoggingHelper();
        Boolean sync = listOfDirectoriesRecord.getSyncActive();
        if (listOfDirectoriesRecord.getSyncActive() != null && !listOfDirectoriesRecord.getSyncActive()) {
            return directorySyncLoggingHelper;
        }
        if(listOfDirectoriesRecord.getApiType().equalsIgnoreCase("Molgenis")) {
            return syncMolgenisStyleDirectory(listOfDirectoriesRecord, directorySyncLoggingHelper);
        }
        if(listOfDirectoriesRecord.getApiType().equalsIgnoreCase("DKFZ-SampleLocator")) {
            return syncDKFZSampleLocatorStyleDirectory(listOfDirectoriesRecord, directorySyncLoggingHelper);
        }
        return directorySyncLoggingHelper;
    }

    private DirectorySyncLoggingHelper syncDKFZSampleLocatorStyleDirectory(ListOfDirectoriesRecord listOfDirectoriesRecord, DirectorySyncLoggingHelper directorySyncLoggingHelper) {
        try(Config config = ConfigFactory.get()) {
            DKFZSampleLocatorDirectoryClient directoryClient = getDKFZSampleLocatorStyleDirectoryClient(
                    listOfDirectoriesRecord.getRestUrl(), listOfDirectoriesRecord.getUsername(), listOfDirectoriesRecord.getPassword());

            directorySyncLoggingHelper.setSyncedBiobanks(synchronizeBiobanks(listOfDirectoriesRecord.getId(), config, directoryClient, false));
            directorySyncLoggingHelper.setSyncedCollections(synchronizedCollections(listOfDirectoriesRecord.getId(), config, directoryClient, false));
            logger.info(marker, "Synchronization with the directory finished. Biobanks: {}, Collections: {}, Networks: {}.",
                    directorySyncLoggingHelper.getSyncedBiobanks(), directorySyncLoggingHelper.getSyncedCollections(), directorySyncLoggingHelper.getSyncedNetworks());
            config.commit();
        } catch (Exception e) {
            logger.error(marker, "Synchronization of directory failed: {}", e.getMessage());
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.DIRECTORY, e.getMessage());
        }
        return directorySyncLoggingHelper;
    }

    private DirectorySyncLoggingHelper syncMolgenisStyleDirectory(ListOfDirectoriesRecord listOfDirectoriesRecord, DirectorySyncLoggingHelper directorySyncLoggingHelper) {
        try(Config config = ConfigFactory.get()) {
            boolean updateNetworks = false;
            if(listOfDirectoriesRecord.getResourceNetworks() != null) {
                updateNetworks = true;
            }

            MolgenisDirectoryClient directoryClient = getMolgenisDirectoryClient(listOfDirectoriesRecord.getUrl(), listOfDirectoriesRecord.getResourceBiobanks(),
                    listOfDirectoriesRecord.getResourceCollections(), listOfDirectoriesRecord.getResourceNetworks(),
                    listOfDirectoriesRecord.getUsername(), listOfDirectoriesRecord.getPassword(), updateNetworks);
            directorySyncLoggingHelper.setSyncedNetworks(synchronizeNetworks(listOfDirectoriesRecord.getId(), config, directoryClient, updateNetworks));
            directorySyncLoggingHelper.setSyncedBiobanks(synchronizeBiobanks(listOfDirectoriesRecord.getId(), config, directoryClient, updateNetworks));
            directorySyncLoggingHelper.setSyncedCollections(synchronizedCollections(listOfDirectoriesRecord.getId(), config, directoryClient, updateNetworks));

            logger.info(marker, "Synchronization with the directory finished. Biobanks: {}, Collections: {}, Networks: {}.",
                    directorySyncLoggingHelper.getSyncedBiobanks(), directorySyncLoggingHelper.getSyncedCollections(), directorySyncLoggingHelper.getSyncedNetworks());
            config.commit();
        } catch (Exception e) {
            logger.error(marker, "Synchronization of directory failed: {}", e.getMessage());
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.DIRECTORY, e.getMessage());
        }
        return directorySyncLoggingHelper;
    }

    private DKFZSampleLocatorDirectoryClient getDKFZSampleLocatorStyleDirectoryClient(String dirBaseUrl, String username, String password) {
        return new DKFZSampleLocatorDirectoryClient(dirBaseUrl, username, password);
    }

    private MolgenisDirectoryClient getMolgenisDirectoryClient(String dirBaseUrl, String resourceBiobanks, String resourceCollections,
                                                               String resourceNetworks, String username, String password, boolean updateNetworks) {
        MolgenisDirectoryClient client;
        if(!updateNetworks) {
            client = new MolgenisDirectoryClient(dirBaseUrl,
                    resourceBiobanks, resourceCollections,
                    username, password);
        } else {
            client = new MolgenisDirectoryClient(dirBaseUrl,
                    resourceBiobanks, resourceCollections, resourceNetworks,
                    username, password);
        }
        return client;
    }

    private int synchronizeNetworks(int listOfDirectoriesId, Config config, DirectoryClient client, boolean updateNetworks) {
        try {
            if (!updateNetworks) {
                return 0;
            }
            List<DirectoryNetwork> allNetworks = client.getAllNetworks();
            logger.info(marker, "All Networks: {}", allNetworks.size());
            for (DirectoryNetwork directoryNetwork : allNetworks) {
                DbUtil.synchronizeNetwork(config, directoryNetwork, listOfDirectoriesId);
            }
            return allNetworks.size();
        } catch (Exception e) {
            logger.error(marker, "d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000042: Problem synchronizing Networks for listOfDirectoriesId: {}.", listOfDirectoriesId);
            e.printStackTrace();
        }
        return 0;
    }

    private int synchronizeBiobanks(int listOfDirectoriesId, Config config, DirectoryClient client, boolean updateNetworks) {
        try {
            List<DirectoryBiobank> allBiobanks = client.getAllBiobanks();
            logger.info(marker, "All Biobanks: {}", allBiobanks.size());

            for(DirectoryBiobank directoryBiobank : allBiobanks) {
                BiobankRecord biobankRecord = DbUtil.synchronizeBiobank(config, directoryBiobank, listOfDirectoriesId);
                syncroniceBiobankNetworkLink(config, directoryBiobank, listOfDirectoriesId, updateNetworks, biobankRecord);
            }

            logger.info("DirectoryBiobank done");
            return allBiobanks.size();
        } catch (Exception e) {
            logger.error(marker, "d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000043: Problem synchronizing Biobanks for listOfDirectoriesId: {}.", listOfDirectoriesId);
            e.printStackTrace();
        }
        return 0;
    }

    private void syncroniceBiobankNetworkLink(Config config, DirectoryBiobank directoryBiobank, int listOfDirectoriesId, boolean updateNetworks, BiobankRecord biobankRecord) {
        try {
            if(!updateNetworks) {
                return;
            }
            DbUtil.updateBiobankNetworkLinks(config, directoryBiobank, listOfDirectoriesId, biobankRecord.getId());
        } catch (Exception e) {
            logger.error(marker, "d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000045: Problem synchronizing biobank network links for biobank: {}.", biobankRecord.getId());
            e.printStackTrace();
        }
    }

    private int synchronizedCollections(int listOfDirectoriesId, Config config, DirectoryClient client, boolean updateNetworks) {
        try {
            List<DirectoryCollection> allCollections = client.getAllCollections();
            logger.info(marker, "All Collections: {}", allCollections.size());

            for(DirectoryCollection directoryCollection : allCollections) {
                CollectionRecord collectionRecord = DbUtil.synchronizeCollection(config, directoryCollection, listOfDirectoriesId);
                syncroniceCollectionNetworkLink(config, directoryCollection, listOfDirectoriesId, updateNetworks, collectionRecord.getId());
            }
            return allCollections.size();
        } catch (Exception e) {
            logger.error(marker, "d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000044: Problem synchronizing collections for listOfDirectoriesId: {}.", listOfDirectoriesId);
            e.printStackTrace();
        }
        return 0;
    }

    private void syncroniceCollectionNetworkLink(Config config, DirectoryCollection directoryCollection, int listOfDirectoriesId, boolean updateNetworks, Integer collectionId) {
        try {
            if(!updateNetworks) {
                return;
            }
            DbUtil.updateCollectionNetworkLinks(config, directoryCollection, listOfDirectoriesId, collectionId);
        } catch (Exception e) {
            logger.error(marker, "d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000046: Problem synchronizing collection network links for collection: {}.", collectionId);
            e.printStackTrace();
        }
    }

    private void updateDefaultNetworks(Config config) {
        try {
            createDefaultNetworks(config);
            updateDefaultNetworksLinks(config);
        } catch (Exception e) {
            logger.error("d87b05514c78-DirectorySynchronizeTask ERROR-NG-0000094: Problem creating default National Node Networks.");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private void createDefaultNetworks(Config config) {
        for(String networkEnding : defaultNationalNodes) {
            String network = "BBMRI." + networkEnding;
            DirectoryNetwork networkDto = new DirectoryNetwork();
            networkDto.setId("internal:ID:" + network);
            networkDto.setName(network);
            networkDto.setDescription("Internal Network for the National Node of " + network);
            networkDto.setAcronym(network);
            DbUtil.synchronizeNetwork(config, networkDto, '1');
        }
    }

    private void updateDefaultNetworksLinks(Config config) {
        for(String networkEnding : defaultNationalNodes) {
            String networkname =  "internal:ID:BBMRI." + networkEnding;
            DbUtil.updateNetworkBiobankLinks(config, networkname, "bbmri-eric:ID:" + networkEnding + "%");
            DbUtil.updateNetworkCollectionLinks(config, networkname, "bbmri-eric:ID:" + networkEnding + "%");
        }
    }

}
