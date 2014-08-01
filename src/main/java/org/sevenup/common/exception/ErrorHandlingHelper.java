package org.sevenup.common.exception;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * This class provides helper methods for the Web Ordering Error Handling framework.
 *
 * @author Nina Bhatti, Jason Cardillo
 * @version $Revision: 0.1$
 */
public class ErrorHandlingHelper {
    /* Static variable used for messages not found in the properties file or error conditions */
    private final static String UNKNOWN_MESSAGE =
        "Your request cannot be completed at this time, if this problem persists, please contact the Customer Service Center at 1-800-722-3444, option 3.";

    /* Static variable used for keys not found in the properties file or error conditions */
    public final static String UNKNOWN_EXCEPTION_KEY = "UNKNOWN_EXCEPTION_KEY";

    /* Static variable used for keys not found in the properties file or error conditions */
    public final static String THROWABLE_ERROR_KEY = "THROWABLE_ERROR_KEY";

    /* static variable used for codes not found in the properties file or error conditions */
    private final static String UNKNOWN_CODE = "SY9999";

    /* file path to the user friendly messages properties file */
    private final static String USERFRIENDLY_CONFIGPATH = "UserFriendlyMessages";

    /* file path to the key to code mapping properties file */
    private final static String KEY_TO_CODE_CONFIGPATH = "ErrorCodes";

    /* file path to the ECMessage descriptions properties file */
    private final static String ECMESSAGE_DESCRIPTIONS_CONFIGPATH = "ECMessageDescriptions";

    /* file path to the properties file */
    private final static String DISTRACKSERVICE_CONFIGPATH = "DistrackErrors";

    /* unknown user ship to account */
    public final static String UNKNOWN_SHIPTO_ADDRESS = "Unknown Ship to Address";

    /* distrack error code */
    private final static String DISTRACK_ERROR_CODE = "BU9000";
    private final static String DISTRACK_ERROR_KEY = "DISTRACKSERVICE_ERROR_DISTRACK_ERRORS";
    private final static String DISTRACK_ERROR_LINEITEM_CODE="BU9010";
    private final static String DISTRACK_ERROR_LINEITEM_KEY="DISTRACKSERVICE_ERROR_DISTRACK_LINE_ERRORS";

/**
     * Constructor
     *
     */
    public ErrorHandlingHelper() {
    }

    /**
     * This method returns the user friendly messages from a properties file corresponding
     * to the input error code input.
     *
     * @param code Error Code
     *
     * @return
     */
    public static String getUserFriendlyByCode(String code) {
        try {
            ResourceBundle resourceBundle =
                PropertyResourceBundle.getBundle(USERFRIENDLY_CONFIGPATH);

            if ("".equals(resourceBundle.getString(code))) {
                return UNKNOWN_MESSAGE;
            }
            else
            {
                return resourceBundle.getString(code);
            }
        }
        catch (Exception e) {
            return UNKNOWN_MESSAGE;
        }
    }

    /**
     * This method returns the user friendly message corresponding to the error key input
     *
     * @param key Error Key
     *
     * @return
     */
    public static String getUserFriendlyByKey(String key) {
        try {
            ResourceBundle resourceBundle =
                PropertyResourceBundle.getBundle(USERFRIENDLY_CONFIGPATH, Locale.US);
            if ("".equals(resourceBundle.getString(key))) {
                return UNKNOWN_MESSAGE;
            }
            else
            {
                return resourceBundle.getString(key);
            }
        }
        catch (Exception e) {
            return UNKNOWN_MESSAGE;
        }
    }

    /**
     * This method returns the error code corresponding to the error key input.  Websphere
     * commerce does not use Error Codes, thus a lookup must be performed in  order to populate
     * the error code input of the cardinal alerter.
     *
     * @param key error key
     *
     * @return code error code associated to the input error key
     */
    public static String getErrorCodeByErrorKey(String key) {
        try {
            ResourceBundle resourceBundle =
                PropertyResourceBundle.getBundle(KEY_TO_CODE_CONFIGPATH);

            return resourceBundle.getString(key);
        }
        catch (Exception e) {
            return UNKNOWN_CODE;
        }
    }

    /**
     * 
    DOCUMENT ME!
     *
     * @param errorKey //TODO: DOCUMENT ME!
     * @param errorCode //TODO: DOCUMENT ME!
     * @param errorDescription //TODO: DOCUMENT ME!
     * @param hostCode //TODO: DOCUMENT ME!
     * @param hostMessage //TODO: DOCUMENT ME!
     *
     * @throws BusinessException //TODO: DOCUMENT ME!
     */
    public static void findBusinessExceptionFromAdapterHeader(String errorKey, String returnCode,
                                                        String errorDescription, String hostCode,
                                                        String hostMessage)
                                                 throws BusinessException {
        try {
            //If Distrack return Code == BU9000 then there is an error in the header or line items from distrack
            if (DISTRACK_ERROR_CODE.equals(returnCode)) {
            	//RB for looking up adapter error key from host codes
                ResourceBundle resourceBundle =
                    PropertyResourceBundle.getBundle(DISTRACKSERVICE_CONFIGPATH);
                //RB for grabbing error codes from error key
                ResourceBundle resourceBundle1 =
                    PropertyResourceBundle.getBundle(KEY_TO_CODE_CONFIGPATH);
                
                if (hostCode != "0000") {
                    throw new BusinessException(resourceBundle.getString(hostCode),
                                                resourceBundle1.getString(resourceBundle.getString(hostCode)),
                                                hostMessage);
                }

                //else we throw no error because there is an error in the line item
            }

            //There was an error in the adapter
            else {
            	//disregard any line item errors
            	if(!(DISTRACK_ERROR_LINEITEM_CODE.equals(returnCode))){
                throw new BusinessException(errorKey, returnCode, errorDescription);
            	}
            }
        }

        //Could not find resource bundle or any other error.
        catch (MissingResourceException e) {
            throw new BusinessException(DISTRACK_ERROR_KEY, DISTRACK_ERROR_CODE, errorDescription);
        }
    }
    /**
     * 
     * @param errorKey
     * @param returnCode
     * @param errorMessage
     * @param errorCode
     * @param errorDescription
     * @throws BusinessException
     */
    public static void findBusinessExceptionFromAdapterLineItem(String errorKey, String returnCode,
            String errorMessage, String errorCode,
            String errorDescription)throws BusinessException
    {
    	try {
    		
    		if (DISTRACK_ERROR_LINEITEM_CODE.equals(returnCode)) {//Check if == BU9010
                //RB for looking up adapter error key from host codes
                ResourceBundle resourceBundle =
                    PropertyResourceBundle.getBundle(DISTRACKSERVICE_CONFIGPATH);
                //RB for grabbing error codes from error key
                ResourceBundle resourceBundle1 =
                    PropertyResourceBundle.getBundle(KEY_TO_CODE_CONFIGPATH);
                
                if (errorCode != "0000") {
                    throw new BusinessException(resourceBundle.getString(errorCode),
                                                resourceBundle1.getString(resourceBundle.getString(errorCode)),
                                                errorDescription);
                }
                //else we throw no error because there is an error in the line item
    		}
    		//There was an error in the adapter
    		else {
    			throw new BusinessException(errorKey, returnCode, errorDescription);
    		}
    	}
        //Could not find resource bundle or any other error.
        catch (MissingResourceException e) {
            throw new BusinessException(DISTRACK_ERROR_LINEITEM_KEY, DISTRACK_ERROR_LINEITEM_CODE, errorDescription);
        }
    }
}
