package com.elitehotel.model;

public class Login 
{
	String uname;
	String pword;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "Login [uname=" + uname + ", pword=" + pword + "]";
	}
	

}
