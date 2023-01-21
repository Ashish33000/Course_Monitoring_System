package com.masai.MainFacultyUseacse;

import java.util.Scanner;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.Faculty;



public class facultyLoginUseCases {

	public static void main(String[] args) {
		System.out.println("Enter Faculty Login Details");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner sc=new Scanner(System.in);
		
		    FacultyDao dao=new FacultyDaoImpl();
	
			System.out.println("Enter Faculty Username");
			String uername=sc.next();
			System.out.println("Enter Faculty Password");
			String password=sc.next();
			
			try {
				Faculty fac=dao.loginFaculty(uername, password);
				System.out.println("Welcome: "+fac.getFname());
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
