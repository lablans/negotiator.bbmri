/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


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
public class QueryLifecycleCollection implements Serializable {

	private static final long serialVersionUID = -984475509;

	private Integer   queryId;
	private Integer   statusUserId;
	private Integer   collectionId;
	private String    status;
	private Timestamp statusDate;
	private Integer   id;
	private String    statusType;
	private String    statusJson;

	public QueryLifecycleCollection() {}

	public QueryLifecycleCollection(QueryLifecycleCollection value) {
		this.queryId = value.queryId;
		this.statusUserId = value.statusUserId;
		this.collectionId = value.collectionId;
		this.status = value.status;
		this.statusDate = value.statusDate;
		this.id = value.id;
		this.statusType = value.statusType;
		this.statusJson = value.statusJson;
	}

	public QueryLifecycleCollection(
		Integer   queryId,
		Integer   statusUserId,
		Integer   collectionId,
		String    status,
		Timestamp statusDate,
		Integer   id,
		String    statusType,
		String    statusJson
	) {
		this.queryId = queryId;
		this.statusUserId = statusUserId;
		this.collectionId = collectionId;
		this.status = status;
		this.statusDate = statusDate;
		this.id = id;
		this.statusType = statusType;
		this.statusJson = statusJson;
	}

	public Integer getQueryId() {
		return this.queryId;
	}

	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}

	public Integer getStatusUserId() {
		return this.statusUserId;
	}

	public void setStatusUserId(Integer statusUserId) {
		this.statusUserId = statusUserId;
	}

	public Integer getCollectionId() {
		return this.collectionId;
	}

	public void setCollectionId(Integer collectionId) {
		this.collectionId = collectionId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStatusDate() {
		return this.statusDate;
	}

	public void setStatusDate(Timestamp statusDate) {
		this.statusDate = statusDate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public String getStatusJson() {
		return this.statusJson;
	}

	public void setStatusJson(String statusJson) {
		this.statusJson = statusJson;
	}
}
