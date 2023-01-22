package com.masai.CoursePlanUseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CoursePlanException;

public class updateCourseplanUsecases {

	public static void main(String[] args) {
		System.out.println("Enter Status To Update coursePlan");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc=new Scanner(System.in); 
		 System.out.println("Enter Status to Update courseplan");
		String cpName=sc.next();
		 System.out.println("EntercoursplanidId to Update courseplan");
		 int cpId=sc.nextInt();
		 
		 AdminDao dao=new AdminDaoImpl();
		 try {
			String res=dao.updateFCoursePlan(cpName, cpId);
			System.out.println(res);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
