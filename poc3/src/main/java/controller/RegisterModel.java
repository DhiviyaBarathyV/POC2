package controller;

public class RegisterModel {
	String fName;
	String lName;
	String uName;
	String dob;
	String phoneNo;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
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
		return "RegisterModel [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", dob=" + dob + ", phoneNo="
				+ phoneNo + ", pWord=" + pWord + "]";
	}
	
}
