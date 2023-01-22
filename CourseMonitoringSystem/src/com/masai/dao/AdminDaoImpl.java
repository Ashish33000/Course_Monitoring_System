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
import com.masai.exception.CoursePlanException;
import com.masai.exception.FacultyException;
import com.masai.model.Admin;
import com.masai.model.Batch;
import com.masai.model.Course;
import com.masai.model.CoursePlan;
import com.masai.model.Faculty;
import com.masai.model.ReportDayWiseDTO;
import com.masai.model.ReportForBatchDTO;
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
	public String updateCourse(String name,int cid) throws CourseException {
		String message="Course not updated";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update course set cname=?, where cid=?");			
			ps.setString(1,name);
			ps.setInt(2, cid);
			
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
				faculty.setMobile(rs.getString("mobile"));
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

	@Override
	public String createCoursePlan(CoursePlan cp) throws CoursePlanException {
		String message="CoursePlan Not Created.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into coursePlan(bid,dayNumber,topic,status) values(?,?,?,?)");
			ps.setInt(1, cp.getBid());			
			ps.setInt(2,cp.getDayNumber());
			ps.setString(3, cp.getTopic());		
			ps.setString(4, cp.getStatus());
		
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="CoursePlan Created Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return message;
	}

	@Override
	public List<CoursePlan> viewAllCoursePlanDetails() throws CoursePlanException {
		List<CoursePlan> cp =new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from coursePlan");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CoursePlan cps=new CoursePlan();
				cps.setCpid(rs.getInt("cpid"));
				cps.setBid(rs.getInt("bid"));
				cps.setTopic(rs.getString("topic"));
				cps.setStatus(rs.getString("status"));
				cp.add(cps);
			
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return cp;
	}

	@Override
	public String deleteCoursePlanBycpid(int cpid) throws CoursePlanException {
		String message="CoursePlan Not Deleted.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("delete from coursePlan where cpid=?");
			ps.setInt(1, cpid);
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="CoursePlan Deleted Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return message;
	}

	@Override
	public String updateBatch(String name,int bid) throws BatchException {
		String message="Batch not updated";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update batch set bname=?, where bid=?");			
			ps.setString(1,name);
			ps.setInt(2, bid);		
			
		int x=ps.executeUpdate();
			if(x>0) message="Course Updated Sucessfully...";					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BatchException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String updateFaculty(String name,int fid) throws FacultyException {
		String message="Faculty not updated";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update faculty set fname=?, where fid=?");			
			ps.setString(1,name);
			ps.setInt(2, fid);	
			
		int x=ps.executeUpdate();
			if(x>0) message="Faculty Updated Sucessfully...";					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String updateFCoursePlan(String status,int cpid) throws CoursePlanException {
		String message="CoursePlan not updated";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update coursePlan set status=?, where cpid=?");			
			ps.setString(1,status);
			ps.setInt(2, cpid);		
			
		int x=ps.executeUpdate();
			if(x>0) message="CoursePlan Updated Sucessfully...";					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<ReportDayWiseDTO> daywisePlanforBatch() throws CoursePlanException {
		List<ReportDayWiseDTO> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select f.fid,f.fname,c.cid,c.cname,b.bid,b.bname,cp.dayNumber,cp.status from coursePlan cp INNER JOIN batch b on cp.bid=b.bid INNER JOIN course c on c.cid=b.cid INNER JOIN faculty f on f.fid=b.fid group by bid");			
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int FID=rs.getInt("fid");
					String FN=rs.getString("fname");
					int CID=rs.getInt("cid");
					String CN=rs.getString("cname");
					int BID=rs.getInt("bid");
					String BN=rs.getString("bname");
					int DN=rs.getInt("dayNumber");
					String status=rs.getString("status");
					ReportDayWiseDTO dto=new ReportDayWiseDTO();
					dto.setFid(FID);
					dto.setFname(FN);
					dto.setCid(CID);
					dto.setCname(CN);
					dto.setBid(BID);
					dto.setBname(BN);
					dto.setDayNumber(DN);
					dto.setStatus(status);
					list.add(dto);
					
					
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CoursePlanException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<ReportForBatchDTO> coursePlanReportForBatch() throws BatchException {
		List<ReportForBatchDTO> list=new ArrayList<>();
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select f.fid,f.fname,c.cid,c.cname,b.bid,b.bname,cp.cpid,cp.status from courseplan cp INNER JOIN batch b ON cp.bid=b.bid INNER JOIN course c ON c.cid=b.cid INNER JOIN faculty f ON f.fid=b.fid group by bid");			
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					int FID=rs.getInt("fid");
					String FN=rs.getString("fname");
					int CID=rs.getInt("cid");
					String CN=rs.getString("cname");
					int BID=rs.getInt("bid");
					String BN=rs.getString("bname");
					int CPID=rs.getInt("cpid");
					String status=rs.getString("status");
					ReportForBatchDTO dto=new ReportForBatchDTO();
					dto.setFid(FID);
					dto.setFname(FN);
					dto.setCid(CID);
					dto.setCname(CN);
					dto.setBid(BID);
					dto.setBname(BN);
					dto.setCpid(CPID);
					dto.setStatus(status);
					list.add(dto);				
					
					
				}
			
			
		} catch (SQLException e) {
		
			throw new BatchException(e.getMessage());
		}
		return list;
	}

}
