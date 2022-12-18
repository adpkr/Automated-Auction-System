package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DbUtil.DbUtil;
import com.Exceptions.BuyerException;
import com.Exceptions.SellerException;
import com.Model.BuyItem;
import com.Model.Buyer;
import com.Model.Item;

public class BuyerImpl implements BuyerDao{
	
//-------------	Register Buyer--------------------------------------------------------------------------------//

	@Override
	public String RegisterBuyer(Buyer b) throws BuyerException {
		String msg = "Not Register...!";
		
		try(Connection conn= DbUtil.ProvideConection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into Buyer(bname,bemail,bpassword) values(?,?,?)");
			
		
			ps.setString(1, b.getBuyerName());
			ps.setString(2, b.getBuyerEmail());
			ps.setString(3, b.getBuyerPassword());
			
			
			int x= ps.executeUpdate();
			
			if(x > 0) {
				msg = "Buyer Register Sucessfully...!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BuyerException(e.getMessage());
		}
		
		return msg;
	}
	
	
	
//----------------------------Login Buyer-------------------------------------------------------------------//	

	
	
	
	@Override
	public String LoginBuyer(String email, String pass) throws BuyerException {
		
		String msg = "Login Failed...!";
		
		try (Connection conn= DbUtil.ProvideConection()){
			PreparedStatement ps= conn.prepareStatement("select * from buyer where bemail = ? and bpassword = ?");
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				msg = "Wellcome to "+rs.getString("bname");
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new BuyerException(e.getMessage());
		}
		
		
		return msg;
		
	}



	
	//---------------------------------------Show All Items---------------------------------------------------//
	
	
	
	
	
	@Override
	public List<Item> ShowItemtoBuyer() throws BuyerException {
		
		List<Item> ls = new ArrayList<>();
		
		try(Connection conn= DbUtil.ProvideConection()) {
			PreparedStatement ps= conn.prepareStatement("select * from item");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("iid");
				String n = rs.getString("iname");
				int q = rs.getInt("iquantity");
				int p = rs.getInt("iprice");
				String d = rs.getString("idate");
				int si = rs.getInt("sid");
				
				Item it = new Item();
				it.setItemId(id);
				it.setItemName(n);
				it.setItemQuantity(q);
				it.setItemPrice(p);
				it.setItemDate(d);
				it.setSellerId(id);
				
				ls.add(it);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BuyerException(e.getMessage());
		}
		
		
		return ls;
		
	}



	
	
//-------------------------------------Buy Item To Buyer------------------------------------------------------//
	
	
	
	
	
	@Override
	public String BuyItemByItem(int bid,int iit) throws SellerException {
		
		String msg = "Not Buy Item...!";
		
		try (Connection conn=  DbUtil.ProvideConection()){
			PreparedStatement ps= conn.prepareStatement("insert into buyitem(select i.iname,i.iprice,i.iquantity,b.bname,i.idate from item i inner join buyer b on b.bid = ? and i.iid = ?)");
			ps.setInt(1, bid);
			ps.setInt(2, iit);
			
			int x =  ps.executeUpdate();
			if(x > 0) {
				msg = "Item Buy Sucessfully...";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return msg;
		
		
	 }

	

	
//--------------------------------------------Show Buy Item--------------------------------------------------//
	
	
	


	@Override
	public List<BuyItem> ShowBuyItemtoBuyer() throws BuyerException {
		
		List<BuyItem> ls = new ArrayList<>();
		
		try (Connection conn= DbUtil.ProvideConection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from buyitem");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String n = rs.getString("biname");
				int p = rs.getInt("biprice");
				int q = rs.getInt("biquantity");
				String bn = rs.getString("bibname");
				String bd = rs.getString("bidate");
				
				BuyItem bi = new BuyItem(n, p, q, bn, bd);
				ls.add(bi);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return ls;
		
	}

}
