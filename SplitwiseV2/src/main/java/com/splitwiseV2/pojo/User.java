package main.java.com.splitwiseV2.pojo;

import main.java.com.splitwiseV2.dao.Savable;

public class User  implements Savable {
	
	private int id;
	private String name;
	private String email;
	private int phone;
	
	
	public User(String name, String email, int phone) {
		super();
		this.name = name;
		this.email = email; // TODO: Add validation here for email and phone
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}

}
