package de.samply.bbmri.negotiator.rest;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.samply.bbmri.negotiator.util.DataCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.samply.bbmri.negotiator.Config;
import de.samply.bbmri.negotiator.ConfigFactory;
import de.samply.bbmri.negotiator.NegotiatorConfig;
import de.samply.bbmri.negotiator.NegotiatorStatus;
import de.samply.bbmri.negotiator.config.Negotiator;
import de.samply.bbmri.negotiator.db.util.DbUtil;
import de.samply.bbmri.negotiator.rest.dto.PerunMappingDTO;
import de.samply.bbmri.negotiator.rest.dto.PerunPersonDTO;
import de.samply.string.util.StringUtil;

/**
 * Handles the REST endpoints /perun/users and /perun/mapping
 */
@Path("/perun")
public class Perun {

    /**
     * The logger for all perun rest endpoints
     */
    private static final Logger logger = LoggerFactory.getLogger(Perun.class);
    private HashMap<String, Integer> mapping_updates_collections = new HashMap<String, Integer>();

    /**
     * Accepts a list of perun users and puts them into the database
     * @param users the list of users from perun
     * @return return 200, if everything went alright, otherwise 500.
     */
    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postUsers(Collection<PerunPersonDTO> users, @Context HttpServletRequest request) {
        logger.debug("Checking perun authentication");
        Negotiator negotiator = NegotiatorConfig.get().getNegotiator();
        AuthenticationService.authenticate(request, negotiator.getPerunUsername(), negotiator.getPerunPassword());

        logger.info("Synchronizing user data from Perun");
        try(Config config = ConfigFactory.get()) {
            for(PerunPersonDTO personDTO : users) {
                if(StringUtil.isEmpty(personDTO.getId()) || StringUtil.isEmpty(personDTO.getDisplayName()) ||
                        StringUtil.isEmpty(personDTO.getMail())) {
                    logger.error("Perun user has no ID, no displayName or no mail: {}", personDTO.getId());
                    logger.error("Aborting synchronization");
                    NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, "No ID, name or mail: " + personDTO.getId());
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }

                DbUtil.savePerunUser(config, personDTO);
            }
            logger.info("Synchronizing user data with Perun finished");
            config.commit();

            NegotiatorStatus.get().newSuccessStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_USER,
                    "Users: " + users.size());

            return Response.ok().build();
        } catch (SQLException e) {
            logger.error("Failure in perun user synchronization");
            e.printStackTrace();
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_USER, e.getMessage());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/mapping")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postMapping(Collection<PerunMappingDTO> mappings, @Context HttpServletRequest request) {
        logger.debug("Checking perun authentication");
        Negotiator negotiator = NegotiatorConfig.get().getNegotiator();
        AuthenticationService.authenticate(request, negotiator.getPerunUsername(), negotiator.getPerunPassword());

        logger.info("Synchronizing user collection mapping from Perun");

        try(Config config = ConfigFactory.get()) {
            for(PerunMappingDTO mapping : mappings) {
                if(StringUtil.isEmpty(mapping.getId()) || StringUtil.isEmpty(mapping.getName())) {
                    logger.error("Perun mapping has no ID or no name: {}", mapping.getId());
                    logger.error("Aborting synchronization");
                    NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, "No ID or name: " + mapping.getId());
                    //return Response.status(Response.Status.BAD_REQUEST).build();
                }

                logger.debug("-->INFO00001--> Directory: {} CollectionID: {}", mapping.getDirectory(), mapping.getName());
                    String text = "";
                    for(PerunMappingDTO.PerunMemberDTO member : mapping.getMembers()) {
                        text += member.getUserId() + " ";
                    }
                    logger.debug("-->INFO00002--> Directory: {} CollectionID: {} -> {}", mapping.getDirectory(), mapping.getName(), text);
                updateCollectionMappingCount(mapping.getDirectory());
                DbUtil.savePerunMapping(config, mapping);
            }
            logger.info("Synchronizing user collection mapping with Perun finished");
            String satusUpdateString = generateSatusUpdateString();
            logger.debug("-->INFO00002" + satusUpdateString);
            config.commit();

            NegotiatorStatus.get().newSuccessStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING,
                    satusUpdateString);

            logger.info("Updating Collection Contact Cache.");
            DataCache cache = DataCache.getInstance();
            cache.createUpdateCollectionPersons();

            return Response.ok().build();
        } catch (Exception e) {
            logger.error("9bca4ebabf89-Perun ERROR-NG-0000056: Error syncing user collection mapping from perun.");
            e.printStackTrace();
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, e.getMessage());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("networks/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNetworkUsers(Collection<PerunPersonDTO> users, @Context HttpServletRequest request) {
        logger.debug("Checking perun authentication");
        Negotiator negotiator = NegotiatorConfig.get().getNegotiator();
        AuthenticationService.authenticate(request, negotiator.getPerunUsername(), negotiator.getPerunPassword());

        logger.info("Synchronizing user data from Perun");
        try(Config config = ConfigFactory.get()) {
            for(PerunPersonDTO personDTO : users) {
                if(StringUtil.isEmpty(personDTO.getId()) || StringUtil.isEmpty(personDTO.getDisplayName()) ||
                        StringUtil.isEmpty(personDTO.getMail())) {
                    logger.error("Perun user has no ID, no displayName or no mail: {}", personDTO.getId());
                    logger.error("Aborting synchronization");
                    NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, "No ID, name or mail: " + personDTO.getId());
                    return Response.status(Response.Status.BAD_REQUEST).build();
                }

                DbUtil.savePerunUser(config, personDTO);
            }
            logger.info("Synchronizing user data with Perun finished");
            config.commit();

            NegotiatorStatus.get().newSuccessStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_USER,
                    "Users: " + users.size());

            return Response.ok().build();
        } catch (SQLException e) {
            logger.error("Failure in perun user synchronization");
            e.printStackTrace();
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_USER, e.getMessage());
            return Response.serverError().build();
        }
    }

    @POST
    @Path("networks/mapping")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNetworkMapping(Collection<PerunMappingDTO> mappings, @Context HttpServletRequest request) {
        logger.debug("Checking perun authentication");
        Negotiator negotiator = NegotiatorConfig.get().getNegotiator();
        AuthenticationService.authenticate(request, negotiator.getPerunUsername(), negotiator.getPerunPassword());

        logger.info("Synchronizing user network mapping from Perun");
        try(Config config = ConfigFactory.get()) {
            for(PerunMappingDTO mapping : mappings) {
                if (StringUtil.isEmpty(mapping.getId()) || StringUtil.isEmpty(mapping.getName())) {
                    logger.error("Perun mapping has no ID or no name: {}", mapping.getId());
                    logger.error("Aborting synchronization");
                    NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, "No ID or name: " + mapping.getId());
                    //return Response.status(Response.Status.BAD_REQUEST).build();
                }
                DbUtil.savePerunNetworkMapping(config, mapping);
            }


            return Response.ok().build();
        } catch (Exception e) {
            logger.error("9bca4ebabf89-Perun ERROR-NG-0000055: Error syncing user network mapping from perun.");
            e.printStackTrace();
            NegotiatorStatus.get().newFailStatus(NegotiatorStatus.NegotiatorTaskType.PERUN_MAPPING, e.getMessage());
            return Response.serverError().build();
        }
    }

    private void updateCollectionMappingCount(String directory) {
        if(!mapping_updates_collections.containsKey(directory)) {
            mapping_updates_collections.put(directory, 0);
        }
        mapping_updates_collections.put(directory, mapping_updates_collections.get(directory) + 1);
    }

    private String generateSatusUpdateString() {
        String msg = "Mappings: \n";
        for(String key : mapping_updates_collections.keySet()) {
            msg += key + ": " + mapping_updates_collections.get(key) + "\n";
        }
        return msg;
    }
}
