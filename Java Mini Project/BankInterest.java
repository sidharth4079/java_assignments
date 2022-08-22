package BankInterest;

public class BankInterest {
	
	private long accountNumber;
	private double availableBalance;
	private String date;
	
	public BankInterest() {
		
	}
	public BankInterest(long accountNumber, double availableBalance, String date) {
		super();
		this.accountNumber = accountNumber;
		this.availableBalance = availableBalance;
		this.date = date;
	}
	
	public double calculateSavingsAccountInterest(long accountNumber) {
		
		CurrentDateTime dateTime = new CurrentDateTime();
		String[] date1 = dateTime.currentDateTime().split(" ");
		float interestRate = SavingsAccount.interestRate;
		int compoundFrequency = SavingsAccount.compoundingFrequency;
		DifferenceOfDate dOD = new DifferenceOfDate();
		boolean flag = false;
		String date2 = "";
		String date3 = "";
		double balance1 = 0;
		
		for(BankInterest  statement : FrontDesk.listOfSavingsAccountInterest) {
			
			if(statement.getAccountNumber() ==  accountNumber && 
		      dOD.getDiff(statement.getDate(), date1[0]) >= compoundFrequency * 30) {
				flag = true;
				date2 = statement.getDate();
				balance1 = statement.getAvailableBalance();
				break;
			}
		}
		
		double interestSum = 0;
		
		if(flag) {
			for(int i = 0; i < FrontDesk.listOfSavingsAccountInterest.size();i++) {
				
				if(FrontDesk.listOfSavingsAccountInterest.get(i).getAccountNumber() ==  accountNumber ) {
					
					date3 = FrontDesk.listOfSavingsAccountInterest.get(i).getDate(); 
					int difference = dOD.getDiff(date2, date3);
					interestSum += (balance1 * difference * interestRate)/(365 * 100);
					balance1 = FrontDesk.listOfSavingsAccountInterest.get(i).getAvailableBalance(); 
					date2 = date3;
					FrontDesk.listOfSavingsAccountInterest.remove(i); 
					
				}
			}
			
			int difference = dOD.getDiff(date2, date3);
			interestSum += (balance1 * difference * interestRate)/(365 * 100);
			return interestSum;
		}
		return 0;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double getAvailableBalance() {
		return availableBalance;
	}
	
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public double calculateLoanAccountInterest(long accountNumber) {
		CurrentDateTime dateTime = new CurrentDateTime();
		String[] date1 = dateTime.currentDateTime().split(" ");
		float interestRate = LoanAccount.interestRate;
		int compoundFrequency = LoanAccount.compoundingFrequency;
		DifferenceOfDate dOD = new DifferenceOfDate();
		boolean flag = false;
		
		String date2 = "";
		String date3 = "";
		double balance1 = 0;
		
		for(BankInterest  statement : FrontDesk.listOfLoanAccountInterest) {
			
			if(statement.getAccountNumber() ==  accountNumber && 
		      dOD.getDiff(statement.getDate(), date1[0]) >= compoundFrequency * 30) {
				flag = true;
				date2 = statement.getDate();
				balance1 = statement.getAvailableBalance();
				break;
			}
		}
		
		double interestSum = 0;
		if(flag) {
			for(int i = 0; i < FrontDesk.listOfLoanAccountInterest.size();i++) {
				
				if(FrontDesk.listOfLoanAccountInterest.get(i).getAccountNumber() ==  accountNumber ) {
					
					date3 = FrontDesk.listOfLoanAccountInterest.get(i).getDate(); 
					int difference = dOD.getDiff(date2, date3);
					interestSum += (balance1 * difference * interestRate)/(365 * 100);
					date2 = date3;
					balance1 = FrontDesk.listOfLoanAccountInterest.get(i).getAvailableBalance(); 
					FrontDesk.listOfLoanAccountInterest.remove(i); 
					
				}
			}
			int difference = dOD.getDiff(date2, date3);
			interestSum += (balance1 * difference * interestRate)/(365 * 100);
			return interestSum;
		}
		return 0;
	}
	
	
}
