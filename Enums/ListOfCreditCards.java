package com.ariat.Enums;

/**
 * Groups all available Core card payments and their corresponding test card
 * numbers
 * 
 * @author aila.bogasieru@ariat.com
 *
 */

public enum ListOfCreditCards {

	AMERICAN_EXPRESS("American Express", "378282246310005", "123"),
	AMERICAN_EXPRESS_CORPORATE("American Express Corporate", "378734493671000", "123"),
	AUSTRALIAN_BANKCARD("Australian BankCard", "5610591081018250", "123"),
	DINERS_CLUB("Diners Club", "30569309025904", "123"),
	DISCOVER("Discover", "6011111111111117", "123"),
	JCB("JCB", "3530111333300000", "123"),
	JCB1("JCB", "3566002020360505", "123"),
	MASTER_CARDSpace("Master Card", "5555555555554444", "123"),
	MASTER_CARD1Space("Master Card", "5105105105105100", "123"),
	MASTER_CARD("MasterCard", "5555555555554444", "123"),
	MASTER_CARD1("MasterCard", "5105105105105100", "123"),
	VISA("Visa", "4111111111111111", "432"),
	VISA1("Visa", "4012888888881881", "432" ),
	VISA2("Visa", "4222222222222", "432"),
	DANKORT_PBS("Dankort", "76009244561", "432"),
	DANKORT_PBS1("Dankort", "5019717010103742", "432"),
	SWITCH_SOLO("Switch/Solo (Paymentech)", "6331101999990016", "432"),
	INVALID_CARD("Visa", "WIIUIRYIEHFKWEHEW", "ADHGA");

	private String name;
	private String number;
	private String cvs;

	private ListOfCreditCards(String name, String number, String cvs) {
		this.name = name;
		this.number = number;
		this.cvs = cvs;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}
	public String getCvs() {
		return cvs;
	}
}
