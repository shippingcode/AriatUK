package com.ariat.Utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Utility class used for deserialization of the response from the Browserstack.
 * 
 * @author aila.bogasieru@ariat.com
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Browser {

	private String os;
	private String osVersion;
	private String browser;
	private String browserVersion;
	private String device;
	private Boolean realMobile;

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@JsonProperty("os_version")
	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@JsonProperty("browser_version")
	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@JsonProperty("real_mobile")
	public Boolean getRealMobile() {
		return realMobile;
	}

	public void setRealMobile(Boolean realMobile) {
		this.realMobile = realMobile;
	}
}
