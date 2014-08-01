package org.sevenup.util.constants;

import org.sevenup.util.PropertyManager;



public class ServicesConstants { 

	public static final String servicesCommonPropertiesFile = "ServicesCommon.properties";

	public static final String INITIAL_CONTEXT_FACTORY = PropertyManager
			.getInstance().getProperties("",
					ServicesConstants.servicesCommonPropertiesFile)
			.getProperty("INITIAL_CONTEXT_FACTORY");

	public static final String PROVIDER_URL = PropertyManager.getInstance()
			.getProperties("",ServicesConstants.servicesCommonPropertiesFile)
			.getProperty("PROVIDER_URL");

	public static final String APPCONFIG = "environmentalVaiable";
	
	
}
