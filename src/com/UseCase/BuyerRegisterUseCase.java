package com.UseCase;

import java.util.Scanner;

import com.Dao.BuyerDao;
import com.Dao.BuyerImpl;
import com.Exceptions.BuyerException;
import com.Model.Buyer;

public class BuyerRegisterUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Name :");
		String n = sc.next();
		
		System.out.println("Enter your Email :");
		String e = sc.next();
		
		System.out.println("Enter your Password :");
		String p = sc.next();
		
		Buyer b = new Buyer();
		
		b.setBuyerName(n);
		b.setBuyerEmail(e);
		b.setBuyerPassword(p);
		
		BuyerDao dao = new BuyerImpl();
		
		try {
			String result = dao.RegisterBuyer(b);
			
			System.out.println(result);
			
			
		} catch (BuyerException e1) {
			
			e1.printStackTrace();
		}
		
		
	}

}
