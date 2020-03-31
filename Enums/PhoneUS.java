package com.ariat.Enums;

/**
 * List of US phones
 * @author aila.bogasieru@ariat.com
 */


public enum PhoneUS {
	
	
	phone1("208252-7991"), 
	phone2("442226-3903"), 
	phone3("669666-5709"),
	phone4("201455-3324"),
	phone5("787922-8878"),
	phone6("716213-6898"), 
	phone7("314319-9069"),
	phone9("575512-4841"), 
	phone10("343400-7358"),
	phone11("520345-3484");

	private String number;

	private PhoneUS(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
		
	}
	
}
