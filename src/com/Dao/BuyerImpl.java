package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DbUtil.DbUtil;
import com.Exceptions.BuyerException;
import com.Model.Buyer;

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

}
