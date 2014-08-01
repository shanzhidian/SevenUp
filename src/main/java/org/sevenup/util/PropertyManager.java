package org.sevenup.util;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.sevenup.common.exception.ErrorHandlingHelper;
import org.sevenup.common.exception.SystemException;
import org.sevenup.util.constants.ServicesResponseCodes;

public final class PropertyManager {
	private static PropertyManager instance; // Singleton
	private static String APPCONFIG = "APPCONFIG";
	protected Map<String, Properties> cache;
	private String configDirectory;

	/**
	 * Constructs a new, PropertiesManager Object Private Constructor, to make
	 * it Singleton
	 * 
	 * @return PropertiesManager
	 */
	private PropertyManager() {
		// Initializations should happen here
		this.configDirectory = System.getProperty(APPCONFIG);
		this.cache = Collections
				.synchronizedMap(new HashMap<String, Properties>());
	}

	/**
	 * Used to get an instance of PropertiesManager.
	 * 
	 * @return PropertiesManager
	 */
	public static PropertyManager getInstance() {
		if (instance == null) {

			instance = new PropertyManager();
		}

		return instance;
	}

	/**
	 * Loads the content of the Properties file.
	 * 
	 * @param serviceName
	 *            -The name of the Service
	 * @param fileName
	 *            - File being lookup
	 * 
	 * @return Properties
	 * 
	 * @throws SystemException
	 */
	public Properties getProperties(String serviceName, String fileName)
			throws SystemException {
		Properties result = this.cache.get(fileName);
		if (result == null) {
			// load file
			result = new Properties();
			try {
				if ((serviceName != null) && (!serviceName.equals(""))) {
					result.load(new FileInputStream(this.configDirectory
							+ File.separator + serviceName + File.separator
							+ fileName));
				} else {
					result.load(new FileInputStream(this.configDirectory
							+ File.separator + fileName));
				}
			} catch (FileNotFoundException e) {
				throw new SystemException(
						ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION,
						ErrorHandlingHelper
								.getErrorCodeByErrorKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION),
						ErrorHandlingHelper
								.getUserFriendlyByKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION)
								+ fileName, e);
			} catch (IOException e) {
//				throw new SystemException(
//						ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION,
//						ErrorHandlingHelper
//								.getErrorCodeByErrorKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION),
//						ErrorHandlingHelper
//								.getUserFriendlyByKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION)
//								+ fileName, e);
			}

			// add to cache
			this.cache.put(fileName, result);
		}

		return result;
	}

	public Properties getProperties(String fileName) throws SystemException {
		Properties result = this.cache.get(fileName);

		if (result == null) {
			// load file
			result = new Properties();
			if (this.configDirectory == null) {
//				throw new SystemException(
//						ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION,
//						ErrorHandlingHelper
//								.getErrorCodeByErrorKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION),
//						ErrorHandlingHelper
//								.getUserFriendlyByKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION)
//								+ fileName);

			}

			try {
				result.load(ClassLoader.getSystemResourceAsStream(fileName));

			} catch (FileNotFoundException e) {
//				throw new SystemException(
//						ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION,
//						ErrorHandlingHelper
//								.getErrorCodeByErrorKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION),
//						ErrorHandlingHelper
//								.getUserFriendlyByKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION)
//								+ fileName, e);
			} catch (IOException e) {
//				throw new SystemException(
//						ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION,
//						ErrorHandlingHelper
//								.getErrorCodeByErrorKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION),
//						ErrorHandlingHelper
//								.getUserFriendlyByKey(ServicesResponseCodes.WS_ERROR_FILE_NOTFOUND_EXCEPTION)
//								+ fileName, e);
			}

			// add to cache
			this.cache.put(fileName, result);
		}

		return result;
	}
}
