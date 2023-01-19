package com.masai.BatchUsecases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.BatchException;
import com.masai.model.Batch;

public class viewAllBatchesUseCases {

	public static void main(String[] args) {
		AdminDao dao=new AdminDaoImpl();
		try {
			List<Batch> list=dao.viewAllBatchDetails();
			list.forEach(e->{
				System.out.println("Batch Id is: "+e.getBid());
				System.out.println("Batch Name is: "+e.getBname());
				System.out.println("Course Id is: "+e.getCid());
				System.out.println("Faculty Id is: "+e.getFid());
				System.out.println("Number Of Student is: "+e.getNumberOfStudent());
				System.out.println("Batch start date is: "+e.getBatchStartDate());
				System.out.println("Duration is: "+e.getDuration());
				System.out.println("**************************************************");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
