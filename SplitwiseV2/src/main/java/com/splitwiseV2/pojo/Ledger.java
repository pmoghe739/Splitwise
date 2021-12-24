package main.java.com.splitwiseV2.pojo;

import java.util.List;
import java.util.Map;

import main.java.com.splitwiseV2.dao.Savable;

/*
 * This Object will also act as a Post where users can comment about the transaction.
 */
public class Ledger  implements Savable{
	private int Id;
	private int senderId;
	private Map<Integer, Double> receiverShares;
	private double totalAmount;
	private String splitBy; // TODO: Make it Enumeration instead;
	private String description;
	
	
	
	public int getId() {
		return Id;
	}



	public void setId(int id) {
		Id = id;
	}



	public int getSenderId() {
		return senderId;
	}



	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getSplitBy() {
		return splitBy;
	}



	public void setSplitBy(String splitBy) {
		this.splitBy = splitBy;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Map<Integer, Double> getReceiverShares() {
		return receiverShares;
	}



	public void setReceiverShares(Map<Integer, Double> receiverShares) {
		this.receiverShares = receiverShares;
	}



	public Ledger(int senderId, Map<Integer, Double> receiverShares, double totalAmount, String splitBy,
			String description) {
		super();
		this.senderId = senderId;
		this.receiverShares = receiverShares;
		this.totalAmount = totalAmount;
		this.splitBy = splitBy;
		this.description = description;
	}
	
	
	
}
