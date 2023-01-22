package com.masai.MainFacultyUseacse;

import java.util.Scanner;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.Faculty;



public class facultyLoginUseCases {

	public static boolean login() {
		boolean flag=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Faculty Username");
		String uername=sc.next();
		System.out.println("Enter Faculty Password");
		String password=sc.next();
		
		
		try {
			FacultyDao dao=new FacultyDaoImpl();
			Faculty fac=dao.loginFaculty(uername, password);
			flag=true;
			System.out.println("Welcome: "+fac.getFname());
			
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	

	}

}
