package com.masai.CourseUsecases;

import java.util.List;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.Course;

public class viewAllCourseDetailUseCase {

	public static void main(String[] args) {
		AdminDao dao=new AdminDaoImpl();
		try {
			List<Course> list=dao.viewAllCourseDetails();
			list.forEach(e->{
				System.out.println("Course Id is: "+e.getCid());
				System.out.println("Course name is: "+e.getCname());
				System.out.println("Course Fees is: "+e.getFee());
				System.out.println("Course Description is: "+e.getDescription());
				System.out.println("****************************************");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
