package eu.bbmri.eric.csit.service.negotiator.notification.types;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;
import de.samply.bbmri.negotiator.jooq.tables.records.MailNotificationRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.NotificationRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.PersonRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.QueryRecord;
import eu.bbmri.eric.csit.service.negotiator.database.DatabaseUtil;
import eu.bbmri.eric.csit.service.negotiator.notification.model.NotificationEmailMassage;
import eu.bbmri.eric.csit.service.negotiator.notification.util.NotificationContacts;
import eu.bbmri.eric.csit.service.negotiator.notification.util.NotificationMailSendQueue;
import eu.bbmri.eric.csit.service.negotiator.notification.util.NotificationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Notification extends Thread {

    private static final Logger abstractLogger = LoggerFactory.getLogger(Notification.class);
    private static final String MAIN_MAIL_TEMPLATE = "NegotiatorMainMailTemplate.soy";
    private final File templateFolder = new File(getClass().getClassLoader().getResource("mailTemplate").getPath());
    private SoyTofu.Renderer mailBodyRenderer;

    protected DatabaseUtil databaseUtil = new DatabaseUtil();
    protected NotificationContacts notificationContacts = new NotificationContacts();
    protected NotificationMailSendQueue notificationMailSendQueue = NotificationMailSendQueue.getNotificationSendQueue();
    protected Integer requestId;
    protected NotificationRecord notificationRecord;
    protected Integer personId;
    protected Integer commentId;
    protected QueryRecord queryRecord;
    protected String researcherName;
    protected String researcherEmailAddresse;

    @Override
    public void run() {

    }

    protected MailNotificationRecord saveMailNotificationToDatabase(String emailAddress, String subject, String body) {
        return databaseUtil.getDatabaseUtilNotification().addMailNotificationEntry(emailAddress, notificationRecord.getNotificationId(), notificationRecord.getPersonId(), "created", subject, body);
    }

    protected void sendMailNotification(Integer mailNotificationId, String recipient, String subject, String body) {
        notificationMailSendQueue.addNotificationToQueue(mailNotificationId);
        notificationMailSendQueue.addNotificationEmailMassages(mailNotificationId, new NotificationEmailMassage(mailNotificationId, recipient, subject, body));
    }

    protected void updateMailNotificationInDatabase(Integer mailNotificationRecordId, String status) {
        databaseUtil.getDatabaseUtilNotification().updateMailNotificationEntryStatus(mailNotificationRecordId, status);
    }

    protected boolean checkSendNotificationImmediatelyForUser(String emailAddress, Integer notificationType) {
        //TODO: Needs Implementation for future release.
        if(emailAddress == null) {
            abstractLogger.info("EmailAddress Not Set");
        }
        if(notificationType == null) {
            abstractLogger.info("NotificationType Not Set");
            return false;
        }
        switch(notificationType) {
            case NotificationType.APPROVE_REQUEST_NOTIFICATION:
                return true;
            case NotificationType.NOT_REACHABLE_COLLECTION_NOTIFICATION:
                return true;
            case NotificationType.CREATE_REQUEST_NOTIFICATION:
                return true;
            case NotificationType.REJECT_REQUEST_NOTIFICATION:
                return true;
            case NotificationType.START_NEGOTIATION_NOTIFICATION:
                return true;
            case NotificationType.STATUS_CHANGED_NOTIFICATION:
                return false;
            case NotificationType.PRIVATE_COMMAND_NOTIFICATION:
                return false;
            case NotificationType.PUBLIC_COMMAND_NOTIFICATION:
                return false;
            case NotificationType.TEST_NOTIFICATION:
                return true;
            case NotificationType.AGGREGATED_NOTIFICATION:
                return true;
            case NotificationType.ADDED_COLLECTIONS_TO_STARTED_NEGOTIATION_NOTIFICATION:
                return true;
            default:
                abstractLogger.error("ERROR-NG-0000089: Notification Type Not defined");
                return true;
        }
    }

    protected void createMailBodyBuilder(String mailTemplateFile) {
        try {
            SoyFileSet.Builder builder = SoyFileSet.builder();
            builder.add(new File(templateFolder.getAbsolutePath(), MAIN_MAIL_TEMPLATE));
            builder.add(new File(templateFolder.getAbsolutePath(), mailTemplateFile));
            SoyFileSet soyFileSet = builder.build();
            SoyTofu soyTofu = soyFileSet.compileToTofu();
            mailBodyRenderer = soyTofu.newRenderer("eu.negotiator.mailing.mail");
            Set<String> delegatePackageNames = new HashSet<>();
            delegatePackageNames.add("Notification");
            mailBodyRenderer.setActiveDelegatePackageNames(delegatePackageNames);
        } catch (Exception ex) {
            abstractLogger.error("37de50547358-Notification ERROR-NG-0000017: Error creating mail body template.");
            abstractLogger.error(ex.getLocalizedMessage());
            abstractLogger.error(ex.getLocalizedMessage());
        }
    }

    protected String getMailBody(Map<String, String> parameters) {
        if(mailBodyRenderer == null) {
            abstractLogger.error("37de50547358-Notification ERROR-NG-0000018: Error mail body renderer not defined.");
            return "";
        }
        mailBodyRenderer.setData(parameters);
        return mailBodyRenderer.render();
    }

    protected void setQuery() {
        queryRecord = databaseUtil.getDatabaseUtilRequest().getQuery(requestId);
    }

    protected void setResearcherContact() {
        PersonRecord personRecord = databaseUtil.getDatabaseUtilPerson().getPerson(queryRecord.getResearcherId());
        notificationContacts.setResearcherPerson(personRecord);
        researcherName = personRecord.getAuthName();
        researcherEmailAddresse = personRecord.getAuthEmail();
    }

}
