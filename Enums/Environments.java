package com.ariat.Enums;

/**
 * Enumerator with available environments
 * 
 * @author aila.bogasieru@ariat.com
 */

public enum Environments {
     STAGING("http://staging.ariat.com", "https://staging-ai001-ariat.demandware.net/on/demandware.store/Sites-Site"),
	 DEVELOPMENT("http://development.ariat.com","https://development-ai001-ariat.demandware.net/on/demandware.store/Sites-Site"),
	 DEV03("http://dev03.ariat.com","https://development-ai001-ariat.demandware.net/on/demandware.store/Sites-Site"),
	 DEV01("http://dev01.ariat.com",	"https://development-ai001-ariat.demandware.net/on/demandware.store/Sites-Site");

	private String URL;
	private String businessMngmtURL;

	private Environments(String URL, String businessMngmtURL) {
		this.URL = URL;
		this.businessMngmtURL = businessMngmtURL;
	}

	public String getURL() {
		return URL;
	}

	public String getbusinessMngmtURL() {
		return businessMngmtURL;
	}
}
