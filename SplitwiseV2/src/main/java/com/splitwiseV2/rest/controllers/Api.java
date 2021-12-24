package main.java.com.splitwiseV2.rest.controllers;

import java.util.List;

import main.java.com.splitwiseV2.pojo.Balance;
import main.java.com.splitwiseV2.pojo.User;
import main.java.com.splitwiseV2.pojo.UserExpensesMapper;
import main.java.com.splitwiseV2.rest.services.ExpenseService;
import main.java.com.splitwiseV2.rest.services.UserService;

public class Api {
	
	public void createUser(String name, String email, int phone) {
		// Add validations
		UserService userService = new UserService();
		userService.addUser(new User(name, email, phone));
	}
	
	public void addExpense(int senderId, List<Integer> receiverIds, List<Double> individualUserAmounts, List<Double> individualUserPercentages ,double amount, String splitBy, String description) {
		// Do all the Input Validations here .
		if("EXACT".equalsIgnoreCase(splitBy)){
			double total = 0.0;
			for(double entry: individualUserAmounts) {
				total += entry;
			}
			if(total != amount || individualUserAmounts.size() != receiverIds.size()) {
				throw new IllegalArgumentException("Individual amounts do not add upto the Total");
			}
		}
		else if("PERCENT".equalsIgnoreCase(splitBy)){
			double total = 0.0;
			for(double entry: individualUserPercentages) {
				total += entry;
			}
			if(total != 100 || individualUserPercentages.size() != receiverIds.size()) {
				throw new IllegalArgumentException("Individual Percents do not add upto 100");
			}
		}
		if(amount<= 0.0) {
			throw new IllegalArgumentException("Amount Should be greater than 0.");
		}
		if(description.length() >256) {
			throw new IllegalArgumentException("Description cannot be greater than 256 characters.");
		}
		// Will add more validations later .
		ExpenseService expenseService = new ExpenseService();
		expenseService.addExpense(senderId, amount, receiverIds, splitBy, individualUserAmounts
				,individualUserPercentages, description);
		
		
	}

	public List<Balance> getBalances(int userId){
		// check userId is correct;
		ExpenseService expenseService = new ExpenseService();
		return expenseService.getBalances(userId);
	}
	
	public List<UserExpensesMapper> getExpenses(int userId){
		ExpenseService expenseService = new ExpenseService();
		return expenseService.getExpenses(userId);
	}
}
