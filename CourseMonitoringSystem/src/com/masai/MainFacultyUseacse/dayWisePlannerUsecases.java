package com.masai.MainFacultyUseacse;

import java.util.Scanner;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.CoursePlan;

public class dayWisePlannerUsecases {

	public static void main(String[] args) {
		System.out.println("Enter Courseplan Details");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace( );
		}
       Scanner sc=new Scanner(System.in);  
       FacultyDao dao=new FacultyDaoImpl();
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
			String result=dao.dayWisePlanner(cps);
			System.out.println(result);
		} catch (FacultyException e) {
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
