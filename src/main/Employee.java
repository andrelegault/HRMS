package main;

public class Employee extends User {
	private String role;
	
	public Employee(String first, String last, String role) {
		super(first, last);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
