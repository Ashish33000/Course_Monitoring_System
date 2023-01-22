
package com.masai.CourseUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;

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
		 System.out.println("Enter courseId to Update Course");
		 int courseId=sc.nextInt();
		 System.out.println("Enter course name to Update Course");
		String courseName=sc.next();
		
		 
		 AdminDao dao=new AdminDaoImpl();
	    try {
			String res=dao.updateCourse(courseId, courseName);
			System.out.println(res);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	
		

	}

}
