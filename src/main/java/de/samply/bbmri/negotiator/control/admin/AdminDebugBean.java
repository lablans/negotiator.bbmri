/*
 * Copyright (c) 2017. Medizinische Informatik in der Translationalen Onkologie,
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

package de.samply.bbmri.negotiator.control.admin;

import de.samply.bbmri.negotiator.Config;
import de.samply.bbmri.negotiator.ConfigFactory;
import de.samply.bbmri.negotiator.db.util.DbUtil;
import de.samply.bbmri.negotiator.jooq.tables.records.PersonRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.QueryRecord;
import de.samply.bbmri.negotiator.model.CollectionBiobankDTO;
import de.samply.bbmri.negotiator.model.OfferPersonDTO;
import de.samply.bbmri.negotiator.util.ObjectToJson;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 7/25/2017.
 */


/**
 * Outputs the details of the given queryId
 */
@ViewScoped
@ManagedBean
public class AdminDebugBean implements Serializable {

    /**
     * The list of queries
     */
    private List<QueryRecord> queries;
    private HashMap<Integer, PersonRecord> users;

    //---------------------------------
    // START Collection Assostiations
    /**
     * Collections that are reachable (mail available)
     */
    private final HashMap<Integer, String> reachableCollections = new HashMap<Integer, String>();
    /**
     * List of collection with biobanks details of a specific query.
     */
    private final HashMap<Integer, List<CollectionBiobankDTO>> matchingBiobankCollection = new HashMap<Integer, List<CollectionBiobankDTO>>();//new ArrayList<>();
    /**
     * String contains Json data for JsTree view
     */
    private final HashMap<Integer, String> jsTreeJson = new HashMap<Integer, String>();
    /**
     * List to store the person id who has not contacted already
     */
    private final HashMap<Integer, List<CollectionBiobankDTO>> biobankWithoutOffer = new HashMap<Integer, List<CollectionBiobankDTO>>();//new ArrayList<>();
    /**
     * Biobanks that match to a query
     */
    private final HashMap<Integer, Integer> matchingBiobanks = new HashMap<Integer, Integer>();
    /**
     * The list of BIOBANK ID who are related with a given query
     */
    private final HashMap<Integer, List<Integer>> biobankWithOffer = new HashMap<Integer, List<Integer>>();
    /**
     * The list of offerPersonDTO's, hence it's a list of lists.
     */
    private final HashMap<Integer, List<List<OfferPersonDTO>>> listOfSampleOffers = new HashMap<Integer, List<List<OfferPersonDTO>>>();//new ArrayList<>();

    // Data Transfer
    private Integer transferQueryId;
    private Integer transferQueryToUserId;

    // END Collection Assostiations
    //---------------------------------

    //region properties
    public List<QueryRecord> getQueries() {
        return queries;
    }

    public void setQueries(List<QueryRecord> queries) {
        this.queries = queries;
    }
//endregion

    public String getUserName(Integer id) {
        return users.get(id).getAuthName();
    }

    public HashMap<Integer, PersonRecord> getUser() {
        return users;
    }

    public String restNegotiation(Integer id) {
        try (Config config = ConfigFactory.get()) {
            DbUtil.restNegotiation(config, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/admin/debug.xhtml";
    }

    /**
     * Sets the queries list by getting all the queries from the data base
     *
     * @return
     */
    public void loadQueries() {
        try(Config config = ConfigFactory.get()) {
            queries = DbUtil.getQueries(config);
            users = new HashMap<Integer, PersonRecord>();
            for(PersonRecord personRecord : DbUtil.getAllUsers(config)) {
                users.put(personRecord.getId(), personRecord);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void transferRequest() {
        try (Config config = ConfigFactory.get()) {
            DbUtil.transferQuery(config, transferQueryId, transferQueryToUserId);
        } catch (SQLException e) {
            System.err.println("3f0113dc7f4c-AdminDebugBean ERROR-NG-0000076: Error Transferring Request " + transferQueryId + " to user " + transferQueryToUserId + ".");
            e.printStackTrace();
        }
    }

    public void switchTestRequest(Integer queryId) {
        try (Config config = ConfigFactory.get()) {
            DbUtil.toggleRequestTestState(config, queryId);
            for(QueryRecord query : queries) {
                if(query.getId() == queryId) {
                    query.setTestRequest(!query.getTestRequest());
                    return;
                }
            }
        } catch (SQLException e) {
            System.err.println("3f0113dc7f4c-AdminDebugBean ERROR-NG-0000075: Error switching test request state for request " + queryId + ".");
            e.printStackTrace();
        }
    }

    private void setupCollections(Config config, Integer queryId) {
        matchingBiobankCollection.put(queryId, new ArrayList<CollectionBiobankDTO>());
        biobankWithoutOffer.put(queryId, new ArrayList<CollectionBiobankDTO>());
        listOfSampleOffers.put(queryId, new ArrayList<List<OfferPersonDTO>>());

        setBiobankWithOffer(queryId, DbUtil.getOfferMakers(config, queryId));

        for (int i = 0; i < biobankWithOffer.get(queryId).size(); ++i) {
            List<OfferPersonDTO> offerPersonDTO;
            offerPersonDTO = DbUtil.getOffers(config, queryId, biobankWithOffer.get(queryId).get(i));
            listOfSampleOffers.get(queryId).add(offerPersonDTO);
        }

        matchingBiobankCollection.put(queryId, DbUtil.getCollectionsForQuery(config, queryId));
        setMatchingBiobanks(queryId, ObjectToJson.getUniqueBiobanks(matchingBiobankCollection.get(queryId)).size());
        /**
         * This is done to remove the repitition of biobanks in the list because of multiple collection
         */
        int reachable = 0;
        int unreachable = 0;
        for (int j = 0; j < matchingBiobankCollection.get(queryId).size(); j++) {
            if (!getBiobankWithoutOffer(queryId).contains(matchingBiobankCollection.get(queryId).get(j)) ) {
                if (!biobankWithOffer.get(queryId).contains(matchingBiobankCollection.get(queryId).get(j).getBiobank().getId())) {
                    biobankWithoutOffer.get(queryId).add(matchingBiobankCollection.get(queryId).get(j));
                }
            }

            // Check if Collection is available
            if(matchingBiobankCollection.get(queryId).get(j).isContacable()) {
                reachable++;
            } else {
                unreachable++;
            }
        }
        setReachableCollections(queryId,"(" + reachable + " Collections reachable, " + unreachable + " Collections unreachable)");

        /**
         * Convert matchingBiobankCollection in the JSON format for Tree View
         */
        setJsTreeJson(queryId, ObjectToJson.getJsonTree(matchingBiobankCollection.get(queryId)));
    }

    public List<CollectionBiobankDTO> getBiobankWithoutOffer(Integer queryId) {
        return biobankWithoutOffer.get(queryId);
    }

    public void setBiobankWithoutOffer(Integer queryId, List<CollectionBiobankDTO> copyList) {
        this.biobankWithoutOffer.put(queryId, copyList);
    }

    public String getJsTreeJson(Integer queryId) {
        return jsTreeJson.get(queryId);
    }

    public void setJsTreeJson(Integer queryId, String jsTreeJson) {
        this.jsTreeJson.put(queryId, jsTreeJson);
    }

    public int getMatchingBiobanks(Integer queryId) {
        return matchingBiobanks.get(queryId);
    }

    public void setMatchingBiobanks(Integer queryId, int matchingBiobanks) {
        this.matchingBiobanks.put(queryId, matchingBiobanks);
    }

    public String getReachableCollections(Integer queryId) {
        String return_value = reachableCollections.get(queryId);
        if(return_value == null) {
            return "";
        }
        return return_value;
    }

    public void setReachableCollections(Integer queryId, String reachableCollections) {
        this.reachableCollections.put(queryId, reachableCollections);
    }

    public List<CollectionBiobankDTO> getMatchingBiobankCollection(Integer queryId) {
        return matchingBiobankCollection.get(queryId);
    }

    public void setMatchingBiobankCollection(Integer queryId, List<CollectionBiobankDTO> matchingBiobankCollection) {
        this.matchingBiobankCollection.put(queryId, matchingBiobankCollection);
    }

    public List<Integer> getBiobankWithOffer(Integer queryId) {
        return biobankWithOffer.get(queryId);
    }

    public void setBiobankWithOffer(Integer queryId, List<Integer> biobankWithOffer) {
        this.biobankWithOffer.put(queryId, biobankWithOffer);
    }

    public Integer getTransferQueryId() {
        return transferQueryId;
    }

    public void setTransferQueryId(Integer transferQueryId) {
        this.transferQueryId = transferQueryId;
    }

    public Integer getTransferQueryToUserId() {
        return transferQueryToUserId;
    }

    public void setTransferQueryToUserId(Integer transferQueryToUserId) {
        this.transferQueryToUserId = transferQueryToUserId;
    }
}
