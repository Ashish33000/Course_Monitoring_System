package com.masai.FacultyUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.Faculty;

public class createfacultyUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Faculty Details");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace( );
		}
       Scanner sc=new Scanner(System.in);      
		
		AdminDao dao=new AdminDaoImpl();
		while(true) {
			System.out.println("Enter name of Faculty");
			String name=sc.next();
			System.out.println("Enter address of Faculty");
			String ads=sc.next();
			System.out.println("Enter MobileNo of Faculty");
			String mob=sc.next();
			System.out.println("Enter email of Faculty");
			String emails=sc.next();
			System.out.println("Enter Password of Faculty");
			String pass=sc.next();
			Faculty fac=new Faculty();
			fac.setFname(name);
			fac.setAddress(ads);
			fac.setMobile(mob);
			fac.setEmail(emails);
			fac.setPassword(pass);
			
			try {
				String result=dao.createFaculty(fac);
				System.out.println(result);
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Do You want to Register More Faculty?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thank You for Faculty Registration");
				break;
			
			
			
		}
		
		
		

	}

	}
}
