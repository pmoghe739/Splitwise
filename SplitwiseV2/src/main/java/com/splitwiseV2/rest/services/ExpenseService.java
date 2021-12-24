package main.java.com.splitwiseV2.rest.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.splitwiseV2.dao.GenericDaoImpl;
import main.java.com.splitwiseV2.pojo.Balance;
import main.java.com.splitwiseV2.pojo.Ledger;
import main.java.com.splitwiseV2.pojo.UserExpensesMapper;

public class ExpenseService {

	//TODO: rounding off to two decimal places
	public boolean addExpense(int senderId, double amount, List<Integer> receiverIds, String splitBy, List<Double> individualUserAmounts
			,List<Double> individualUserPercentages, String description){
		//Add Entry in Balance table
		// Add entry in ledger table
		// Add entry in Expense Table;
		
		//Calculate individual Balance share
		Map<Integer, Double> userwiseShares = new HashMap<>();
		if("EXACT".equalsIgnoreCase(splitBy)){
			for(int i = 0; i< receiverIds.size();i++) {
				userwiseShares.put(receiverIds.get(i), individualUserAmounts.get(i));
			}
		}
		else if("PERCENT".equalsIgnoreCase(splitBy)){
			for(int i = 0; i< receiverIds.size();i++) {
				userwiseShares.put(receiverIds.get(i), amount * individualUserPercentages.get(i) / 100);
			}
		} else {
			int totalParticipants = receiverIds.size() + 1; // Adding 1 for the sender as equal participant
			double individualShare = amount / totalParticipants;
			for(int i = 0; i< receiverIds.size();i++) {
				userwiseShares.put(receiverIds.get(i), individualShare);
			}
		}
		
		//Update Balance Table
		for(Integer receiverId: userwiseShares.keySet()) {
			Balance balance = new Balance(senderId, receiverId, userwiseShares.get(receiverId));
			balance.save();
		}
		
		//Update Ledger
		Ledger ledgerEntry = new Ledger(senderId, userwiseShares, amount, splitBy, description);
		ledgerEntry.save();
		
		// Update expense Mapper
		for(Integer receiverId: userwiseShares.keySet()) {
			UserExpensesMapper userExpenseMapper = new UserExpensesMapper(receiverId, ledgerEntry.getId(), userwiseShares.get(receiverId));
			userExpenseMapper.save();
		}
		return true;
	}
	public List<Balance> getBalances(int userId){
		//TODO: Handle the scenario where there is duplicate entry , i.e. A owes B and B owes A should not come as separate entries
		GenericDaoImpl dao = new GenericDaoImpl();
		List<Balance> senderRecords = dao.getBalancesForSender(userId);
		List<Balance> receiverRecords = dao.getBalancesForReceiver(userId);
		for(Balance row: senderRecords) {
			row.setUserRepresentation("User "+row.getSenderId() + " gets Back "+ row.getAmount() +" from user "+ row.getReceiverId());

		}
		for(Balance row: receiverRecords) {
			row.setUserRepresentation("User "+row.getSenderId() + " owes "+ row.getAmount() +" to user "+ row.getReceiverId());
		}
		senderRecords.addAll(receiverRecords);
		return senderRecords;
		
	}
	public List<UserExpensesMapper> getExpenses(int userId){
		GenericDaoImpl dao = new GenericDaoImpl();
		List<UserExpensesMapper> records = dao.getExpenses(userId);
		return records;
	}
	
	
	
}
