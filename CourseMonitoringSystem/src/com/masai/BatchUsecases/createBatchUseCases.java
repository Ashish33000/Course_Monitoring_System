
package com.masai.BatchUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BatchException;
import com.masai.model.Batch;



public class createBatchUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Batch Details");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace( );
		}
       Scanner sc=new Scanner(System.in);      
		
		AdminDao dao=new AdminDaoImpl();
		while(true) {
			System.out.println("Enter name ofBatch");
			String name=sc.next();
			System.out.println("Enter number of Student");
			int nos=sc.nextInt();
			System.out.println("Enter Batch Start date");
			String date=sc.next();
			System.out.println("Enter Batch duration");
			String duration=sc.next();
			System.out.println("Enter courseId");
			int cId=sc.nextInt();
			System.out.println("Enter facultyId");
			int FId=sc.nextInt();
			Batch batch=new Batch();
			batch.setBname(name);
			batch.setNumberOfStudent(nos);
			batch.setBatchStartDate(date);
			batch.setDuration(duration);
			batch.setCid(cId);
			batch.setFid(FId);
			
			try {
				String result=dao.createBatch(batch);
				System.out.println(result);
			} catch (BatchException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("Do You want to Register More Courses?(Y/N)");
			
			String res=sc.next();
			if(res.equalsIgnoreCase("N")) {
				System.out.println("Thank You for Registration");
				break;
			}
			
		}


	}

}
