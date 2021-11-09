package model;

public class AmountModel 
{
	String name;
	String fdate;
	String tdate;
	Integer amount;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AmountModel [name=" + name + ", fdate=" + fdate + ", tdate=" + tdate + ", amount=" + amount + "]";
	}
	
}
