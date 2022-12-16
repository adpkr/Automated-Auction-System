package com.UseCase;

import java.util.Scanner;

import com.Dao.SellerDao;
import com.Dao.SellerImpl;
import com.Exceptions.SellerException;
import com.Model.Seller;

public class SellerRegisterUseCase {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Name :");
		String n = sc.next();
		
		System.out.println("Enter your Email :");
		String e = sc.next();
		
		System.out.println("Enter your Password :");
		String p = sc.next();
		
		
		Seller s = new Seller();
		
		s.setSellerName(n);
		s.setSellerEmail(e);
		s.setSellerPassword(p);
		
		SellerDao dao = new SellerImpl();
		
		try {
			String ans = dao.RegisterSeller(s);
			System.out.println(ans);
			
		} catch (SellerException e1) {
			
			e1.printStackTrace();
		}
		
		
		
	}

}
