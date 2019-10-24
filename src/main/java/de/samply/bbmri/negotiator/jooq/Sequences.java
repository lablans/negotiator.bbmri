/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.biobank_id_seq</code>
	 */
	public static final Sequence<Long> BIOBANK_ID_SEQ = new SequenceImpl<Long>("biobank_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.collection_id_seq</code>
	 */
	public static final Sequence<Long> COLLECTION_ID_SEQ = new SequenceImpl<Long>("collection_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.comment_id_seq</code>
	 */
	public static final Sequence<Long> COMMENT_ID_SEQ = new SequenceImpl<Long>("comment_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.connector_log_id_seq</code>
	 */
	public static final Sequence<Long> CONNECTOR_LOG_ID_SEQ = new SequenceImpl<Long>("connector_log_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.json_query_id_seq</code>
	 */
	public static final Sequence<Long> JSON_QUERY_ID_SEQ = new SequenceImpl<Long>("json_query_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.list_of_directories_id_seq</code>
	 */
	public static final Sequence<Long> LIST_OF_DIRECTORIES_ID_SEQ = new SequenceImpl<Long>("list_of_directories_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.network_id_seq</code>
	 */
	public static final Sequence<Long> NETWORK_ID_SEQ = new SequenceImpl<Long>("network_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.offer_id_seq</code>
	 */
	public static final Sequence<Long> OFFER_ID_SEQ = new SequenceImpl<Long>("offer_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.person_id_seq</code>
	 */
	public static final Sequence<Long> PERSON_ID_SEQ = new SequenceImpl<Long>("person_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.query_attachment_comment_id_seq</code>
	 */
	public static final Sequence<Long> QUERY_ATTACHMENT_COMMENT_ID_SEQ = new SequenceImpl<Long>("query_attachment_comment_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.query_attachment_id_seq</code>
	 */
	public static final Sequence<Long> QUERY_ATTACHMENT_ID_SEQ = new SequenceImpl<Long>("query_attachment_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.query_attachment_private_id_seq</code>
	 */
	public static final Sequence<Long> QUERY_ATTACHMENT_PRIVATE_ID_SEQ = new SequenceImpl<Long>("query_attachment_private_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>public.query_id_seq</code>
	 */
	public static final Sequence<Long> QUERY_ID_SEQ = new SequenceImpl<Long>("query_id_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
