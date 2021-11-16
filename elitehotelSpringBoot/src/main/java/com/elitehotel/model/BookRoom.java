package com.elitehotel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="bookings")
public class BookRoom 
{
	@Id
	Integer roomno;
	String username;
	String fdate;
	String tdate;
	@Size(min=10,max=10,message="10 digits required")
	String Phoneno;
	public Integer getRoomno() {
		return roomno;
	}
	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFdate() {
		return fdate;
	}
	public void setFdate(String fdate) {
		this.fdate = fdate;
	}
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "BookRoom [roomno=" + roomno + ", username=" + username + ", fdate=" + fdate + ", tdate=" + tdate
				+ ", Phoneno=" + Phoneno + "]";
	}
	
	

}
