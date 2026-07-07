package com.coforge.assignment;

public class BankAccount {
	private int accountNumber;
	private int balance;
	
	BankAccount(int accountNumber, int balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void deposit(int d) {
		System.out.println("Depositing : "+d);
		
		if(d > 0)
		balance += d;
		else System.out.println("Invalid");
	}
	
	public void withdraw(int d) {
		System.out.println("Withdrawing : "+d);
		if(balance > 0 && d < balance)
		balance -= d;
		else System.out.println("Not sufficient");
	}
	
	public void checkBalance() {
		System.out.println("Balance : "+balance);
	}
	
	public static void main(String[] args) {
		BankAccount acc = new BankAccount(101, 2000);
		
		acc.deposit(1000);
		acc.checkBalance();
		acc.withdraw(500);
		acc.checkBalance();
		
	}
	
}
