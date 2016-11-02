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

package de.samply.bbmri.negotiator.config;

import de.samply.common.config.OAuth2Client;
import de.samply.common.config.Postgresql;
import de.samply.common.config.Proxy;
import de.samply.common.mailing.MailSending;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;

/**
 * The main configuration for the negotiator configuration.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Negotiator implements Serializable {

    private static final long serialVersionUID = 6899649893727493806L;

    /**
     * The Molgenis resource name for the biobanks
     */
    @XmlElement
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String molgenisResourceBiobanks;

    /**
     * The Molgenis resource name for the biobanks
     */
    @XmlElement
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String molgenisResourceCollections;

    /**
     * The URL for the synchronization with the directory.
     */
    @XmlElement
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String molgenisUrl;

    /**
     * The password that molgenis will use for the directory REST endpoint
     */
    @XmlElement
    private String molgenisPassword;

    /**
     * The username that molgenis will use for the directory REST endpoint
     */
    @XmlElement
    private String molgenisUsername;

    /**
     * The folder for attachments
     */
    @XmlElement
    private String attachmentPath;

    /**
     * The database configuration.
     */
    @XmlElement
    private Postgresql postgresql;

    /**
     * The OAuth2 Client configuration.
     */
    @XmlElement
    private OAuth2Client oAuth2Client;

    /**
     * The proxy configuration for outgoing HTTP/S connections
     */
    @XmlElement
    private Proxy proxy;
    
    /**
     * Turns mailing on/off
     */
    @XmlElement
    private boolean mailEnabled;

    /**
     * The email configuration, including the SMTP settings.
     */
    @XmlElement
    private MailSending mailSending;

    public Postgresql getPostgresql() {
        return postgresql;
    }

    public void setPostgresql(Postgresql postgresql) {
        this.postgresql = postgresql;
    }

    public OAuth2Client getoAuth2Client() {
        return oAuth2Client;
    }

    public void setoAuth2Client(OAuth2Client oAuth2Client) {
        this.oAuth2Client = oAuth2Client;
    }

    public MailSending getMailSending() {
        return mailSending;
    }

    public void setMailSending(MailSending mailSending) {
        this.mailSending = mailSending;
    }

    public String getMolgenisUsername() {
        return molgenisUsername;
    }

    public void setMolgenisUsername(String molgenisUsername) {
        this.molgenisUsername = molgenisUsername;
    }

    public String getMolgenisPassword() {
        return molgenisPassword;
    }

    public void setMolgenisPassword(String molgenisPassword) {
        this.molgenisPassword = molgenisPassword;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getMolgenisUrl() {
        return molgenisUrl;
    }

    public void setMolgenisUrl(String molgenisUrl) {
        this.molgenisUrl = molgenisUrl;
    }

    public String getMolgenisResourceBiobanks() {
        return molgenisResourceBiobanks;
    }

    public void setMolgenisResourceBiobanks(String molgenisResourceBiobanks) {
        this.molgenisResourceBiobanks = molgenisResourceBiobanks;
    }

    public String getMolgenisResourceCollections() {
        return molgenisResourceCollections;
    }

    public void setMolgenisResourceCollections(String molgenisResourceCollections) {
        this.molgenisResourceCollections = molgenisResourceCollections;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }
    
    public boolean getMailEnabled() {
        return mailEnabled;
    }

    public void setMailEnabled(boolean mailEnabled) {
        this.mailEnabled = mailEnabled;
    }

}
