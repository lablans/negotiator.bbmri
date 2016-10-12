/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq;


import de.samply.bbmri.negotiator.jooq.tables.Comment;
import de.samply.bbmri.negotiator.jooq.tables.FlaggedQuery;
import de.samply.bbmri.negotiator.jooq.tables.JsonQuery;
import de.samply.bbmri.negotiator.jooq.tables.Location;
import de.samply.bbmri.negotiator.jooq.tables.Person;
import de.samply.bbmri.negotiator.jooq.tables.Query;
import de.samply.bbmri.negotiator.jooq.tables.QueryPerson;
import de.samply.bbmri.negotiator.jooq.tables.Role;
import de.samply.bbmri.negotiator.jooq.tables.Tag;
import de.samply.bbmri.negotiator.jooq.tables.TaggedQuery;
import de.samply.bbmri.negotiator.jooq.tables.records.CommentRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.FlaggedQueryRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.JsonQueryRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.LocationRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.PersonRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.QueryPersonRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.QueryRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.RoleRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.TagRecord;
import de.samply.bbmri.negotiator.jooq.tables.records.TaggedQueryRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>public</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final Identity<CommentRecord, Integer> IDENTITY_COMMENT = Identities0.IDENTITY_COMMENT;
	public static final Identity<JsonQueryRecord, Integer> IDENTITY_JSON_QUERY = Identities0.IDENTITY_JSON_QUERY;
	public static final Identity<LocationRecord, Integer> IDENTITY_LOCATION = Identities0.IDENTITY_LOCATION;
	public static final Identity<PersonRecord, Integer> IDENTITY_PERSON = Identities0.IDENTITY_PERSON;
	public static final Identity<QueryRecord, Integer> IDENTITY_QUERY = Identities0.IDENTITY_QUERY;
	public static final Identity<TagRecord, Integer> IDENTITY_TAG = Identities0.IDENTITY_TAG;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<CommentRecord> COMMENT_PKEY = UniqueKeys0.COMMENT_PKEY;
	public static final UniqueKey<FlaggedQueryRecord> FLAGGED_QUERY_PKEY = UniqueKeys0.FLAGGED_QUERY_PKEY;
	public static final UniqueKey<JsonQueryRecord> JSON_QUERY_PKEY = UniqueKeys0.JSON_QUERY_PKEY;
	public static final UniqueKey<LocationRecord> LOCATION_PKEY = UniqueKeys0.LOCATION_PKEY;
	public static final UniqueKey<LocationRecord> LOCATION_DIRECTORY_ID_KEY = UniqueKeys0.LOCATION_DIRECTORY_ID_KEY;
	public static final UniqueKey<PersonRecord> PERSON_PKEY = UniqueKeys0.PERSON_PKEY;
	public static final UniqueKey<PersonRecord> PERSON_AUTH_SUBJECT_KEY = UniqueKeys0.PERSON_AUTH_SUBJECT_KEY;
	public static final UniqueKey<QueryRecord> QUERY_PKEY = UniqueKeys0.QUERY_PKEY;
	public static final UniqueKey<QueryRecord> QUERY_NEGOTIATOR_TOKEN_KEY = UniqueKeys0.QUERY_NEGOTIATOR_TOKEN_KEY;
	public static final UniqueKey<QueryPersonRecord> QUERY_PERSON_PKEY = UniqueKeys0.QUERY_PERSON_PKEY;
	public static final UniqueKey<RoleRecord> ROLE_PKEY = UniqueKeys0.ROLE_PKEY;
	public static final UniqueKey<TagRecord> TAG_PKEY = UniqueKeys0.TAG_PKEY;
	public static final UniqueKey<TaggedQueryRecord> TAGGED_QUERY_PKEY = UniqueKeys0.TAGGED_QUERY_PKEY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<CommentRecord, QueryRecord> COMMENT__COMMENT_QUERY_ID_FKEY = ForeignKeys0.COMMENT__COMMENT_QUERY_ID_FKEY;
	public static final ForeignKey<CommentRecord, PersonRecord> COMMENT__COMMENT_PERSON_ID_FKEY = ForeignKeys0.COMMENT__COMMENT_PERSON_ID_FKEY;
	public static final ForeignKey<FlaggedQueryRecord, QueryRecord> FLAGGED_QUERY__FLAGGED_QUERY_QUERY_ID_FKEY = ForeignKeys0.FLAGGED_QUERY__FLAGGED_QUERY_QUERY_ID_FKEY;
	public static final ForeignKey<FlaggedQueryRecord, PersonRecord> FLAGGED_QUERY__FLAGGED_QUERY_PERSON_ID_FKEY = ForeignKeys0.FLAGGED_QUERY__FLAGGED_QUERY_PERSON_ID_FKEY;
	public static final ForeignKey<PersonRecord, LocationRecord> PERSON__PERSON_LOCATION_ID_FKEY = ForeignKeys0.PERSON__PERSON_LOCATION_ID_FKEY;
	public static final ForeignKey<QueryRecord, PersonRecord> QUERY__QUERY_RESEARCHER_ID_FKEY = ForeignKeys0.QUERY__QUERY_RESEARCHER_ID_FKEY;
	public static final ForeignKey<QueryPersonRecord, QueryRecord> QUERY_PERSON__QUERY_PERSON_QUERY_ID_FKEY = ForeignKeys0.QUERY_PERSON__QUERY_PERSON_QUERY_ID_FKEY;
	public static final ForeignKey<QueryPersonRecord, PersonRecord> QUERY_PERSON__QUERY_PERSON_PERSON_ID_FKEY = ForeignKeys0.QUERY_PERSON__QUERY_PERSON_PERSON_ID_FKEY;
	public static final ForeignKey<RoleRecord, PersonRecord> ROLE__ROLE_PERSON_ID_FKEY = ForeignKeys0.ROLE__ROLE_PERSON_ID_FKEY;
	public static final ForeignKey<RoleRecord, PersonRecord> ROLE__ROLE_PERSON_ID_FKEY1 = ForeignKeys0.ROLE__ROLE_PERSON_ID_FKEY1;
	public static final ForeignKey<TagRecord, QueryRecord> TAG__TAG_QUERY_ID_FKEY = ForeignKeys0.TAG__TAG_QUERY_ID_FKEY;
	public static final ForeignKey<TaggedQueryRecord, QueryRecord> TAGGED_QUERY__TAGGED_QUERY_QUERY_ID_FKEY = ForeignKeys0.TAGGED_QUERY__TAGGED_QUERY_QUERY_ID_FKEY;
	public static final ForeignKey<TaggedQueryRecord, TagRecord> TAGGED_QUERY__TAGGED_QUERY_TAG_ID_FKEY = ForeignKeys0.TAGGED_QUERY__TAGGED_QUERY_TAG_ID_FKEY;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends AbstractKeys {
		public static Identity<CommentRecord, Integer> IDENTITY_COMMENT = createIdentity(Comment.COMMENT, Comment.COMMENT.ID);
		public static Identity<JsonQueryRecord, Integer> IDENTITY_JSON_QUERY = createIdentity(JsonQuery.JSON_QUERY, JsonQuery.JSON_QUERY.ID);
		public static Identity<LocationRecord, Integer> IDENTITY_LOCATION = createIdentity(Location.LOCATION, Location.LOCATION.ID);
		public static Identity<PersonRecord, Integer> IDENTITY_PERSON = createIdentity(Person.PERSON, Person.PERSON.ID);
		public static Identity<QueryRecord, Integer> IDENTITY_QUERY = createIdentity(Query.QUERY, Query.QUERY.ID);
		public static Identity<TagRecord, Integer> IDENTITY_TAG = createIdentity(Tag.TAG, Tag.TAG.ID);
	}

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<CommentRecord> COMMENT_PKEY = createUniqueKey(Comment.COMMENT, Comment.COMMENT.ID);
		public static final UniqueKey<FlaggedQueryRecord> FLAGGED_QUERY_PKEY = createUniqueKey(FlaggedQuery.FLAGGED_QUERY, FlaggedQuery.FLAGGED_QUERY.QUERY_ID, FlaggedQuery.FLAGGED_QUERY.PERSON_ID);
		public static final UniqueKey<JsonQueryRecord> JSON_QUERY_PKEY = createUniqueKey(JsonQuery.JSON_QUERY, JsonQuery.JSON_QUERY.ID);
		public static final UniqueKey<LocationRecord> LOCATION_PKEY = createUniqueKey(Location.LOCATION, Location.LOCATION.ID);
		public static final UniqueKey<LocationRecord> LOCATION_DIRECTORY_ID_KEY = createUniqueKey(Location.LOCATION, Location.LOCATION.DIRECTORY_ID);
		public static final UniqueKey<PersonRecord> PERSON_PKEY = createUniqueKey(Person.PERSON, Person.PERSON.ID);
		public static final UniqueKey<PersonRecord> PERSON_AUTH_SUBJECT_KEY = createUniqueKey(Person.PERSON, Person.PERSON.AUTH_SUBJECT);
		public static final UniqueKey<QueryRecord> QUERY_PKEY = createUniqueKey(Query.QUERY, Query.QUERY.ID);
		public static final UniqueKey<QueryRecord> QUERY_NEGOTIATOR_TOKEN_KEY = createUniqueKey(Query.QUERY, Query.QUERY.NEGOTIATOR_TOKEN);
		public static final UniqueKey<QueryPersonRecord> QUERY_PERSON_PKEY = createUniqueKey(QueryPerson.QUERY_PERSON, QueryPerson.QUERY_PERSON.QUERY_ID, QueryPerson.QUERY_PERSON.PERSON_ID);
		public static final UniqueKey<RoleRecord> ROLE_PKEY = createUniqueKey(Role.ROLE, Role.ROLE.ROLE_TYPE, Role.ROLE.PERSON_ID);
		public static final UniqueKey<TagRecord> TAG_PKEY = createUniqueKey(Tag.TAG, Tag.TAG.ID);
		public static final UniqueKey<TaggedQueryRecord> TAGGED_QUERY_PKEY = createUniqueKey(TaggedQuery.TAGGED_QUERY, TaggedQuery.TAGGED_QUERY.QUERY_ID, TaggedQuery.TAGGED_QUERY.TAG_ID);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<CommentRecord, QueryRecord> COMMENT__COMMENT_QUERY_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.QUERY_PKEY, Comment.COMMENT, Comment.COMMENT.QUERY_ID);
		public static final ForeignKey<CommentRecord, PersonRecord> COMMENT__COMMENT_PERSON_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, Comment.COMMENT, Comment.COMMENT.PERSON_ID);
		public static final ForeignKey<FlaggedQueryRecord, QueryRecord> FLAGGED_QUERY__FLAGGED_QUERY_QUERY_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.QUERY_PKEY, FlaggedQuery.FLAGGED_QUERY, FlaggedQuery.FLAGGED_QUERY.QUERY_ID);
		public static final ForeignKey<FlaggedQueryRecord, PersonRecord> FLAGGED_QUERY__FLAGGED_QUERY_PERSON_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, FlaggedQuery.FLAGGED_QUERY, FlaggedQuery.FLAGGED_QUERY.PERSON_ID);
		public static final ForeignKey<PersonRecord, LocationRecord> PERSON__PERSON_LOCATION_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.LOCATION_PKEY, Person.PERSON, Person.PERSON.LOCATION_ID);
		public static final ForeignKey<QueryRecord, PersonRecord> QUERY__QUERY_RESEARCHER_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, Query.QUERY, Query.QUERY.RESEARCHER_ID);
		public static final ForeignKey<QueryPersonRecord, QueryRecord> QUERY_PERSON__QUERY_PERSON_QUERY_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.QUERY_PKEY, QueryPerson.QUERY_PERSON, QueryPerson.QUERY_PERSON.QUERY_ID);
		public static final ForeignKey<QueryPersonRecord, PersonRecord> QUERY_PERSON__QUERY_PERSON_PERSON_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, QueryPerson.QUERY_PERSON, QueryPerson.QUERY_PERSON.PERSON_ID);
		public static final ForeignKey<RoleRecord, PersonRecord> ROLE__ROLE_PERSON_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, Role.ROLE, Role.ROLE.PERSON_ID);
		public static final ForeignKey<RoleRecord, PersonRecord> ROLE__ROLE_PERSON_ID_FKEY1 = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.PERSON_PKEY, Role.ROLE, Role.ROLE.PERSON_ID);
		public static final ForeignKey<TagRecord, QueryRecord> TAG__TAG_QUERY_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.QUERY_PKEY, Tag.TAG, Tag.TAG.QUERY_ID);
		public static final ForeignKey<TaggedQueryRecord, QueryRecord> TAGGED_QUERY__TAGGED_QUERY_QUERY_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.QUERY_PKEY, TaggedQuery.TAGGED_QUERY, TaggedQuery.TAGGED_QUERY.QUERY_ID);
		public static final ForeignKey<TaggedQueryRecord, TagRecord> TAGGED_QUERY__TAGGED_QUERY_TAG_ID_FKEY = createForeignKey(de.samply.bbmri.negotiator.jooq.Keys.TAG_PKEY, TaggedQuery.TAGGED_QUERY, TaggedQuery.TAGGED_QUERY.TAG_ID);
	}
}
