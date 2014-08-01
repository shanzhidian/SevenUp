package org.sevenup.common.logs;


/**
 * This class provides static variables for the various locations in the web ordering
 * application that will be used to track orders
 *
 * @author Jason Cardillo
 * @version $Revision: 0.1$
 */
public final class OrderTrackerAppTier {
    public static final String REQUEST_EXITING_PORTAL = "Request Exiting Portal Business Component";
    public static final String REQUEST_ENTERING_COMMERCE =
        "Request Entering Commerce Order Capture Module";
    public static final String REQUEST_EXITING_COMMERCE =
        "Request Exiting Commerce Order Capture Module";
    public static final String REQUEST_ENTERING_MESSAGEBROKER =
        "Request Entering Order Management Module";
    public static final String REQUEST_EXITING_MESSAGEBROKER =
        "Request Exiting Order Management Module";
    public static final String REQUEST_ENTERING_ADAPTER = "Request Entering Adapter";
    public static final String REQUEST_EXITING_ADAPTER = "Request Exiting Adapter";
    public static final String RESPONSE_ENTERING_MESSAGEBROKER =
        "Response Entering Order Management Module";
    public static final String RESPONSE_EXITING_MESSAGEBROKER =
        "Response Exiting Order Management Module";
    public static final String RESPONSE_ENTERING_ADAPTER = "Response Entering Adapter";
    public static final String RESPONSE_EXITING_ADAPTER = "Response Entering Adapter";
    
    private OrderTrackerAppTier(){}
}
