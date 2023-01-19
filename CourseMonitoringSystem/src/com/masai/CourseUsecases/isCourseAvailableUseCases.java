package com.masai.CourseUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;

public class isCourseAvailableUseCases {

	public static void main(String[] args) {
		System.out.println("Enetr name of course to check Avability");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
       Scanner sc=new Scanner(System.in);		
		AdminDao dao=new AdminDaoImpl();
		
		while(true) {
			System.out.println("Enetr name of course");
			String name=sc.next();
			try {
				boolean res=dao.isCourseAvailable(name);
				if(res==true) {
					System.out.println("Course is available");
				}else {
					System.out.println("Course is Not-available");
				}
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Do You want find more course Avaiblity?(Y/N)");
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thank You for Registration");
				break;
			}
			
			
		}

	}

}
