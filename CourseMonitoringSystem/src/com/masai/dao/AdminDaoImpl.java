package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.BatchException;
import com.masai.exception.CourseException;
import com.masai.exception.FacultyException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.Faculty;
import com.masai.model.ReportForBatchDto;
import com.masai.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		Admin admin=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from admin where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				admin=new Admin();
				admin.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		return admin;
	}

	@Override
	public String createCourse(Course course) throws CourseException {
		String message="Course Not Created.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into course(cname,fee,description) values(?,?,?)");
			ps.setString(1, course.getCname());
			ps.setInt(2, course.getFee());
			ps.setString(3, course.getDescription());
			int x=ps.executeUpdate();
			if(x>0) {
				message="Course Created Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		return message;
	}

	@Override
	public boolean isCourseAvailable(String cname) throws CourseException {
		boolean flag=false;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from course where cname=?");
			ps.setString(1, cname);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return flag;
	}

	@Override
	public String updateCourse(String name,Course course) throws CourseException {
		String message="Course not updated";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update course set cname=?,fee=?,description=? where cname=?");
			ps.setString(1, course.getCname());
			ps.setInt(2,course.getFee());
			ps.setString(3, course.getDescription());
			ps.setString(4, name);
			
		int x=ps.executeUpdate();
			if(x>0) message="Course Updated Sucessfully...";					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Course> viewAllCourseDetails() throws CourseException {
		List<Course> courses=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from course");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Course course=new Course();
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setFee(rs.getInt("fee"));
				course.setDescription(rs.getString("description"));
				courses.add(course);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		return courses;
	}

	@Override
	public String courseDeleteByName(String cname) throws CourseException {
		String message="Course Not Added.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from course where cname=?");
			ps.setString(1, cname);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Course Deleted Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		return message;
	}

	@Override
	public String createBatch(Batch batch) throws BatchException {
		String message="Batch Not Created.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into batch(bname,numberOfStudent,batchStartDate,duration,cid,fid) values(?,?,?,?,?,?)");
			ps.setString(1, batch.getBname());
			ps.setInt(2, batch.getNumberOfStudent());
			ps.setString(3,batch.getBatchStartDate());
			ps.setString(4, batch.getDuration());
			ps.setInt(5, batch.getCid());
			ps.setInt(6, batch.getFid());
			int x=ps.executeUpdate();
			if(x>0) {
				message="Batch Created Sucessfully.....";
			}else {
				throw new BatchException("invalid course and facultyId");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Batch> viewAllBatchDetails() throws BatchException {
		List<Batch> batches=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from batch");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Batch batch=new Batch();
				batch.setBid(rs.getInt("bid"));
				batch.setBname(rs.getString("bname"));
				batch.setCid(rs.getInt("cid"));
				batch.setFid(rs.getInt("fid"));
				batch.setNumberOfStudent(rs.getInt("numberOfStudent"));
				batch.setBatchStartDate(rs.getString("batchStartDate"));
				batch.setDuration(rs.getString("duration"));
				batches.add(batch);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return batches;
	}

	@Override
	public String deleteBatchByName(String bname) throws BatchException {
		String message="Batch Not Deleted.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from batch where bname=?");
			ps.setString(1, bname);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Batch Deleted Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<ReportForBatchDto> coursePlanReportForBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}
//faculty
	@Override
	public String createFaculty(Faculty faculty) throws FacultyException {
		String message="Faculty Not Created.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into faculty(fname,address,mobile,email,password) values(?,?,?,?,?)");
			ps.setString(1, faculty.getFname());			
			ps.setString(2,faculty.getAddress());
			ps.setString(3, faculty.getMobile());		
			ps.setString(4, faculty.getEmail());
			ps.setString(5, faculty.getPassword());
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Faculty Created Sucessfully.....";
			}else {
				throw new FacultyException("invalid course and facultyId");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Faculty> viewAllFacultyDetails() throws FacultyException {
		List<Faculty> facultys=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from faculty");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Faculty faculty=new Faculty();
				faculty.setFid(rs.getInt("fid"));
				faculty.setFname(rs.getString("fname"));
				faculty.setAddress(rs.getString("address"));
				faculty.setEmail(rs.getString("email"));
				faculty.setPassword(rs.getString("password"));	
				
				facultys.add(faculty);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return facultys;
	}

	@Override
	public String deleteFacultyByName(String fname) throws FacultyException {
		String message="Faculty Not Deleted.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from faculty where fname=?");
			ps.setString(1, fname);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="Faculty Deleted Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return message;
	}

}
