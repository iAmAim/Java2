package com.accounts;

import java.util.Comparator;

public class Account implements Comparable<Account> {

	private int id;
	private String name;
	private double balance;

	public Account(int id, String name, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {

		return "\nid: " + id + "\nname: " + name + "\nbalance: " + balance;

	}

	@Override
	public int compareTo(Account acc) {
		return this.getId() -  acc.getId();
	}
	
	public static class AccountComparator implements Comparator<Account>{

		@Override
		public int compare(Account acc1, Account acc2) {
			return acc1.id - acc2.id;
		}	
	}


}
