package com.UseCase;

import java.sql.Date;
import java.util.Scanner;

import com.Dao.SellerDao;
import com.Dao.SellerImpl;
import com.Exceptions.ItemException;
import com.Exceptions.SellerException;
import com.Model.Item;

public class LoginSellerUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Email :");
		String e = sc.next();
		
		System.out.println("Enter your Password :");
		String p = sc.next();
		
		SellerDao dao = new SellerImpl();
		
		try {
			String ans = dao.LoginSeller(e, p);
			System.out.println(ans);
			
		} catch (SellerException e1) {
			
			e1.printStackTrace();
		}
		
		
		System.out.println("Press 1 to create list of items to sell.");
		
		int Q = sc.nextInt();
		
		
		
		
		switch (Q) {
		case 1: {
			
			System.out.println("Enter Item Name :");
			String n = sc.next();
			
			System.out.println("Enter Item Quantity :");
			int q = sc.nextInt();
			
			System.out.println("Enter Item Price :");
			int pr = sc.nextInt();
			
			System.out.println("Enter Date of form yyyy/mm/dd :");
			String d = sc.next();
			
			java.util.Date date = new java.util.Date(d);
			
			Item i = new Item();
			i.setItemName(n);
			i.setItemQuantity(q);
			i.setItemPrice(pr);
			i.setItemDate(d);
			
			
			SellerDao dao1 = new SellerImpl();
			try {
				String ans = dao1.AddItemBySeller(i);
				System.out.println(ans);
				
			} catch (SellerException e1) {
				
				e1.printStackTrace();
				
			} catch (ItemException e1) {
				
				e1.printStackTrace();
			}
			
			break;
			
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + Q);
		}
		
		
		
	}

}
