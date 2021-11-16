package com.elitehotel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="customers")
public class User
{	
	@Id
	@Size(min=3,message="Firstname min 3 characters required")
	String fName;
	@Size(min=3,message="Lastname min 3 characters required")
	String lName;
	@Size(min=3,message="Username min 3 charactersrequired")
	String uName;
	@Min(value=18, message="must be equal or greater than 18")  
	String age;
	@Size(min=10,max=10,message="10 digits required")
	String phoneNo;
	@NotBlank(message = "set a password")
	String pWord;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", age=" + age + ", phoneNo="
				+ phoneNo + ", pWord=" + pWord + "]";
	}
	
	

}
