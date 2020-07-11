/**
 * This class is generated by jOOQ
 */
package de.samply.bbmri.negotiator.jooq.tables.daos;


import de.samply.bbmri.negotiator.jooq.tables.NetworkBiobankLink;
import de.samply.bbmri.negotiator.jooq.tables.records.NetworkBiobankLinkRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;


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
public class NetworkBiobankLinkDao extends DAOImpl<NetworkBiobankLinkRecord, de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink, Record2<Integer, Integer>> {

	/**
	 * Create a new NetworkBiobankLinkDao without any configuration
	 */
	public NetworkBiobankLinkDao() {
		super(NetworkBiobankLink.NETWORK_BIOBANK_LINK, de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink.class);
	}

	/**
	 * Create a new NetworkBiobankLinkDao with an attached configuration
	 */
	public NetworkBiobankLinkDao(Configuration configuration) {
		super(NetworkBiobankLink.NETWORK_BIOBANK_LINK, de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Record2<Integer, Integer> getId(de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink object) {
		return compositeKeyRecord(object.getBiobankId(), object.getNetworkId());
	}

	/**
	 * Fetch records that have <code>biobank_id IN (values)</code>
	 */
	public List<de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink> fetchByBiobankId(Integer... values) {
		return fetch(NetworkBiobankLink.NETWORK_BIOBANK_LINK.BIOBANK_ID, values);
	}

	/**
	 * Fetch records that have <code>network_id IN (values)</code>
	 */
	public List<de.samply.bbmri.negotiator.jooq.tables.pojos.NetworkBiobankLink> fetchByNetworkId(Integer... values) {
		return fetch(NetworkBiobankLink.NETWORK_BIOBANK_LINK.NETWORK_ID, values);
	}
}
