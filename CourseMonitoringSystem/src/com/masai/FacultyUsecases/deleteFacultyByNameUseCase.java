package com.masai.FacultyUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.FacultyException;

public class deleteFacultyByNameUseCase {

	public static void main(String[] args) {
		System.out.println("Enter Name To Delete faculty");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc=new Scanner(System.in);      
		 AdminDao dao=new AdminDaoImpl();
		 
		 while(true) {
			 System.out.println("Enter name of Faculty");
				String name=sc.next();
				try {
					String result=dao.deleteFacultyByName(name);
					System.out.println(result);
				} catch (FacultyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Do You want to Delete More Faculty?(Y/N)");
				String res=sc.next();
				if(res.equalsIgnoreCase("N")) {
					System.out.println("Faculty is Deleted");
					break;
				}
			 
		 }

	}

}
