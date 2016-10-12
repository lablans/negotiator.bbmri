/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.records;


import de.samply.bbmri.negotiator.jooq.tables.Query;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class QueryRecord extends UpdatableRecordImpl<QueryRecord> implements Record7<Integer, String, String, Timestamp, Integer, String, String> {

	private static final long serialVersionUID = -1250895248;

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
	 * Setter for <code>public.query.negotiator_token</code>.
	 */
	public void setNegotiatorToken(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>public.query.negotiator_token</code>.
	 */
	public String getNegotiatorToken() {
		return (String) getValue(6);
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
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Integer, String, String, Timestamp, Integer, String, String> fieldsRow() {
		return (Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Integer, String, String, Timestamp, Integer, String, String> valuesRow() {
		return (Row7) super.valuesRow();
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
	public Field<String> field7() {
		return Query.QUERY.NEGOTIATOR_TOKEN;
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
	public String value7() {
		return getNegotiatorToken();
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
	public QueryRecord value7(String value) {
		setNegotiatorToken(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryRecord values(Integer value1, String value2, String value3, Timestamp value4, Integer value5, String value6, String value7) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
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
	public QueryRecord(Integer id, String title, String text, Timestamp queryCreationTime, Integer researcherId, String jsonText, String negotiatorToken) {
		super(Query.QUERY);

		setValue(0, id);
		setValue(1, title);
		setValue(2, text);
		setValue(3, queryCreationTime);
		setValue(4, researcherId);
		setValue(5, jsonText);
		setValue(6, negotiatorToken);
	}
}
