/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.routines;


import de.samply.bbmri.negotiator.jooq.Public;

import java.util.UUID;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;


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
public class UuidGenerateV3 extends AbstractRoutine<UUID> {

	private static final long serialVersionUID = -1174128207;

	/**
	 * The parameter <code>public.uuid_generate_v3.RETURN_VALUE</code>.
	 */
	public static final Parameter<UUID> RETURN_VALUE = createParameter("RETURN_VALUE", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * The parameter <code>public.uuid_generate_v3.namespace</code>.
	 */
	public static final Parameter<UUID> NAMESPACE = createParameter("namespace", org.jooq.impl.SQLDataType.UUID, false);

	/**
	 * The parameter <code>public.uuid_generate_v3.name</code>.
	 */
	public static final Parameter<String> NAME = createParameter("name", org.jooq.impl.SQLDataType.CLOB, false);

	/**
	 * Create a new routine call instance
	 */
	public UuidGenerateV3() {
		super("uuid_generate_v3", Public.PUBLIC, org.jooq.impl.SQLDataType.UUID);

		setReturnParameter(RETURN_VALUE);
		addInParameter(NAMESPACE);
		addInParameter(NAME);
	}

	/**
	 * Set the <code>namespace</code> parameter IN value to the routine
	 */
	public void setNamespace(UUID value) {
		setValue(NAMESPACE, value);
	}

	/**
	 * Set the <code>namespace</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setNamespace(Field<UUID> field) {
		setField(NAMESPACE, field);
	}

	/**
	 * Set the <code>name</code> parameter IN value to the routine
	 */
	public void setName_(String value) {
		setValue(NAME, value);
	}

	/**
	 * Set the <code>name</code> parameter to the function to be used with a {@link org.jooq.Select} statement
	 */
	public void setName_(Field<String> field) {
		setField(NAME, field);
	}
}
