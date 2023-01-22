package com.masai.BatchUsecases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BatchException;
import com.masai.model.ReportForBatchDTO;

public class reportwiseBatchDTO {

	public static void main(String[] args) {
		AdminDao dao=new AdminDaoImpl();
		try {
			List<ReportForBatchDTO> list=dao.coursePlanReportForBatch();
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
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
