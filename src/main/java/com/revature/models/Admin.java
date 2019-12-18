package com.revature.models;

public class Admin extends Employee{

	
	public boolean isAdministrator = true;

	public boolean isAdministrator() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdministrator = isAdmin;
	}
	
	public Admin(String username, String password, String first_name, String last_name) {
		this.setUserName(username);
		this.setPassword(password);
		this.setFirstName(first_name);
		this.setLastName(last_name);
	}

	@Override
	public String toString() {
		return "Admin [isAdministrator=" + isAdministrator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isAdministrator ? 1231 : 1237);/////////////what numbers are needed?
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			
			return true;
		
		if (obj == null)
			
			return false;
		
		if (getClass() != obj.getClass())
			
			return false;
		
		Admin other = (Admin) obj;
		
		if (isAdministrator != other.isAdministrator)
			return false;
		return true;
	}
	
	
}