package com.masai.model;

public class CoursePlan {
	private int cpid;
	private int bid;
	private int dayNumber;
	private String topic;
	private String status;
	public CoursePlan() {
		// TODO Auto-generated constructor stub
	}
	public CoursePlan(int cpid, int bid, int dayNumber, String topic, String status) {
		super();
		this.cpid = cpid;
		this.bid = bid;
		this.dayNumber = dayNumber;
		this.topic = topic;
		this.status = status;
	}
	@Override
	public String toString() {
		return "CoursePlan [cpid=" + cpid + ", bid=" + bid + ", dayNumber=" + dayNumber + ", topic=" + topic
				+ ", status=" + status + "]";
	}
	public int getCpid() {
		return cpid;
	}
	public void setCpid(int cpid) {
		this.cpid = cpid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
