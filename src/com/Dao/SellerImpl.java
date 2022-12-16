package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DbUtil.DbUtil;
import com.Exceptions.ItemException;
import com.Exceptions.SellerException;
import com.Model.Item;
import com.Model.Seller;

public class SellerImpl implements SellerDao{
	

//--------------------Register Seller--------------------------------------------------------------------------//
	
	
	@Override
	public String RegisterSeller(Seller s) throws SellerException {
	 
		String msg = "Not Register...!";
		
		try(Connection conn= DbUtil.ProvideConection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into Seller(sname,semail,spassword) values(?,?,?)");
			
		
			ps.setString(1, s.getSellerName());
			ps.setString(2, s.getSellerEmail());
			ps.setString(3, s.getSellerPassword());
			
			
			int x= ps.executeUpdate();
			
			if(x > 0) {
				msg = "Seller Register Sucessfully...!";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SellerException(e.getMessage());
		}
		
		return msg;
	}
	
	
	
	
	//---------------------------------Login Seller----------------------------------------------------------//
	
	
	

	@Override
	public String LoginSeller(String email, String pass) throws SellerException {
		
		String msg = "Login Failed...!";
		
		
		
		try (Connection conn= DbUtil.ProvideConection()){
			
			PreparedStatement ps= conn.prepareStatement("Select * from Seller where Semail = ? and Spassword = ?");
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next()) {
				msg = "Wellcome to..."+rs.getString("Sname");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SellerException(e.getMessage());
		}
		
		
		
		return msg;
		
	}



//-------------------------------------------Add Item---------------------------------------------------------//
	
	
	
	
	@Override
	public String AddItemBySeller(Item i) throws SellerException, ItemException {
		
		String msg = "Not Inserted...!";
		
		try (Connection conn= DbUtil.ProvideConection()){
			PreparedStatement ps= conn.prepareStatement("insert into item (iname,iquantity,iprice,idate) values (?,?,?,?)");
			ps.setString(1,i.getItemName() );
			ps.setInt(2, i.getItemQuantity());
			ps.setInt(3, i.getItemPrice());
			ps.setString(4, i.getItemDate());
			
			int x =  ps.executeUpdate();
			
			if( x > 0) {
				msg = "Item Add Sucessfully...!";
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
        return msg;				
	}
	

}
