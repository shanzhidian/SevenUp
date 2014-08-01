package org.sevenup.common.logs;



import java.net.InetAddress;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


/**
 * This class provides helper methods for the web ordering logging, tracing, alerting and order
 * transaction tracking functionality. This class acts as a wrapper class to the java logger and
 * provides utility methods for message formatting, generating a unique id, and alerting.
 *
 * @author 
 * @version $Revision: 0.1$
 */
public class MessageLoggerHelper { 

    private final static Level ENTRY_EXIT_LOG_LEVEL = Level.DEBUG;
//    private final static Level DEFAULT_TRACE_LOG_LEVEL = Level.TRACE;
    private final static Level DEFAULT_TRACE_LOG_LEVEL = Level.DEBUG;
    private final static String DELIMITER = ",";

    static {
        configure();
    }

    private MessageLoggerHelper() {
    }

    /**
     * This method creates logger objects and their respective file handlers. This serves
     * to set log file locations for each logger by package name.
     */
    private static void configure() {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("Loggers");
          
            Enumeration<String> keysEnum = bundle.getKeys();
            String key;
            Logger l;
            
        }
        catch (Exception e) {
            //Catch Exception. 
        }
    }

    /**
     * This method returns a logger object
     *
     * @param className fully qualified class name
     *
     * @return logger logger object
     */
    public static Logger getLogger(String className) {
        return Logger.getLogger(className);
    }

    /**
     * This method invokes the CardinalAlerter sendAlert api that sends a message to the
     * Event Log
     *
     * @param applicationName Name of the application
     * @param alertCode 6-digit error code
     * @param alertType type of alert: System, Business or Security
     * @param alertLevel severity of alert
     * @param message error message
     */
    public static void alert(String applicationName, String alertCode, String alertType,
                             String alertLevel, String message) {
       // LogManagerWrapper logManagerWrapper = new LogManagerWrapper("");
        //logManagerWrapper.alert(applicationName, alertCode, alertType, alertLevel, message);
    }

    /**
     * Constructs and returns an entry to be logged.
     *
     * @param shipToAccount physical store account number.
     * @param userId user identification
     * @param transactionId session id
     * @param message log message
     * @param entityName any entity specific to service(i.e OrderId)
     * @param entityValue value of entity name (i.e. OrderId)
     *
     * @return logMessage The message entry to be logged
     */
    public static String buildMessage(String shipToAccount, String userId, String transactionId,
                                      String message, String entityName, String entityValue) {
        StringBuffer logMessage = new StringBuffer();

        logMessage.append(transactionId + ", ");
        logMessage.append(shipToAccount + ", ");
        logMessage.append(userId + ", ");
        logMessage.append(entityName + "=" + entityValue + ", ");

        logMessage.append(" - " + message);

        return logMessage.toString();
    }

    /**
     * this method builds the log entry message
     *
     * @param shipToAccount users ship to account number
     * @param userId user id
     * @param transactionId session identifier
     * @param message message description to be logged
     *
     * @return log entry message
     */
    public static String buildMessage(String shipToAccount, String userId, String transactionId,
                                      String message) {
        StringBuffer logMessage = new StringBuffer();

        logMessage.append(transactionId + ", ");
        logMessage.append(shipToAccount + ", ");

        logMessage.append(userId + ", ");

        logMessage.append(" - " + message);

        return logMessage.toString();
    }

    /**
     * Constructs and returns an error entry to be logged.
     *
     * @param shipToAccount physical store account number.
     * @param userId user identification
     * @param transactionId session id
     * @param code error code
     * @param message log message
     * @param entityName any entity specific to service(i.e OrderId)
     * @param entityValue value of entity name (i.e. OrderId)
     *
     * @return logMessage The message entry to be logged
     */
    public static String buildErrorMessage(String shipToAccount, String userId,
                                           String transactionId, String code, String message,
                                           String entityName, String entityValue) {
        StringBuffer logMessage = new StringBuffer();

        logMessage.append(transactionId + ", ");
        logMessage.append(shipToAccount + ", ");
        logMessage.append(userId + ", ");
        logMessage.append(code + ", ");
        logMessage.append(entityName + "=" + entityValue + ",");

        logMessage.append(" - " + message);

        return logMessage.toString();
    }

    /**
     * Constructs and returns an error entry to be logged.
     *
     * @param shipToAccount physical store account number.
     * @param userId user identification
     * @param transactionId session id
     * @param code error code
     * @param message log message
     *
     * @return logMessage The message entry to be logged
     */
    public static String buildErrorMessage(String shipToAccount, String userId,
                                           String transactionId, String code, String message) {
        StringBuffer logMessage = new StringBuffer();

        logMessage.append(transactionId + ", ");
        logMessage.append(shipToAccount + ", ");
        logMessage.append(userId + ", ");
        logMessage.append(code + ",");

        logMessage.append(" - " + message);

        return logMessage.toString();
    }

    /**
     * This method returns whether the entry and exit tracing has been enabled.
     *
     * @param logger a Java Logger object
     *
     * @return entry and exit trace enable flag
     */
    public static boolean isEntryExitTraceEnabled(Logger logger) {
    	return logger.isEnabledFor(ENTRY_EXIT_LOG_LEVEL);
        //return logger.isLoggable(ENTRY_EXIT_LOG_LEVEL);
    }

    /**
     * This method returns whether the tracing has been enabled.
     *
     * @param logger java logger object
     *
     * @return trace enable flag
     */
    public static boolean isTraceEnabled(Logger logger) {
        return logger.isEnabledFor(DEFAULT_TRACE_LOG_LEVEL);
    }

    /**
     * this method puts a message on a queue. this message is used to keep track of the
     * order status throughout the application tiers.
     *
     * @param userId
     * @param salesOrderId
     * @param appTier
     * @param status
     */
    public static void trackOrder(String userId, String salesOrderId, String appTier, String status) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("ordertracker");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new java.util.Date());

        StringBuffer message = new StringBuffer();
        message.append(userId);
        message.append(salesOrderId);
        message.append(DELIMITER);
        message.append(date);
        message.append(DELIMITER);
        message.append(appTier);
        message.append(DELIMITER);
        message.append(status);
        logger.info(message);
    }

    /**
     * this method puts a message on a queue. this message is used to keep track of the
     * order status throughout the application tiers.
     *
     * @param userId
     * @param salesOrderId
     * @param appTier
     * @param fulfillmentOrderId
     * @param status
     */
    public static void trackOrder(String userId, String salesOrderId, String appTier,
                                  String fulfillmentOrderId, String status) {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("ordertracker");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new java.util.Date());

        StringBuffer message = new StringBuffer();
        message.append(userId);
        message.append(salesOrderId);
        message.append(DELIMITER);
        message.append(date);
        message.append(DELIMITER);
        message.append(appTier);
        message.append(DELIMITER);
        message.append(fulfillmentOrderId);
        message.append(DELIMITER);
        message.append(status);

        logger.info(message);
    }

    /**
     * this method generates a 32 bit transaction id
     *
     * @return transactionId 32-bit random numeric number
     */
    public static String generateTransactionId() {
        String transactionIdSegment = "";
        String uniqueTransactionId = "";
        try {
            byte[] hostAddress = InetAddress.getLocalHost().getAddress();

            //grab ip address
            for (int i = 0; i < hostAddress.length; i++) {
                Byte b = new Byte(hostAddress[i]);
                transactionIdSegment = Integer.toString(b.intValue() & 0x000000FF);

                while (transactionIdSegment.length() < 3) {
                    transactionIdSegment = '0' + transactionIdSegment;
                } // while

                uniqueTransactionId += transactionIdSegment;
            } // for

            //Mask Current Time in Millis
            transactionIdSegment = Long.toString(System.currentTimeMillis());
            while (transactionIdSegment.length() < 12) {
                transactionIdSegment = '0' + transactionIdSegment;
            } // while

            uniqueTransactionId += transactionIdSegment;

            //Generate a random number for the last 7 digits of the transaction id

            //generate and random number in hex ranging from 0x00000000 to 0xFFFFFFFF
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
            int rand = prng.nextInt();

            //mask off bits to insure the number isnt longer than 7 digits in decimal.
            //9999999, the largest 7 digit number in decimal = 0x98967f. Masking by 
            //0x007FFFFF insures the largest number created is 8388607.
            String randomSegment = Integer.toString((rand & 0x007FFFFF), 10);

            while (randomSegment.length() < 7) {
                randomSegment = '0' + randomSegment;
            }

            uniqueTransactionId += randomSegment;
        }
        catch (java.net.UnknownHostException e) {
            //return 32 char long 0 string as transaction id
            return "00000000000000000000000000000000";
        }
        catch (java.security.NoSuchAlgorithmException e) {
            //This exception will not happen, as the value is hard coded to "SHA1PRNG"
        } // catch

        return uniqueTransactionId;
    }
}
