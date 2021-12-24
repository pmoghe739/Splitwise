package main.java.com.splitwiseV2.pojo;

import main.java.com.splitwiseV2.dao.Savable;

public class Balance implements Savable {
	
	private int id;
	private int senderId;
	private int receiverId;
	private double amount;
	public String userRepresentation;
	
	public String getUserRepresentation() {
		return userRepresentation;
	}

	public void setUserRepresentation(String userRepresentation) {
		this.userRepresentation = userRepresentation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public Balance(int senderId, int receiverid, double amount) {
		if(amount <= 0.0) {
			throw new IllegalArgumentException("Amount should be greater than 0");
		}
		this.senderId = senderId;
		this.receiverId = receiverid;
		this.amount = amount;
	}
}
