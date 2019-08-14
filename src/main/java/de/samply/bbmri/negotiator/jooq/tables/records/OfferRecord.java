/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.records;


import de.samply.bbmri.negotiator.jooq.tables.Offer;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * table to store private conversation made on a query between two people(owner 
 * and researcher)
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OfferRecord extends UpdatableRecordImpl<OfferRecord> implements Record6<Integer, Integer, Integer, Integer, Timestamp, String> {

	private static final long serialVersionUID = 987200976;

	/**
	 * Setter for <code>public.offer.id</code>. Primary key
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>public.offer.id</code>. Primary key
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>public.offer.query_id</code>. Foreign key which exists as primary key in the query table. 
	 */
	public void setQueryId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>public.offer.query_id</code>. Foreign key which exists as primary key in the query table. 
	 */
	public Integer getQueryId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>public.offer.person_id</code>. Foreign key which exists as primary key in the person table. describes the person who made the comment.
	 */
	public void setPersonId(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>public.offer.person_id</code>. Foreign key which exists as primary key in the person table. describes the person who made the comment.
	 */
	public Integer getPersonId() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>public.offer.biobank_in_private_chat</code>. Foreign key which exists as primary key in the person table. describes the owner of the samples who made the offer.
	 */
	public void setBiobankInPrivateChat(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>public.offer.biobank_in_private_chat</code>. Foreign key which exists as primary key in the person table. describes the owner of the samples who made the offer.
	 */
	public Integer getBiobankInPrivateChat() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>public.offer.comment_time</code>. timestamp of when the comment was made on the offer.
	 */
	public void setCommentTime(Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>public.offer.comment_time</code>. timestamp of when the comment was made on the offer.
	 */
	public Timestamp getCommentTime() {
		return (Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>public.offer.text</code>. Text of the comment.
	 */
	public void setText(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>public.offer.text</code>. Text of the comment.
	 */
	public String getText() {
		return (String) getValue(5);
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
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Integer, Integer, Integer, Timestamp, String> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, Integer, Integer, Integer, Timestamp, String> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Offer.OFFER.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Offer.OFFER.QUERY_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return Offer.OFFER.PERSON_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Offer.OFFER.BIOBANK_IN_PRIVATE_CHAT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field5() {
		return Offer.OFFER.COMMENT_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return Offer.OFFER.TEXT;
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
	public Integer value2() {
		return getQueryId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getPersonId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getBiobankInPrivateChat();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value5() {
		return getCommentTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getText();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value2(Integer value) {
		setQueryId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value3(Integer value) {
		setPersonId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value4(Integer value) {
		setBiobankInPrivateChat(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value5(Timestamp value) {
		setCommentTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord value6(String value) {
		setText(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OfferRecord values(Integer value1, Integer value2, Integer value3, Integer value4, Timestamp value5, String value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached OfferRecord
	 */
	public OfferRecord() {
		super(Offer.OFFER);
	}

	/**
	 * Create a detached, initialised OfferRecord
	 */
	public OfferRecord(Integer id, Integer queryId, Integer personId, Integer biobankInPrivateChat, Timestamp commentTime, String text) {
		super(Offer.OFFER);

		setValue(0, id);
		setValue(1, queryId);
		setValue(2, personId);
		setValue(3, biobankInPrivateChat);
		setValue(4, commentTime);
		setValue(5, text);
	}
}
