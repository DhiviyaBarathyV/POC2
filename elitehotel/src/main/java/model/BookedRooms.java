package model;

public class BookedRooms 
{
	String username;
	int roomno;
	String roomtype;
	String capacity;
	String fdate;
	String tdate;
	String Phoneno;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
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
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "BookedRooms [username=" + username + ", roomno=" + roomno + ", roomtype=" + roomtype + ", capacity="
				+ capacity + ", fdate=" + fdate + ", tdate=" + tdate + ", Phoneno=" + Phoneno + "]";
	}
	
	
	
}
