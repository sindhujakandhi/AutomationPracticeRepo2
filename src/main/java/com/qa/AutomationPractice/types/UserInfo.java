package com.qa.AutomationPractice.types;

public class UserInfo {
	public UserInfo(String title, String firstName, String lastName, String password, int[] dob, String aFirstName,
			String aLastName, String company, Address addr, String additionalInfo, String homeph, String mphn, Address addr2) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dob = dob;
		this.aFirstName = aFirstName;
		this.aLastName = aLastName;
		this.company = company;
		this.addr = addr;
		this.additionalInfo = additionalInfo;
		this.homeph = homeph;
		this.mphn = mphn;
	}


	public String title;
	public String firstName;
	public String lastName;
	public String password;
	public int[] dob;
	public String aFirstName;
	public String aLastName;
	public String company;
	public Address addr;
	public String additionalInfo;
	public String homeph;
	public String mphn;
	 
	

}
