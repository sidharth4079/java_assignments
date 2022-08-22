package BankInterest;

public class BankStatement {
	
	private long accountNumber;
	private String operation;
	private double amount;
	private String date;
	private double availableBalance;
	
	public BankStatement(long accountNumber, String operation, double amount, String date, double availableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.operation = operation;
		this.amount = amount;
		this.date = date;
		this.availableBalance = availableBalance;
	}
    

	public double getAvailableBalance() {
		return availableBalance;
	}


	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}


	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return " operation = " + operation + ", amount = " + amount
				+ ", date = " + date ;
	}
	
	
}
