package model;

public class BookModel
{
	String uname;
	Integer roomno;
	String roomtype;
	int capacity;
	String fdate;
	String tdate;
	 String phone;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getRoomno() {
		return roomno;
	}
	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "BookModel [uname=" + uname + ", roomno=" + roomno + ", roomtype=" + roomtype + ", capacity=" + capacity
				+ ", fdate=" + fdate + ", tdate=" + tdate + ", phone=" + phone + "]";
	}
	 
	

}
