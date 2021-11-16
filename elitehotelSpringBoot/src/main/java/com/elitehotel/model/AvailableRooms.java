package com.elitehotel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AvailableRooms")
public class AvailableRooms 
{
	@Id
	int roomNo;
	String type;
	String capacity;
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	@Override
	public String toString() {
		return "AvailableRooms [roomNo=" + roomNo + ", type=" + type + ", capacity=" + capacity + "]";
	}
}
