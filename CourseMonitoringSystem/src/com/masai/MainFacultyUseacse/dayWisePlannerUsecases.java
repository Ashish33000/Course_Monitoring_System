package com.masai.MainFacultyUseacse;

import java.util.List;

import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.ReportForBatchDTO;

public class dayWisePlannerUsecases {

	public static void main(String[] args) {
		
		FacultyDao dao=new FacultyDaoImpl();
		try {
			List<ReportForBatchDTO> list=dao.daywisePlanner();
			list.forEach(e->{
				System.out.println("Faculty id: "+e.getFid());
				System.out.println("Faculty Name: "+e.getFname());
				System.out.println("course id: "+e.getCid());
				System.out.println("course Name: "+e.getCname());
				System.out.println("Batch  id: "+e.getBid());
				System.out.println("Batch Name: "+e.getBname());
				System.out.println( "course palan ID: "+e.getCpid());
				System.out.println("courseplan status: "+e.getStatus());
				System.out.println("******************************************");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (FacultyException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}	
		

	}

}
