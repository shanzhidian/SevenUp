package org.sevenup.common.exception;


import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class models a System exception for the 7Up error handling framework.
 * This exception will be created and thrown by the Portal and Enterprise service tiers when
 * a runtime exception occurs.
 * @author steven.xu
 */
@XmlRootElement
public class SystemException extends RuntimeException {
    /**  */
    private static final long serialVersionUID = 1L;
    private String errorKey;
    private String errorCode;
    private String errorDescription;
    private String userMessage;
    protected Calendar timestamp;
    private Throwable throwable;

/**
       * Constructor for SystemException
       * 
       * @param key
       * @param code
       * @param description
       */
    public SystemException(String key, String code, String description) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
        throwable = null;
    }

/**
     * Constructor for SystemException
     * 
     * @param key
     * @param code
     * @param description
     */
    public SystemException(String key, String code, String description, Throwable cause) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
        this.throwable = cause;
    }

    public SystemException(String key, String code, String userMessage, String description, Calendar calendar) {
        errorKey = key;
        errorCode = code;
        errorDescription = description;
        this.userMessage = userMessage;
        this.timestamp = calendar;
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

    /**
     * This methods returns the nested exception that this exception wraps.
     *
     * @return Throwable - Original Exception
     */
    public Throwable getNestedException() {
        return throwable;
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

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
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
    
}
