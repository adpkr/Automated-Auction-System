package com.Dao;

import java.util.List;

import com.Exceptions.BuyerException;
import com.Exceptions.SellerException;
import com.Model.BuyItem;
import com.Model.Buyer;
import com.Model.Item;

public interface BuyerDao {
	
	public String RegisterBuyer(Buyer b)throws BuyerException;
	
	public String LoginBuyer(String email, String pass) throws BuyerException;
	
	public List<Item> ShowItemtoBuyer()throws BuyerException;
	
	public String BuyItemByItem(int bid,int iit)throws SellerException;
	
	public List<BuyItem> ShowBuyItemtoBuyer()throws BuyerException;

}
