package com.masai.Main;

import java.util.Scanner;

import com.masai.CourseUsecases.adminLoginUseCases;
import com.masai.exception.AdminException;

public class Main {

	public static void main(String[] args) throws AdminException {
		System.out.println("Welcome TO Course Management System");
		while(true) {
			System.out.println("\n1.Login as Admin \n2.Login as Faculty\n3.Exit");
			System.out.println("Enter Your Choice");
			Scanner sc=new Scanner(System.in);
			int choice=sc.nextInt();
		

	}

}
}