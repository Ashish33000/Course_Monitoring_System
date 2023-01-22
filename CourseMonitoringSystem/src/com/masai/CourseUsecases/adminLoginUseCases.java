package com.masai.CourseUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Admin;

public class adminLoginUseCases {

	public static boolean login() {
		boolean flag=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Faculty Username");
		String uername=sc.next();
		System.out.println("Enter Faculty Password");
		String password=sc.next();
		
		try {
			AdminDao dao=new AdminDaoImpl();
			Admin admin=dao.loginAdmin(uername, password);
			flag=true;
			System.out.println("Welcome: "+admin.getName());
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return flag;
		
	}

}
