package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.FacultyException;
import com.masai.model.CoursePlan;
import com.masai.model.Faculty;
import com.masai.utility.DBUtil;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public Faculty loginFaculty(String username, String password) throws FacultyException {
		Faculty faculty=null;
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from faculty where email=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				faculty=new Faculty();
				faculty.setFname(rs.getString("fname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return faculty;
	}

	@Override
	public List<CoursePlan> viewAllCoursePlanDetails() throws FacultyException {
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
			throw new FacultyException(e.getMessage());
		}
		
		return cp;
	}


	@Override
	public String changeFacultypassword(String username, String password) throws FacultyException {
		String message="Password Not changed";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update faculty set password=? where email=?");
			ps.setString(1, password);
			ps.setString(2, username);
			int x=ps.executeUpdate();
			if(x>0) message="Password Updated";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return message;
	}

	@Override
	public String dayWisePlanner(CoursePlan cp) throws FacultyException {
		String message="Daywise Planner Not Created.......";
		try(Connection conn=DBUtil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into coursePlan(bid,dayNumber,topic,status) values(?,?,?,?)");
			ps.setInt(1, cp.getBid());			
			ps.setInt(2,cp.getDayNumber());
			ps.setString(3, cp.getTopic());		
			ps.setString(4, cp.getStatus());
		
			
			
			int x=ps.executeUpdate();
			if(x>0) {
				message="DaywisePlanner Created Sucessfully.....";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FacultyException(e.getMessage());
		}
		return message;
	}

}
