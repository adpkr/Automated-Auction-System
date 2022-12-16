package com.Dao;



import com.Exceptions.ItemException;
import com.Exceptions.SellerException;
import com.Model.Item;
import com.Model.Seller;

public interface SellerDao {
	
	public String RegisterSeller(Seller s) throws SellerException;
	
	public String LoginSeller(String email, String pass) throws SellerException;
	
	public String AddItemBySeller(Item i)throws SellerException,ItemException;

}
