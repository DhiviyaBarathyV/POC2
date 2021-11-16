package com.elitehotel.model;

public class Bill 
{
	String name;
	String fdate;
	String tdate;
	Integer noOfDays;
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}
	
	public String getTdate() {
		return tdate;
	}
	public void setTdate(String tdate) {
		this.tdate = tdate;
	}
	@Override
	public String toString() {
		return "Bill [name=" + name + ", fdate=" + fdate + ", tdate=" + tdate + ", noOfDays=" + noOfDays + ", amount="
				+ amount + "]";
	}
	
	

}
