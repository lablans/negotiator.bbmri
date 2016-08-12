/**
 * Copyright (C) 2016 Medizinische Informatik in der Translationalen Onkologie,
 * Deutsches Krebsforschungszentrum in Heidelberg
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see http://www.gnu.org/licenses.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.bbmri.negotiator;

/**
 * Created by paul on 6/16/16.
 */
public class Constants {

    /**
     * The role identifier, that identifies Biobank owners.
     */
    public final static String OWNER_ROLE = "BBMRI_OWNER";

    /**
     * The role identifier, that identifies Biobank researcher.
     */
	public static final String RESEARCHER_ROLE = "BBMRI_RESEARCHER";

    /**
     * The package name of all database upgrade files.
     */
    public final static String DB_PACKAGE_NAME = "de.samply.bbmri.negotiator.db";

    /**
     * The required Database version for this application version.
     */
    public final static int DB_REQUIRED_VERSION = 1;


}
