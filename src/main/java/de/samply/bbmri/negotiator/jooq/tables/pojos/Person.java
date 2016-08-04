/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * person table which is parent of researcher and owner
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Person implements Serializable {

	private static final long serialVersionUID = -1431240108;

	private Integer id;
	private String  authSubject;
	private String  authName;
	private String  authEmail;
	private byte[]  personImage;
	private Integer locationId;

	public Person() {}

	public Person(Person value) {
		this.id = value.id;
		this.authSubject = value.authSubject;
		this.authName = value.authName;
		this.authEmail = value.authEmail;
		this.personImage = value.personImage;
		this.locationId = value.locationId;
	}

	public Person(
		Integer id,
		String  authSubject,
		String  authName,
		String  authEmail,
		byte[]  personImage,
		Integer locationId
	) {
		this.id = id;
		this.authSubject = authSubject;
		this.authName = authName;
		this.authEmail = authEmail;
		this.personImage = personImage;
		this.locationId = locationId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthSubject() {
		return this.authSubject;
	}

	public void setAuthSubject(String authSubject) {
		this.authSubject = authSubject;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthEmail() {
		return this.authEmail;
	}

	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}

	public byte[] getPersonImage() {
		return this.personImage;
	}

	public void setPersonImage(byte[] personImage) {
		this.personImage = personImage;
	}

	public Integer getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
}
