package com.masai.model;

public class Faculty {
	private int fid;
	private String fname;
	private String address;
	private String mobile;
	private String email;
	private String password;
	
	public Faculty() {
		// TODO Auto-generated constructor stub
	}

	public Faculty(int fid, String fname, String address, String mobile, String email, String password) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", password=" + password + "]";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
