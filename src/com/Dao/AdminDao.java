package com.Dao;

import java.util.List;

import com.Exceptions.AdminException2;
import com.Model.BuyItem;
import com.Model.Buyer;
import com.Model.Seller;

public interface AdminDao {
	
	public List<Buyer> viewBuyerToAdmin()throws AdminException2;
	
	public List<Seller> viewSellerToAdmin()throws AdminException2;
	
	public List<BuyItem> viewDailyByItem()throws AdminException2;

}
