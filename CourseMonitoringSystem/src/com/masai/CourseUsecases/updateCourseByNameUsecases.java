
package com.masai.CourseUsecases;

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
		 System.out.println("Enter course name to Update Course");
		String courseName=sc.next();
		 System.out.println("Enter courseId to Update Course");
		 int courseId=sc.nextInt();
		 
		 AdminDao dao=new AdminDaoImpl();
		 try {
			String res=dao.updateCourse(courseName, courseId);
			System.out.println(res);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	
		

	}

}
