package com.Dao;

import com.Exceptions.BuyerException;
import com.Model.Buyer;

public interface BuyerDao {
	
	public String RegisterBuyer(Buyer b)throws BuyerException;
	
	public String LoginBuyer(String email, String pass) throws BuyerException;
	

}
