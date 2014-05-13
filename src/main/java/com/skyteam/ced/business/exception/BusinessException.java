package com.skyteam.ced.business.exception;

import org.apache.commons.lang.StringUtils;

public class BusinessException extends RuntimeException {


	private static final long serialVersionUID = 5439915454935047936L;

	/**
	 * Construct a <code>NestedRuntimeException</code> with the specified detail
	 * message.
	 * 
	 * @param msg
	 *            the detail message
	 */
	public BusinessException(String msg) {
		super(msg);
	}

	/**
	 * Construct a <code>NestedRuntimeException</code> with the specified detail
	 * message and nested exception.
	 * 
	 * @param msg
	 *            the detail message
	 * @param cause
	 *            the nested exception
	 */
	public BusinessException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * Return the detail message, including the message from the nested
	 * exception if there is one.
	 */
	public String getMessageDetail() {
		return buildMessage(super.getMessage(), getCause());
	}

	private String buildMessage(String message, Throwable cause) {
		return message;
		
//		if (cause != null) {
//			StringBuffer buf = new StringBuffer();
//			if (message != null) {
//				buf.append(message).append("; ");
//			}
//			buf.append("nested exception is ").append(cause);
//			return buf.toString();
//		} else {
//			return message;
//		}
	}

	/**
	 * Retrieve the innermost cause of this exception, if any.
	 * 
	 * @return the innermost exception, or <code>null</code> if none
	 * @since 2.0
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	/**
	 * Retrieve the most specific cause of this exception, that is, either the
	 * innermost cause (root cause) or this exception itself.
	 * <p>
	 * Differs from {@link #getRootCause()} in that it falls back to the present
	 * exception if there is no root cause.
	 * 
	 * @return the most specific cause (never <code>null</code>)
	 * @since 2.0.3
	 */
	public Throwable getMostSpecificCause() {
		Throwable rootCause = getRootCause();
		return (rootCause != null ? rootCause : this);
	}

	/**
	 * Check whether this exception contains an exception of the given type:
	 * either it is of the given class itself or it contains a nested cause of
	 * the given type.
	 * 
	 * @param exType
	 *            the exception type to look for
	 * @return whether there is a nested exception of the specified type
	 */
	public boolean contains(Class exType) {
		if (exType == null) {
			return false;
		}
		if (exType.isInstance(this)) {
			return true;
		}
		Throwable cause = getCause();
		if (cause == this) {
			return false;
		}
		if (cause instanceof BusinessException) {
			return ((BusinessException) cause).contains(exType);
		} else {
			while (cause != null) {
				if (exType.isInstance(cause)) {
					return true;
				}
				if (cause.getCause() == cause) {
					break;
				}
				cause = cause.getCause();
			}
			return false;
		}
	}

	public String getMessage() {
		//Throwable xx = this.getCause();
		String yy = this.getMessageDetail();
		if (StringUtils.indexOf(yy, "Exception:") > -1) {
			yy = StringUtils.substringAfterLast(yy, "Exception:");
		}
		return yy;
	}

	private int errorCode;

	public synchronized int getErrorCode() {
		return errorCode;
	}

	public synchronized void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public BusinessException(int errorCode, String msg) {
		super(msg);
		this.setErrorCode(errorCode);
	}
	public BusinessException(int errorCode, String msg, Throwable cause) {
		super(msg,cause);
		this.setErrorCode(errorCode);
	}

}
