package com.masai.CoursePlanUseCases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CoursePlanException;
import com.masai.model.CoursePlan;


public class viewAllCourseplanUseCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDao dao=new AdminDaoImpl();
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
		} catch (CoursePlanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
