package main.java.com.splitwiseV2.dao;

import java.util.List;

import main.java.com.splitwiseV2.pojo.Balance;
import main.java.com.splitwiseV2.pojo.UserExpensesMapper;

public class GenericDaoImpl {
	DBConnection dbConnection;

	public List<Balance> getBalancesForSender(int id){
		return (List<Balance>) dbConnection.fire("select * from balances where sender_id = "+id);
	}
	public List<Balance> getBalancesForReceiver(int id){
		return (List<Balance>) dbConnection.fire("select * from balances where receiver_id = "+id);
	}
	public List<UserExpensesMapper> getExpenses(int id){
		return (List<UserExpensesMapper>)dbConnection.fire("select * from user_expense_mapper where user_id = "+id);
	}
}
