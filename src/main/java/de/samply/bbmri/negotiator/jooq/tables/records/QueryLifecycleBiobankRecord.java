/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.records;


import de.samply.bbmri.negotiator.jooq.tables.QueryLifecycleBiobank;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class QueryLifecycleBiobankRecord extends TableRecordImpl<QueryLifecycleBiobankRecord> implements Record5<Integer, Integer, Integer, String, Timestamp> {

	private static final long serialVersionUID = -1948483954;

	/**
	 * Setter for <code>public.query_lifecycle_biobank.query_id</code>.
	 */
	public void setQueryId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.query_lifecycle_biobank.query_id</code>.
	 */
	public Integer getQueryId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.query_lifecycle_biobank.person_id</code>.
	 */
	public void setPersonId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.query_lifecycle_biobank.person_id</code>.
	 */
	public Integer getPersonId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.query_lifecycle_biobank.biobank_id</code>.
	 */
	public void setBiobankId(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.query_lifecycle_biobank.biobank_id</code>.
	 */
	public Integer getBiobankId() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>public.query_lifecycle_biobank.status</code>.
	 */
	public void setStatus(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.query_lifecycle_biobank.status</code>.
	 */
	public String getStatus() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>public.query_lifecycle_biobank.lifecycle_time</code>.
	 */
	public void setLifecycleTime(Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.query_lifecycle_biobank.lifecycle_time</code>.
	 */
	public Timestamp getLifecycleTime() {
		return (Timestamp) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, Integer, Integer, String, Timestamp> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, Integer, Integer, String, Timestamp> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK.QUERY_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK.PERSON_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK.BIOBANK_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK.STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field5() {
		return QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK.LIFECYCLE_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getQueryId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getPersonId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getBiobankId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value5() {
		return getLifecycleTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord value1(Integer value) {
		setQueryId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord value2(Integer value) {
		setPersonId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord value3(Integer value) {
		setBiobankId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord value4(String value) {
		setStatus(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord value5(Timestamp value) {
		setLifecycleTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryLifecycleBiobankRecord values(Integer value1, Integer value2, Integer value3, String value4, Timestamp value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached QueryLifecycleBiobankRecord
	 */
	public QueryLifecycleBiobankRecord() {
		super(QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK);
	}

	/**
	 * Create a detached, initialised QueryLifecycleBiobankRecord
	 */
	public QueryLifecycleBiobankRecord(Integer queryId, Integer personId, Integer biobankId, String status, Timestamp lifecycleTime) {
		super(QueryLifecycleBiobank.QUERY_LIFECYCLE_BIOBANK);

		setValue(0, queryId);
		setValue(1, personId);
		setValue(2, biobankId);
		setValue(3, status);
		setValue(4, lifecycleTime);
	}
}
