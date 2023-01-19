package com.masai.FacultyUsecases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.FacultyException;
import com.masai.model.Faculty;

public class viewAllFacultyUsecases {

	public static void main(String[] args) {
		AdminDao dao=new AdminDaoImpl();
		try {
			List<Faculty> list=dao.viewAllFacultyDetails();
			list.forEach(e->{
				System.out.println("Faculty Id is: "+e.getFid());
				System.out.println("Faculty Name is: "+e.getFname());				
				System.out.println("Faculty Address is: "+e.getAddress());
				System.out.println("Faculty MobileNo is: "+e.getMobile());
				System.out.println("Faculty Email is: "+e.getEmail());
				System.out.println("Faculty Password id: "+e.getPassword());
				
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
