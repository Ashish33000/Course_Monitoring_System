package com.masai.dao;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.ReportForBatchDto;

public interface AdminDao {
	//AdminLogin
	public Admin loginAdmin(String username,String password) throws AdminException;
	//course
	public String createCourse(Course course) throws CourseException;
	public boolean isCourseAvailable(String cname) throws CourseException;
	public String  updateCourse(String name,Course course)throws CourseException;
	public List<Course> viewAllCourseDetails()throws CourseException;
	public String courseDeleteByName(String cname)throws CourseException;
	
	//batch
	public String createBatch(Batch batch) throws BatchException;
	public List<Batch> viewAllBatchDetails()throws BatchException;
	public String deleteBatchByName(String bname) throws BatchException;
	public List<ReportForBatchDto> coursePlanReportForBatch()throws BatchException;
	
	

}
