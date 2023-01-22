package com.masai.Main;

import java.util.Scanner;

import com.masai.MainFacultyUseacse.changeFacultyPassword;
import com.masai.MainFacultyUseacse.dayWisePlannerUsecases;
import com.masai.MainFacultyUseacse.facultyLoginUseCases;
import com.masai.MainFacultyUseacse.viewCoursePlanFacultyUseCases;

public class FacultyMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("welcome Faculty");
	
		System.out.println("\n1.View All Course\n2.dayWise Planneer\n3.change Password");
		int x=sc.nextInt();
		switch(x) {
		
		case 1:{
			viewCoursePlanFacultyUseCases.main(args);
			break;
		}
		case 2: {
			dayWisePlannerUsecases.main(args);
			break;
		}
		case 3:{
			changeFacultyPassword.main(args);
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		

	}

}
