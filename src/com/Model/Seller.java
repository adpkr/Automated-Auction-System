package com.Model;

public class Seller {
	
	private String SellerName;
	private String SellerEmail;
	private String SellerPassword;
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Seller(String sellerName, String sellerEmail, String sellerPassword) {
		super();
		SellerName = sellerName;
		SellerEmail = sellerEmail;
		SellerPassword = sellerPassword;
	}


	public String getSellerName() {
		return SellerName;
	}


	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}


	public String getSellerEmail() {
		return SellerEmail;
	}


	public void setSellerEmail(String sellerEmail) {
		SellerEmail = sellerEmail;
	}


	public String getSellerPassword() {
		return SellerPassword;
	}


	public void setSellerPassword(String sellerPassword) {
		SellerPassword = sellerPassword;
	}


	@Override
	public String toString() {
		return "Seller [SellerName=" + SellerName + ", SellerEmail=" + SellerEmail + ", SellerPassword="
				+ SellerPassword + "]";
	}
	
	

}
