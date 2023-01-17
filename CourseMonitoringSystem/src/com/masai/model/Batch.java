package com.masai.model;

public class Batch {
	private int bid;
	private String bname;
	private int cid;
	private int fid;
	private int numberOfStudent;
	private String batchStartDate;
	private String duration;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int bid, String bname, int cid, int fid, int numberOfStudent, String batchStartDate, String duration) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.cid = cid;
		this.fid = fid;
		this.numberOfStudent = numberOfStudent;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", cid=" + cid + ", fid=" + fid + ", numberOfStudent="
				+ numberOfStudent + ", batchStartDate=" + batchStartDate + ", duration=" + duration + "]";
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

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public String getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(String batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	

}
