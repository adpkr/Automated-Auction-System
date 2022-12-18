package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DbUtil.DbUtil;
import com.Exceptions.AdminException2;
import com.Model.BuyItem;
import com.Model.Buyer;
import com.Model.Seller;

public class AdminImpl implements AdminDao{

	
	//-------------------------------------------------View Buyer---------------------------------------------//
	@Override
	public List<Buyer> viewBuyerToAdmin() throws AdminException2 {
		
		List<Buyer> ls = new ArrayList<>();
		
		try (Connection conn= DbUtil.ProvideConection()){
			PreparedStatement ps =conn.prepareStatement("Select * from Buyer");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int i = rs.getInt("bid");
				String n = rs.getString("bname");
				String e = rs.getString("bemail");
				String p = rs.getString("bpassword");
				
				Buyer b = new Buyer(i, n, e, p);
				ls.add(b);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ls;
	}
	
	
	
	//-----------------------------------------------View Seller----------------------------------------------//
	
	
	

	@Override
	public List<Seller> viewSellerToAdmin() throws AdminException2 {
	
		List<Seller> ls = new ArrayList<>();
		
		try (Connection conn= DbUtil.ProvideConection()){
			PreparedStatement ps= conn.prepareStatement("Select * from seller");
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				
				
				int i= rs.getInt("sid");
				String n = rs.getString("sname");
				String e = rs.getString("semail");
				String p = rs.getString("spassword");
				
				Seller s = new Seller(i, n, e, p);
				
				ls.add(s);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ls;
		
	}
	
	
	
	//--------------------------View Daily Sell Item--------------------------------------------------------//
	
	
	

	@Override
	public List<BuyItem> viewDailyByItem() throws AdminException2 {
		
		List<BuyItem> ls = new ArrayList<>();
		
		try(Connection conn= DbUtil.ProvideConection()) {
			PreparedStatement ps= conn.prepareStatement("select * from buyitem group by bidate");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				String n=rs.getString("biname");
				int p = rs.getInt("biprice");
				int q = rs.getInt("biquantity");
				String bn = rs.getString("bibname");
				String bd = rs.getString("bidate");
				
				BuyItem b = new BuyItem(n, p, q, bn, bd);
				
				ls.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ls;
	}

	
	
      

}
