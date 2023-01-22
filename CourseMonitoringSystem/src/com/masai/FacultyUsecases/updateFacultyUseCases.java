package com.masai.FacultyUsecases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.FacultyException;

public class updateFacultyUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Name To Update Faculty");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Scanner sc=new Scanner(System.in); 
		 System.out.println("Enter Faculty name to Update faculty");
		String FacultyName=sc.next();
		 System.out.println("Enter facultyId to Update faculty");
		 int FacultyId=sc.nextInt();
		 
		 AdminDao dao=new AdminDaoImpl();
		 try {
			String res=dao.updateFaculty(FacultyName, FacultyId);
			System.out.println(res);
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 

	}

}
