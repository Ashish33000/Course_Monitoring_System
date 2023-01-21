package com.masai.MainFacultyUseacse;

import java.util.Scanner;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;

public class changeFacultyPassword {

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
				String res=dao.changeFacultypassword(uername, password);
				System.out.println(res);
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
