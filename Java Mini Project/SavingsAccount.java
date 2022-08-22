package BankInterest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount extends Account {

	private double balance;
	static float interestRate = 4;
	static int compoundingFrequency = 4;
	private String aadhaarCardNumber;
	public SavingsAccount() {
	}


	public SavingsAccount(long accountNumber, String firstName, String lastName, String phoneNumber, double balance , String aadhaarCardNumber) throws IOException {
		
		super(accountNumber, firstName, lastName, phoneNumber);
		this.balance = balance;
		this.aadhaarCardNumber = aadhaarCardNumber;
	}
	
	public boolean withdraw(long accountNumber, double amount) {
		
		for(SavingsAccount account : FrontDesk.listOfSavingsAccount) {
			
			if(accountNumber == account.getAccountNumber() && account.getBalance() > amount ) {
				
				account.balance = account.getBalance() - amount;
				
				CurrentDateTime dateTime = new CurrentDateTime();
				String[] date1 = dateTime.currentDateTime().split(" ");
				BankStatement statement = new BankStatement(accountNumber, "witdraw", -amount, date1[0], account.balance);
				FrontDesk.listOfBankStatement.add(statement);
				boolean flag = true;
				
				for(BankInterest interest : FrontDesk.listOfSavingsAccountInterest) {
					
					if(interest.getAccountNumber() == accountNumber) {
						
						if(interest.getDate().equals(date1[0]) && account.balance < interest.getAvailableBalance()) {
							
							interest.setAvailableBalance(account.balance);
							flag = false;
							return true;
						}
					}
				}
				
			    if(true) {
			    	FrontDesk.listOfSavingsAccountInterest.add(new BankInterest(accountNumber, account.balance, date1[0]));
			    }
				
				return true;
			}
		}
		return false;
	}
	
	public boolean deposit(long accountNumber, double amount) {
	
		for(SavingsAccount account : FrontDesk.listOfSavingsAccount) {
			
			if(accountNumber == account.getAccountNumber() && amount > 0 ) {
				
				account.balance = account.getBalance() + amount;
				CurrentDateTime dateTime = new CurrentDateTime();
				String[] date = dateTime.currentDateTime().split(" ");
				BankStatement statement = new BankStatement(accountNumber, "deposit", amount, date[0], account.balance);
				FrontDesk.listOfBankStatement.add(statement);
				boolean flag = true;
				
				for(BankInterest interest : FrontDesk.listOfSavingsAccountInterest) {
					
					if(interest.getAccountNumber() == accountNumber) {
						
						if(interest.getDate().equals(date[0]) && account.balance < interest.getAvailableBalance()) {
							
							interest.setAvailableBalance(account.balance);
							flag = false;
							return true;
						}
					}
				}
				
			    if(true) {
			    	FrontDesk.listOfSavingsAccountInterest.add(new BankInterest(accountNumber, account.balance, date[0]));
			    }
				return true;
				
			}
		}
		return false;
	}
	
	
	public String getAadhaarCardNumber() {
		return aadhaarCardNumber;
	}


	public void setAadhaarCardNumber(String aadharCardNumber) {
		this.aadhaarCardNumber = aadharCardNumber;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getCompoundingFrequency() {
		return compoundingFrequency;
	}

	public void setCompoundingFrequency(int compoundingFrequency) {
		this.compoundingFrequency = compoundingFrequency;
	}


	@Override
	public String toString() {
		return super.toString() + " balance=" + balance + ", interestRate=" + interestRate + ", compoundingFrequency="
				+ compoundingFrequency + "]";
	}
	
	
	
}
