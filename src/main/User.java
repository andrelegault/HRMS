package main;

public class User {
	private String first;
	private String last;
	private int id;
	
	public User(String first, String last) {
		this.setFirst(first);
		this.setLast(last);
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public void setLast(String last) {
		this.last = last;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public int getId() {
		return this.id;
	}
}
