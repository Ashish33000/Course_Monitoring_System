package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.BatchException;
import com.masai.exception.FacultyException;
import com.masai.model.CoursePlan;
import com.masai.model.Faculty;
import com.masai.model.ReportDayWiseDTO;
import com.masai.model.ReportForBatchDTO;
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
	public List<ReportForBatchDTO> daywisePlanner() throws FacultyException {
		
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
		
			throw new FacultyException(e.getMessage());
		}
		return list;
	}


	



}
