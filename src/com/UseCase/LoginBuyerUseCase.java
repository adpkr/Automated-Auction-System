package com.UseCase;

import java.util.Scanner;

import com.Dao.BuyerDao;
import com.Dao.BuyerImpl;
import com.Exceptions.BuyerException;

public class LoginBuyerUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your Email :");
		String e = sc.next();
		
		System.out.println("Enter your password :");
		String p = sc.next();
		
		BuyerDao dao = new BuyerImpl();
		try {
			String ans = dao.LoginBuyer(e, p);
			System.out.println(ans);
			
		} catch (BuyerException e1) {
			
			e1.printStackTrace();
		}
		
	}

}
