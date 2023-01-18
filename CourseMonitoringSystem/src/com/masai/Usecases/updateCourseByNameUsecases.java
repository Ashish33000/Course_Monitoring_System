package com.masai.Usecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.Course;

public class updateCourseByNameUsecases {

	public static void main(String[] args) {
		System.out.println("Enter Name To Update Course");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc=new Scanner(System.in);      
		 AdminDao dao=new AdminDaoImpl();
		 
		 while(true) {
			 System.out.println("update name of Course");
				String name=sc.next();
				System.out.println("update fee of Course");
				int f=sc.nextInt();
				 System.out.println("update name of Course");
					String name=sc.next();
				
				Course c=new Course();
				c.setCname(name);
				
				try {
					String res=dao.updateCourse(name, c);
					System.out.println(res);
				} catch (CourseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Do You want to update More Courses?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")) {
					System.out.println("Thank You for Registration");
					break;
				}
			 
		 }

	}

}
