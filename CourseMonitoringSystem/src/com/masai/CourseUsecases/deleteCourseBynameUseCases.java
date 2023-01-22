package com.masai.CourseUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;

public class deleteCourseBynameUseCases {

	public static void main(String[] args) {
	System.out.println("Enter Name To Delete Course");
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 Scanner sc=new Scanner(System.in);      
	 AdminDao dao=new AdminDaoImpl();
	 
	 while(true) {
		 System.out.println("Enter name of Course");
			String name=sc.next();
			try {
				String res=dao.courseDeleteByName(name);
				System.out.println(res);
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Do You want to Delete More Courses?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thank You ");
				break;
			}
		 
	 }
		

	}

}
