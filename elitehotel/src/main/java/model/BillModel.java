package model;

public class BillModel 
{
	String name;
	String fdate;
	String tdate;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "BillModel [name=" + name + ", fdate=" + fdate + ", tdate=" + tdate + "]";
	}
	

}
