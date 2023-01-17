package com.masai.model;

public class ReportDayDTO {
	//faculty table
	private int fid;
	private String fname;
	//course table
	private int cid;
	private String cname;
	//batch table
	private int bid;
	private String bname;
	//course plan
	private int cpid;
	private String Status;
	
	public ReportDayDTO() {
		// TODO Auto-generated constructor stub
	}
	public ReportDayDTO(int fid, String fname, int cid, String cname, int bid, String bname, int cpid, String status) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.cid = cid;
		this.cname = cname;
		this.bid = bid;
		this.bname = bname;
		this.cpid = cpid;
		Status = status;
	}
	@Override
	public String toString() {
		return "ReportDayDTO [fid=" + fid + ", fname=" + fname + ", cid=" + cid + ", cname=" + cname + ", bid=" + bid
				+ ", bname=" + bname + ", cpid=" + cpid + ", Status=" + Status + "]";
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	

}
