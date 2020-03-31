package com.ariat.Exceptions;


	/**
	 * Exception that is used for exception occurred while interacting with
	 * Browserstack API.
	 * 
	 * @author aila.bogasieru@ariat.com
	 *
	 */
	public class BrowserException extends RuntimeException {

		private static final long serialVersionUID = 7451733593726886517L;

		public BrowserException() {

		}

		public BrowserException(String message) {
			super(message);
		}

		public BrowserException(Throwable cause) {
			super(cause);
		}

		public BrowserException(String message, Throwable cause) {
			super(message, cause);
		}
	}

