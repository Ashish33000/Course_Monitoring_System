package com.masai.Main;

import java.util.Scanner;

import com.masai.BatchUsecases.createBatchUseCases;
import com.masai.BatchUsecases.deleteBatchUseCase;
import com.masai.BatchUsecases.reportwiseBatchDTO;
import com.masai.BatchUsecases.updateBatchUsecases;
import com.masai.BatchUsecases.viewAllBatchesUseCases;
import com.masai.CoursePlanUseCases.ReportdayWiseDTOUsecases;
import com.masai.CoursePlanUseCases.createCoursePlanUseCases;
import com.masai.CoursePlanUseCases.deleteCourseplanByCpIdUseCases;
import com.masai.CoursePlanUseCases.updateCourseplanUsecases;
import com.masai.CoursePlanUseCases.viewAllCourseplanUseCases;
import com.masai.CourseUsecases.adminLoginUseCases;
import com.masai.CourseUsecases.createCourseUsecases;
import com.masai.CourseUsecases.deleteCourseBynameUseCases;
import com.masai.CourseUsecases.isCourseAvailableUseCases;
import com.masai.CourseUsecases.updateCourseByNameUsecases;
import com.masai.CourseUsecases.viewAllCourseDetailUseCase;
import com.masai.FacultyUsecases.createfacultyUseCases;
import com.masai.FacultyUsecases.deleteFacultyByNameUseCase;
import com.masai.FacultyUsecases.updateFacultyUseCases;
import com.masai.FacultyUsecases.viewAllFacultyUsecases;
import com.masai.MainFacultyUseacse.changeFacultyPassword;
import com.masai.MainFacultyUseacse.dayWisePlannerUsecases;
import com.masai.MainFacultyUseacse.facultyLoginUseCases;
import com.masai.MainFacultyUseacse.viewCoursePlanFacultyUseCases;
import com.masai.exception.AdminException;

public class Main {

	public static void main(String[] args) throws AdminException {
		System.out.println("Welcome TO Course Management System");
		while(true) {
			System.out.println("\n1.Login as Admin \n2.Login as Faculty\n3.Exit");
			System.out.println("Enter Your Choice");
			Scanner sc=new Scanner(System.in);
			int y=sc.nextInt();
			if(y==1) {
				if(adminLoginUseCases.login()==true) {
					while(true) {
						System.out.println("****************************");
						System.out.println("select one option");
						System.out.println("\n1.Create Course\n2.course Aviblity\n3.Update course\n4.View All Course\n5.Deletecourse by name\n6.Create Btach\n7.view Batch\n8.delete Batch\n9.view Day Wise Batch\n10.Update Batch\n11.Create Faculty\n12.view faculty\n13.Update faculty\n14.Delete faculty\n15.Create course Plan\n16.view course plan\n17.delete course plan\n18.update course plan\n19.report for batch DTO.");
						int x=sc.nextInt();
						switch(x) {
						case 1:{
					    	createCourseUsecases.main(args); 
					    	break;
					    	  
					      }
					     case 2:{
					    	 isCourseAvailableUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 3:{
					    	 updateCourseByNameUsecases.main(args);
					    	 break;
					   	  
					     }
					     case 4:{
					    	 viewAllCourseDetailUseCase.main(args);
					    	 break;
					   	  
					     }
					     case 5:{
					    	 deleteCourseBynameUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 6:{
					    	 createBatchUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 7:{
					    	 viewAllBatchesUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 8:{
					    	 deleteBatchUseCase.main(args);
					    	 break;
					   	  
					     }
					     case 9:{
					    	 reportwiseBatchDTO.main(args);
					    	 break;
					   	  
					     }
					     case 10:{
					    	 updateBatchUsecases.main(args);
					    	 break;
					   	  
					     }
					     case 11:{
					    	 createfacultyUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 12:{
					    	 viewAllFacultyUsecases.main(args);
					    	 break;
					   	  
					     }
					     case 13:{
					    	 updateFacultyUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 14:{
					    	 deleteFacultyByNameUseCase.main(args);
					    	 break;
					   	  
					     }
					     case 15:{
					    	 createCoursePlanUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 16:{
					    	viewAllCourseplanUseCases.main(args); 
					    	break;
					   	  
					     }
					     case 17:{
					    	 deleteCourseplanByCpIdUseCases.main(args);
					    	 break;
					   	  
					     }
					     case 18:{
					    	 updateCourseplanUsecases.main(args);
					    	 break;
					   	  
					     }
					     case 19:{
					    	 ReportdayWiseDTOUsecases.main(args);
					    	 break;
					   	  
					     }  
						
																	
						}//switch
						System.out.println();
						System.out.println("Do You Want to Exit(Y/N)");
						String s=sc.next();
						if(s.compareToIgnoreCase("N")==0) {
				          System.out.println("Thank You");
				          break;
						}else {
							continue;
						}
						
						
						
						
						
					}
					
					
				}
			}else if(y==2) {
				if(facultyLoginUseCases.login()==true) {
					while(true) {
						System.out.println("****************************");
						System.out.println("select one option");
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
						System.out.println();
						System.out.println("Do You Want to Exit(Y/N)");
						String s=sc.next();
						if(s.compareToIgnoreCase("N")==0) {
				          System.out.println("Thank You");
				          break;
						}else {
							continue;
						
						}
					}
					
				}
				
			}else {
				System.out.println("Thank You");
				break;
			}
		

	}

}
}