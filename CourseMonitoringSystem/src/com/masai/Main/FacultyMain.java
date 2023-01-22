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
	
		System.out.println("\n1.Login Faculty\n2.View All Course\n3.dayWise Planneer\n4.change Password");
		int x=sc.nextInt();
		switch(x) {
		case 1:{
			facultyLoginUseCases.main(args);
			break;
		}
		case 2:{
			viewCoursePlanFacultyUseCases.main(args);
			break;
		}
		case 3: {
			dayWisePlannerUsecases.main(args);
			break;
		}
		case 4:{
			changeFacultyPassword.main(args);
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		

	}

}
