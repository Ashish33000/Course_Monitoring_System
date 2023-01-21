package com.masai.CoursePlanUseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CoursePlanException;

public class deleteCourseplanByCpIdUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Name To CoursePlan");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc=new Scanner(System.in);      
		 AdminDao dao=new AdminDaoImpl();
		 while(true) {
			 System.out.println("Enter name of courseplanId");
				int id=sc.nextInt();
				try {
					String result=dao.deleteCoursePlanBycpid(id);
					System.out.println(result);
				} catch (CoursePlanException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Do You want to Delete More CoursePlan?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")) {
					System.out.println("Your Batch is deleted");
					break;
				}
				
		 }

	}

}
