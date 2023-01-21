package com.masai.MainFacultyUseacse;

import java.util.List;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.CoursePlan;


public class viewCoursePlanFacultyUseCases {

	public static void main(String[] args) {
		
		FacultyDao dao=new FacultyDaoImpl();
		try {
			List<CoursePlan> list=dao.viewAllCoursePlanDetails();
			list.forEach(e->{
				System.out.println("Course Id is: "+e.getCpid());
				System.out.println("BatchId is: "+e.getBid());
				System.out.println("Number of days is: "+e.getDayNumber());
				System.out.println("Topic is: "+e.getTopic());
				System.out.println("Status is: "+e.getStatus());
				
				System.out.println("**************************************************");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
