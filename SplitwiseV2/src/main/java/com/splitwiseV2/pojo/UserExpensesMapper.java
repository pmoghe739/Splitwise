package main.java.com.splitwiseV2.pojo;

import main.java.com.splitwiseV2.dao.Savable;

public class UserExpensesMapper  implements Savable{
	
	private int id;
	private int userId;
	private int ledgerId;
	private double userShare;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(int ledgerId) {
		this.ledgerId = ledgerId;
	}
	public double getUserShare() {
		return userShare;
	}
	public void setUserShare(double userShare) {
		this.userShare = userShare;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserExpensesMapper(int userId, int ledgerId, double userShare) {
		super();
		this.userId = userId;
		this.ledgerId = ledgerId;
		this.userShare = userShare;
	}

}
