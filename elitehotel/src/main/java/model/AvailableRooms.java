package model;

public class AvailableRooms 
{
	int roomno;
	String roomtype;
	int capacity;
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
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "AvailableRooms [roomno=" + roomno + ", roomtype=" + roomtype + ", capacity=" + capacity + "]";
	}
	
}
