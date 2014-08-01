package org.sevenup.common.exception;


import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class models a security exception for the 7Up error handling framework. This 
 * exception will be created and thrown by the Portal and Enterprise tiers when a security error has
 * occurred.
 * @author steven.xu
 */
@XmlRootElement
public class SecurityException extends RuntimeException {
    /**  */
    private static final long serialVersionUID = 1L;
    private String errorKey;
    private String errorCode;
    private String errorDescription;
    private String userMessage;
    protected Calendar timestamp;
    private Throwable throwable;

/**
       * Constructor for SecurityException
       * 
       * @param key
       * @param code
       * @param description
       */
    public SecurityException(String key, String code, String description) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
    }
    
    public SecurityException(String key, String code, String userMessage, String description, Calendar calendar) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
        this.userMessage = userMessage;
        this.timestamp = calendar;
        
    }

/**
     * Constructor for SecurityException
     * 
     * @param key
     * @param code
     * @param description
     * @param throwable
     */
    public SecurityException(String key, String code, String description, Throwable throwable) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
        this.throwable = throwable;
    }

    /**
     * this method returns the throwable cause of the exception
     *
     * @return the throwable
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * This method returns the error key associated with the exception
     *
     * @return errorKey
     */
    public String getErrorKey() {
        return errorKey;
    }

    /**
     * This method returns the error code associated with the exception
     *
     * @return errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * This method returns the error description associated with the exception.
     *
     * @return errorDescription
     */
    public String getErrorDescription() {
        return errorDescription;
    }

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
    
}
