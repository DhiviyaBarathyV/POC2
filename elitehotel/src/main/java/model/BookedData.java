package model;

public class BookedData
{
	int roomno;
	String name;
	String roomtype;
	String fdate;
	String tdate;
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
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
	@Override
	public String toString() {
		return "BookedData [roomno=" + roomno + ", name=" + name + ", roomtype=" + roomtype + ", fdate=" + fdate
				+ ", tdate=" + tdate + "]";
	}
	
	
}
