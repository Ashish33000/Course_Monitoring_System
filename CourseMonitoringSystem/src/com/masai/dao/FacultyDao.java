package com.masai.dao;

import java.util.List;


import com.masai.exception.FacultyException;
import com.masai.model.CoursePlan;
import com.masai.model.Faculty;

public interface FacultyDao {
	public Faculty loginFaculty(String username,String password) throws FacultyException;
	public List<CoursePlan> viewAllCoursePlanDetails() throws FacultyException;
	public String dayWisePlanner(CoursePlan cp) throws FacultyException;
	public String changeFacultypassword(String username,String password)throws FacultyException;
	
	

}
