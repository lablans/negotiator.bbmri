/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.records;


import de.samply.bbmri.negotiator.jooq.tables.Query;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * query table to contain all  queries
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QueryRecord extends UpdatableRecordImpl<QueryRecord> implements Record16<Integer, String, String, Timestamp, Integer, String, Integer, String, Boolean, String, String, String, Timestamp, String, String, String> {

	private static final long serialVersionUID = 655832827;

	/**
	 * Setter for <code>public.query.id</code>. primary key
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.query.id</code>. primary key
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.query.title</code>. title of query
	 */
	public void setTitle(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.query.title</code>. title of query
	 */
	public String getTitle() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>public.query.text</code>. text of query
	 */
	public void setText(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.query.text</code>. text of query
	 */
	public String getText() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>public.query.query_creation_time</code>. date and time of query with out time zone
	 */
	public void setQueryCreationTime(Timestamp value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.query.query_creation_time</code>. date and time of query with out time zone
	 */
	public Timestamp getQueryCreationTime() {
		return (Timestamp) getValue(3);
	}

	/**
	 * Setter for <code>public.query.researcher_id</code>. Foreign key. Exists as primary key in the researcher table(which takes it in turn from the person table)
	 */
	public void setResearcherId(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.query.researcher_id</code>. Foreign key. Exists as primary key in the researcher table(which takes it in turn from the person table)
	 */
	public Integer getResearcherId() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>public.query.json_text</code>.
	 */
	public void setJsonText(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.query.json_text</code>.
	 */
	public String getJsonText() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>public.query.num_attachments</code>. number of attachments ever associated with this query - both existing and deleted, used as an index for naming future attachments
	 */
	public void setNumAttachments(Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.query.num_attachments</code>. number of attachments ever associated with this query - both existing and deleted, used as an index for naming future attachments
	 */
	public Integer getNumAttachments() {
		return (Integer) getValue(6);
	}

	/**
	 * Setter for <code>public.query.negotiator_token</code>.
	 */
	public void setNegotiatorToken(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>public.query.negotiator_token</code>.
	 */
	public String getNegotiatorToken() {
		return (String) getValue(7);
	}

	/**
	 * Setter for <code>public.query.valid_query</code>.
	 */
	public void setValidQuery(Boolean value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>public.query.valid_query</code>.
	 */
	public Boolean getValidQuery() {
		return (Boolean) getValue(8);
	}

	/**
	 * Setter for <code>public.query.request_description</code>.
	 */
	public void setRequestDescription(String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>public.query.request_description</code>.
	 */
	public String getRequestDescription() {
		return (String) getValue(9);
	}

	/**
	 * Setter for <code>public.query.query_xml</code>.
	 */
	public void setQueryXml(String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>public.query.query_xml</code>.
	 */
	public String getQueryXml() {
		return (String) getValue(10);
	}

	/**
	 * Setter for <code>public.query.ethics_vote</code>.
	 */
	public void setEthicsVote(String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>public.query.ethics_vote</code>.
	 */
	public String getEthicsVote() {
		return (String) getValue(11);
	}

	/**
	 * Setter for <code>public.query.negotiation_started_time</code>.
	 */
	public void setNegotiationStartedTime(Timestamp value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>public.query.negotiation_started_time</code>.
	 */
	public Timestamp getNegotiationStartedTime() {
		return (Timestamp) getValue(12);
	}

	/**
	 * Setter for <code>public.query.researcher_name</code>.
	 */
	public void setResearcherName(String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>public.query.researcher_name</code>.
	 */
	public String getResearcherName() {
		return (String) getValue(13);
	}

	/**
	 * Setter for <code>public.query.researcher_email</code>.
	 */
	public void setResearcherEmail(String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>public.query.researcher_email</code>.
	 */
	public String getResearcherEmail() {
		return (String) getValue(14);
	}

	/**
	 * Setter for <code>public.query.researcher_organization</code>.
	 */
	public void setResearcherOrganization(String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>public.query.researcher_organization</code>.
	 */
	public String getResearcherOrganization() {
		return (String) getValue(15);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record16 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row16<Integer, String, String, Timestamp, Integer, String, Integer, String, Boolean, String, String, String, Timestamp, String, String, String> fieldsRow() {
		return (Row16) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row16<Integer, String, String, Timestamp, Integer, String, Integer, String, Boolean, String, String, String, Timestamp, String, String, String> valuesRow() {
		return (Row16) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Query.QUERY.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Query.QUERY.TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Query.QUERY.TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field4() {
		return Query.QUERY.QUERY_CREATION_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return Query.QUERY.RESEARCHER_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return Query.QUERY.JSON_TEXT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field7() {
		return Query.QUERY.NUM_ATTACHMENTS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return Query.QUERY.NEGOTIATOR_TOKEN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field9() {
		return Query.QUERY.VALID_QUERY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field10() {
		return Query.QUERY.REQUEST_DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field11() {
		return Query.QUERY.QUERY_XML;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field12() {
		return Query.QUERY.ETHICS_VOTE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field13() {
		return Query.QUERY.NEGOTIATION_STARTED_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field14() {
		return Query.QUERY.RESEARCHER_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field15() {
		return Query.QUERY.RESEARCHER_EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field16() {
		return Query.QUERY.RESEARCHER_ORGANIZATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value4() {
		return getQueryCreationTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getResearcherId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getJsonText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value7() {
		return getNumAttachments();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getNegotiatorToken();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value9() {
		return getValidQuery();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value10() {
		return getRequestDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value11() {
		return getQueryXml();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value12() {
		return getEthicsVote();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value13() {
		return getNegotiationStartedTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value14() {
		return getResearcherName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value15() {
		return getResearcherEmail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value16() {
		return getResearcherOrganization();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value2(String value) {
		setTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value3(String value) {
		setText(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value4(Timestamp value) {
		setQueryCreationTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value5(Integer value) {
		setResearcherId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value6(String value) {
		setJsonText(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value7(Integer value) {
		setNumAttachments(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value8(String value) {
		setNegotiatorToken(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value9(Boolean value) {
		setValidQuery(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value10(String value) {
		setRequestDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value11(String value) {
		setQueryXml(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value12(String value) {
		setEthicsVote(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value13(Timestamp value) {
		setNegotiationStartedTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value14(String value) {
		setResearcherName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value15(String value) {
		setResearcherEmail(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord value16(String value) {
		setResearcherOrganization(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord values(Integer value1, String value2, String value3, Timestamp value4, Integer value5, String value6, Integer value7, String value8, Boolean value9, String value10, String value11, String value12, Timestamp value13, String value14, String value15, String value16) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		value12(value12);
		value13(value13);
		value14(value14);
		value15(value15);
		value16(value16);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached QueryRecord
	 */
	public QueryRecord() {
		super(Query.QUERY);
	}

	/**
	 * Create a detached, initialised QueryRecord
	 */
	public QueryRecord(Integer id, String title, String text, Timestamp queryCreationTime, Integer researcherId, String jsonText, Integer numAttachments, String negotiatorToken, Boolean validQuery, String requestDescription, String queryXml, String ethicsVote, Timestamp negotiationStartedTime, String researcherName, String researcherEmail, String researcherOrganization) {
		super(Query.QUERY);

		setValue(0, id);
		setValue(1, title);
		setValue(2, text);
		setValue(3, queryCreationTime);
		setValue(4, researcherId);
		setValue(5, jsonText);
		setValue(6, numAttachments);
		setValue(7, negotiatorToken);
		setValue(8, validQuery);
		setValue(9, requestDescription);
		setValue(10, queryXml);
		setValue(11, ethicsVote);
		setValue(12, negotiationStartedTime);
		setValue(13, researcherName);
		setValue(14, researcherEmail);
		setValue(15, researcherOrganization);
	}
}
