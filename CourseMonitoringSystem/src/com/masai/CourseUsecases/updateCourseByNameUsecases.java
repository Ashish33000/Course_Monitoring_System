
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
		 AdminDao dao=new AdminDaoImpl();
		 Course courses=new Course();
	
		

	}

}
