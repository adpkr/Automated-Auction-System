package com.Dao;



import java.util.List;

import com.Exceptions.ItemException;
import com.Exceptions.SellerException;
import com.Model.BuyItem;
import com.Model.Item;
import com.Model.Seller;

public interface SellerDao {
	
	public String RegisterSeller(Seller s) throws SellerException;
	
	public String LoginSeller(String email, String pass) throws SellerException;
	
	public String AddItemBySeller(Item i)throws SellerException,ItemException;

	public String UpdateItemBySeller(Item i)throws SellerException,ItemException;
	
	public String RemoveItemBySeller(int sid,int iit) throws SellerException,ItemException;
	
	public List<BuyItem> ShowItemToSeller() throws SellerException;
	
	
	
	
	
}
