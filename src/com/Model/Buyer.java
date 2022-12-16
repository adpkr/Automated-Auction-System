package com.Model;

public class Buyer {
	
	
	private String BuyerName;
	private String BuyerEmail;
	private String BuyerPassword;
	
	public Buyer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Buyer(String buyerName, String buyerEmail, String buyerPassword) {
		super();
		
		BuyerName = buyerName;
		BuyerEmail = buyerEmail;
		BuyerPassword = buyerPassword;
	}





	public String getBuyerName() {
		return BuyerName;
	}


	public void setBuyerName(String buyerName) {
		BuyerName = buyerName;
	}


	public String getBuyerEmail() {
		return BuyerEmail;
	}


	public void setBuyerEmail(String buyerEmail) {
		BuyerEmail = buyerEmail;
	}


	public String getBuyerPassword() {
		return BuyerPassword;
	}


	public void setBuyerPassword(String buyerPassword) {
		BuyerPassword = buyerPassword;
	}


	@Override
	public String toString() {
		return "Buyer [BuyerId=" + ", BuyerName=" + BuyerName + ", BuyerEmail=" + BuyerEmail
				+ ", BuyerPassword=" + BuyerPassword + "]";
	}
	
	
	
}
