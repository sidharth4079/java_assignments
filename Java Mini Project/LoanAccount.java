package BankInterest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LoanAccount extends Account{

    private double loanAmount;
	static float interestRate = 12;
	static int compoundingFrequency = 4;
    private long savingsAccountNumber;
	
	public LoanAccount() {
		super();
	}

	public LoanAccount(long accountNumber, String firstName, String lastName, String phoneNumber, double loanAmount, long savingsAccountNumber) throws IOException {
		super(accountNumber, firstName, lastName, phoneNumber);
		this.loanAmount = loanAmount;
		this.savingsAccountNumber = savingsAccountNumber;
	}
	
	public boolean repay(long accountNumber, double amount) {
		
		for(LoanAccount account : FrontDesk.listOfLoanAccount) {
			if(accountNumber == account.getAccountNumber() && account.getLoanAmount() > amount ) {
				account.loanAmount = account.getLoanAmount() - amount;
				
				CurrentDateTime dateTime = new CurrentDateTime();
				String[] date = dateTime.currentDateTime().split(" ");
				BankStatement statement = new BankStatement(accountNumber, "Repay", amount, date[0], account.loanAmount);
				FrontDesk.listOfBankStatement.add(statement);
				boolean flag = true;
				
				for(BankInterest interest : FrontDesk.listOfLoanAccountInterest) {
					
					if(interest.getAccountNumber() == accountNumber) {
						
						if(interest.getDate().equals(date[0]) && account.loanAmount > interest.getAvailableBalance()) {
							
							interest.setAvailableBalance(account.loanAmount);
							flag = false;
						}
					}
				}
				
			    if(true) {
			    	FrontDesk.listOfLoanAccountInterest.add(new BankInterest(accountNumber, account.loanAmount, date[0]));
			    }
			    
				return true;
			}
		}
		return false;
	}
	
	public boolean borrow(long accountNumber, double amount) {
		
		boolean successful = false;
		
		for(LoanAccount account : FrontDesk.listOfLoanAccount) {
			
			if(accountNumber == account.getAccountNumber() && account.loanAmount + amount <= 500000) {
				
				account.loanAmount = account.getLoanAmount() + amount;
				
				CurrentDateTime dateTime = new CurrentDateTime();
				String[] date = dateTime.currentDateTime().split(" ");
				BankStatement statement = new BankStatement(accountNumber, "Borrow", amount, date[0], account.loanAmount);
				FrontDesk.listOfBankStatement.add(statement);
				boolean flag = true;
				
				for(BankInterest interest : FrontDesk.listOfLoanAccountInterest) {
					
					if(interest.getAccountNumber() == accountNumber) {
						
						if(interest.getDate().equals(date[0]) && account.loanAmount > interest.getAvailableBalance()) {
							
							interest.setAvailableBalance(account.loanAmount);
							flag = false;
						}
					}
				}
				
			    if(true) {
			    	FrontDesk.listOfLoanAccountInterest.add(new BankInterest(accountNumber, account.loanAmount, date[0]));
			    }
			    
				return true;
			}
		}
		return false;
	}
	
	public long getSavingsAccountNumber() {
		return savingsAccountNumber;
	}

	public void setSavingsAccountNumber(long savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
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
		return super.toString() + "LoanAccount [loanAmount=" + loanAmount + ", interestRate=" + interestRate + ", compoundingFrequency="
				+ compoundingFrequency + "]";
	}
	
	
}
