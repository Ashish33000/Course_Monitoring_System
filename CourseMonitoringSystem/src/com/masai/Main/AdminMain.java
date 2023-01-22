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
import com.masai.model.ReportDayWiseDTO;

public class AdminMain {

	public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);		
		System.out.println("welcome Admin");
		System.out.println("\n2.Create Course\n3.course Aviblity\n4.Update course\n5.View All Course\n6.Deletecourse by name\n7.Create Btach\n8.view Batch\n9.delete Batch\n10.view Day Wise Batch\n11.Update Batch\n12.Create Faculty\n13.view faculty\n14.Update faculty\n15.Delete faculty\n16.Create course Plan\n17.view course plan\n18.delete course plan\n19.update course plan\n20report for batch DTO.");
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

      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
