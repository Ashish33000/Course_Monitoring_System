package com.masai.CoursePlanUseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CoursePlanException;
import com.masai.model.CoursePlan;


public class createCoursePlanUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Courseplan Details");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace( );
		}
       Scanner sc=new Scanner(System.in);      
		
		AdminDao dao=new AdminDaoImpl();
		while(true) {
			System.out.println("Enter name of Batchid");
			int bids=sc.nextInt();
			System.out.println("Enter dayNumber");
			int dn=sc.nextInt();
			System.out.println("Enter Courseplan topic");
			String top=sc.next();
			System.out.println("Enter Batch duration");
			String duration=sc.next();
			System.out.println("Enter courseplan Status");
			String stat=sc.next();
			CoursePlan cps=new CoursePlan();
			cps.setBid(bids);
			cps.setDayNumber(dn);
			cps.setTopic(top);
			cps.setStatus(stat);		
			
		   try {
			String result=dao.createCoursePlan(cps);
			System.out.println(result);
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		
			System.out.println("Do You want to Register More CoursePlan?(Y/N)");
			
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thank You for Registration");
				break;
			}
			
		}

	}

}
