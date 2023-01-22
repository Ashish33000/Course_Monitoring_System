package com.masai.dao;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.CoursePlanException;
import com.masai.exception.FacultyException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.CoursePlan;
import com.masai.model.Faculty;
import com.masai.model.ReportForBatchDTO;
import com.masai.model.ReportDayWiseDTO;

public interface AdminDao {
	//AdminLogin
	public Admin loginAdmin(String username,String password) throws AdminException;
	//course
	public String createCourse(Course course) throws CourseException;
	public boolean isCourseAvailable(String cname) throws CourseException;
	public String  updateCourse(int cid,String name)throws CourseException;
	public List<Course> viewAllCourseDetails()throws CourseException;
	public String courseDeleteByName(String cname)throws CourseException;
	
	//batch
	public String createBatch(Batch batch) throws BatchException;
	public List<Batch> viewAllBatchDetails()throws BatchException;
	public String deleteBatchByName(String bname) throws BatchException;
	
	public List<ReportForBatchDTO> coursePlanReportForBatch()throws BatchException;
	public String  updateBatch(int bid,String name)throws BatchException;
	
	
	//faculty
	public String createFaculty(Faculty faculty) throws FacultyException;
	public List<Faculty> viewAllFacultyDetails() throws FacultyException;
	public String deleteFacultyByName(String fname) throws FacultyException;
	public String  updateFaculty(String name,int fid)throws FacultyException;
	//coursePlan
	public String createCoursePlan(CoursePlan cp) throws CoursePlanException;
	public List<CoursePlan> viewAllCoursePlanDetails() throws CoursePlanException;
	public String deleteCoursePlanBycpid(int cpid)throws CoursePlanException;
	public String  updateFCoursePlan(String status,int cpid)throws CoursePlanException;
	public List<ReportDayWiseDTO> daywisePlanforBatch()throws CoursePlanException;
	

}
