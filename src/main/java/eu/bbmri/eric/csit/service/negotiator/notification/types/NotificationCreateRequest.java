package eu.bbmri.eric.csit.service.negotiator.notification.types;

import de.samply.bbmri.negotiator.NegotiatorConfig;
import de.samply.bbmri.negotiator.jooq.tables.records.MailNotificationRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.NotificationRecord;
import eu.bbmri.eric.csit.service.negotiator.notification.util.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class NotificationCreateRequest extends Notification {
    private static final Logger logger = LoggerFactory.getLogger(NotificationCreateRequest.class);

    public NotificationCreateRequest(NotificationRecord notificationRecord, Integer requestId, Integer personId) {
        logger.info("919bbece7131-NotificationCreateRequest new request created.");
        this.requestId = requestId;
        this.notificationRecord = notificationRecord;
        this.personId = personId;
        start();
    }

    @Override
    public void run() {
        try {
            setQuery();
            setResearcherContact();

            createMailBodyBuilder("BBMRI_CREATE_REQUEST.soy");

            prepareNotificationForBBMRIERIC(getMailSubject());
        } catch (Exception ex) {
            logger.error("919bbece7131-NotificationCreateRequest ERROR-NG-0000058: Error in NotificationCreateRequest.");
            logger.error("context", ex);
        }
    }

    private String getMailSubject() {
        if(queryRecord.getTestRequest()) {
            return "[BBMRI-ERIC Negotiator] TEST Request: New request created for review: " + queryRecord.getTitle();
        } else {
            return "[BBMRI-ERIC Negotiator] New request created for review: " + queryRecord.getTitle();
        }
    }

    private void prepareNotificationForBBMRIERIC(String subject) {
        String bbmriemail = "negotiator-requests@helpdesk.bbmri-eric.eu";
        try {
            String body = getMailBody(getSoyParameters());

            MailNotificationRecord mailNotificationRecord = saveMailNotificationToDatabase(bbmriemail, subject, body);
            if(checkSendNotificationImmediatelyForUser(bbmriemail, NotificationType.CREATE_REQUEST_NOTIFICATION)) {
                sendMailNotification(mailNotificationRecord.getMailNotificationId(), bbmriemail, subject, body);
            }
        } catch (Exception ex) {
            logger.error(String.format("919bbece7131-NotificationCreateRequest ERROR-NG-0000059: Error creating a notification for reviewer %s.", bbmriemail));
            logger.error("context", ex);
        }
    }

    private Map<String, String> getSoyParameters() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("queryName", queryRecord.getTitle());
        parameters.put("queryId", queryRecord.getId().toString());
        parameters.put("url", NegotiatorConfig.get().getNegotiator().getNegotiatorUrl() + "reviewer/review.xhtml");
        return parameters;
    }
}
