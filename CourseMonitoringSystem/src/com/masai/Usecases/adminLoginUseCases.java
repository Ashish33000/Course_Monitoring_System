package com.masai.Usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Admin;

public class adminLoginUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Login Details");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner sc=new Scanner(System.in);
		
		AdminDao dao=new AdminDaoImpl();
	
			System.out.println("Enter Admin Username");
			String uername=sc.next();
			System.out.println("Enter Admin Password");
			String password=sc.next();
		while(true)	{
			try {
				Admin admin=dao.loginAdmin(uername, password);
				System.out.println("Welcome:  "+admin.getName());
			} catch (AdminException e) {
				System.out.println(e.getMessage());
			}
			
			try { 
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		System.out.println("Do you want to LogOut(Y)");
		String res=sc.next();
		if(res.equalsIgnoreCase("Y")) {
			System.out.println("Thank You");
			return;
		}else {
			System.out.println("Welcome");
		}
		}

	}

}
