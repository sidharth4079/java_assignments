package BankInterest;

import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.format.DateTimeFormatter;  

public class FrontDesk {
	
	private static final String String = null;
	static List<SavingsAccount> listOfSavingsAccount;
	static List<LoanAccount>  listOfLoanAccount;
	static List<AadhaarCard> listOfAadhaarCard;
	static List<BankStatement> listOfBankStatement;
	static List<BankInterest> listOfSavingsAccountInterest;
	static List<BankInterest> listOfLoanAccountInterest;
	
	public static void main(String args[]) throws IOException
	{
		
	    SavingsAccount savingsAccount = new SavingsAccount();
	    LoanAccount loanAccount = new LoanAccount();
	    CurrentDateTime date = new CurrentDateTime();
	    BankInterest interest = new BankInterest();
	    FrontDesk frontDesk = new FrontDesk();
	    
	    listOfSavingsAccount = frontDesk.readToFileSavingsAccounts("/home/npci-admin/Desktop/SavingsAccounts.txt");
	    listOfLoanAccount = frontDesk.readToFileLoanAccounts("/home/npci-admin/Desktop/LoanAccounts.txt");
	    listOfBankStatement = frontDesk.readToFileBankStatement("/home/npci-admin/Desktop/BankStatements.txt");
	    listOfAadhaarCard = frontDesk.readToFileAadhaarCard("/home/npci-admin/Desktop/AadhaarCards.txt");
	    listOfSavingsAccountInterest = frontDesk.readToFileSavingsInterest("/home/npci-admin/Desktop/SavingsAccountInterest.txt");
	    listOfLoanAccountInterest = frontDesk.readToFileLoanInterest("/home/npci-admin/Desktop/LoanAccountInterest.txt");
	    
	    System.out.println(date.currentDateTime());
	    
	    boolean flag = true;
	    
	    while(flag) {
	    	
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("if close for the day enter y/n?");
	    	String close = sc.nextLine();
	    	
	    	if(close.equalsIgnoreCase("Y")) {
	    		flag = false;
	    		continue;
	    	}
	    	
	    	else {
        	
	    		System.out.println("Open Account???(y/n)");
	    		String choice = sc.nextLine(); 

	    		if(choice.equalsIgnoreCase("y")) {

	    			System.out.println("SAVINGS or LOAN Account");
	    			String accType = sc.nextLine();

	    			if(accType.equalsIgnoreCase("savings")) {
	    				
	    				long accountNumber = frontDesk.randomNumber();
	    				System.out.println("enter first name");
	    				String firstName = sc.nextLine();
	    				System.out.println("enter last name");
	    				String lastName = sc.nextLine();
	    				System.out.println("enter phone number");
	    				String phoneNumber = sc.nextLine();
	    				System.out.println("enter amount");
	    				double amount = sc.nextDouble();
	    				SavingsAccount s1 = new SavingsAccount(accountNumber, firstName, lastName, phoneNumber, amount, null);
	    				listOfSavingsAccount.add(s1);
	    				System.out.println("Saving account created successfully accountNumber = " + accountNumber);
	    			}

	    			else if(accType.equalsIgnoreCase("loan")){	
	    				
	    				long accountNumber = frontDesk.randomNumber();
	    				System.out.println("enter first name");
	    				String firstName = sc.nextLine();
	    				System.out.println("enter last name");
	    				String lastName = sc.nextLine();
	    				System.out.println("enter phone number");
	    				String phoneNumber = sc.nextLine();
	    				System.out.println("amount");
	    				double amount = sc.nextDouble();
	    				System.out.println("enter saving account number");
	    				long savingsAccountNumber = sc.nextLong();
	    				
	    				if(frontDesk.isValid(savingsAccountNumber, phoneNumber)) {
	    					LoanAccount s1 = new LoanAccount(accountNumber, firstName, lastName, phoneNumber, amount, savingsAccountNumber);
	    					listOfLoanAccount.add(s1);
	    					System.out.println("Loan account created successfully accountNumber = " + accountNumber);
	    				}
	    				
	    				else {
	    					System.out.println("invalid saving account detail");
	    				}
	    			}

	    			else
	    				System.out.println("INVALID ACCOUNT TYPE");
	    		}

		

	    		System.out.println("Enter your operations from the following: ");
	    		System.out.println("1. Link Aadhaar number");
	    		System.out.println("2. Print statement");
	    		System.out.println("3. Withdraw or Deposit Money into Savings Account");
	    		System.out.println("4. Borrow or Repay Loan");
	    		System.out.println("5. Repay loan from saving account");
	    		System.out.println("6. Borrow money or deposit it into savings account");
	    		System.out.println("7. display savings account interest of all customers");
	    		System.out.println("8. display Loan account interest of all customers");
	    		int operation = sc.nextInt();
	    		
	    		switch (operation) {
	    		
	    		case 1:
	    			System.out.println("Opted for Linking Aadhaar");
	    			sc.nextLine();
	    			System.out.println("enter aadhaar number");
	    			String aadhaarNumber = sc.nextLine();
	    			System.out.println("enter first name");
	    			String firstName = sc.nextLine();
	    			System.out.println("enter last name");
	    			String lastName = sc.nextLine();
	    			System.out.println("enter phone number");
	    			String phoneNumber = sc.nextLine();
	    			System.out.println("enter saving account number");
	    			long savingsAccountNumber = sc.nextLong();
	    			listOfAadhaarCard.add(new AadhaarCard(aadhaarNumber, firstName, lastName, phoneNumber));
	    			AccountAadhaarLink aadhaarLink = new AccountAadhaarLink();
	    			
	    			if(aadhaarLink.addAadhaar(aadhaarNumber, savingsAccountNumber, phoneNumber))
	    				System.out.println("aadhaar card linked successfuly");
	    			
	    			else System.out.println("addhaar card linking fail");
	    			
	    			break;
	    			
	    		case 2:
	    			System.out.println("enter account number");
	    			long accountNum = sc.nextLong();
	    			
	    			for(BankStatement statement : listOfBankStatement) {
	    				if(accountNum == statement.getAccountNumber())
	    					System.out.println(statement);
	    			}
		   
	    			break;
	    			
	    		case 3:
	    			System.out.println("Choose option from Withdraw or Deposit");
	    			sc.nextLine();
	    			String savingOperation = sc.nextLine();
	    			System.out.println("enter savings account number");
    				long accountNumber = sc.nextLong();
    				System.out.println("enter amount");
    				double balance = sc.nextDouble();
    				
	    			if (savingOperation.equalsIgnoreCase("Withdraw")) {
	    				
	    				if(savingsAccount.withdraw(accountNumber, balance)) {
	    					System.out.println("transaction successfull");
	    				}
	    				else System.out.println("transaction unsuccessful");
		    	
	    			}
	    			else if(savingOperation.equalsIgnoreCase("deposit")){
	    				
	    				if(savingsAccount.deposit(accountNumber, balance)) {
	    					System.out.println("transaction successfull");
	    				}
	    				else System.out.println("transaction unsuccessful");
	    			}	
		    	
	    			break;
	    			
	    		case 4:
	    			System.out.println("Borrow or Repay Loan");
	    			sc.nextLine();
	    			String loanOperation = sc.nextLine();
	    			System.out.println("enter Loan account number");
	    			long loanAccountNumber = sc.nextLong();
	    			System.out.println("enter amount");
    				double amount1 = sc.nextDouble();
    				
	    			if (loanOperation.equalsIgnoreCase("Borrow")) {
	    				
	    				if(loanAccount.borrow(loanAccountNumber, amount1)) {
	    					System.out.println("transaction successfull");
	    				}
	    				
	    				else System.out.println("transaction unsuccessful");
	    				
	    			}
	    			
	    			else if(loanOperation.equalsIgnoreCase("repay")){
	    				
	    				if(loanAccount.repay(loanAccountNumber, amount1)){
	    					System.out.println("transaction successfull");
	    				}
	    				
	    				else System.out.println("transaction unsuccessful");
	    				
	    			}
	    			break;
	    			
	    		case 5: 
	    			System.out.println("enter loan account number");
	    			long loanAccountNumber2 = sc.nextLong();
	    			System.out.println("enter amount");
	    			double amount2 = sc.nextDouble();
	    			
	    			for(LoanAccount account : listOfLoanAccount) {
	    				
	    				if(account.getAccountNumber() == loanAccountNumber2) {
	    					
	    					if(savingsAccount.withdraw(account.getSavingsAccountNumber(), amount2)) {
	    						
	    						if(loanAccount.repay(loanAccountNumber2, amount2)) {
	    							
	    							System.out.println("transaction successfull");
	    						}
	    						
	    						else System.out.println("transaction unsuccessful");
	    						break;
	    					}
	    				}
	    			}
	    			
	    		    break;
	    		case 6:
	    			
	    			System.out.println("enter loan account number");
	    			long loanAccountNumber3 = sc.nextLong();
	    			System.out.println("enter amount");
	    			double amount3 = sc.nextDouble();
	    			
	    			for(LoanAccount account : listOfLoanAccount) {
	    				
	    				if(account.getAccountNumber() == loanAccountNumber3) {
	    					
	    					if(loanAccount.borrow(loanAccountNumber3, amount3)) {
	    						
	    						if(savingsAccount.deposit(account.getSavingsAccountNumber(), amount3)) {
	    							
	    							System.out.println("transaction successfull");
	    						}
	    						
	    						else System.out.println("transaction unsuccessful");
	    						break;
	    					}
	    				}
	    			}
	    			break;
	    			
	    		case 7 :
	    			 for(SavingsAccount account : listOfSavingsAccount) {
	    				 
	    				 System.out.println("accountNumber = " + account.getAccountNumber() + ", Interest = " + 
	    			                       interest.calculateSavingsAccountInterest(account.getAccountNumber()));
	    			 }
	    			 break;
	    			 
	    		case 8: 
	    			  for(LoanAccount account : listOfLoanAccount) {
	    				  
	    				 System.out.println("accountNumber = " + account.getAccountNumber() + ", Interest = " + 
	    			                       interest.calculateLoanAccountInterest(account.getAccountNumber()));
	    			 }
	    			  break;
	    			  
	    		default :
	    			break;
	    		}
	    		
	    	}
	    	
	    } 
		
		
		frontDesk.writeToFileSavingsAccount();
        frontDesk.writeToFileLoanAccount();
        frontDesk.writeToFileBankStatement();
        frontDesk.writeToFileAadhaarCard();
        frontDesk.writeToFileSavingsInterest();
        frontDesk.writeToFileLoanInterest();
        System.out.println("Bank close");		
	}
	
	public boolean isValid(long savingsAccountNumber, String phoneNumber) {
		
		for(SavingsAccount account : listOfSavingsAccount) {
			
			if(account.getAccountNumber() == savingsAccountNumber && account.getPhoneNumber().equals(phoneNumber))
				return true;
		}
		return false;
	}
	
	public ArrayList<SavingsAccount> readToFileSavingsAccounts(String fileName) throws IOException {
		
		ArrayList<SavingsAccount> li = new ArrayList<SavingsAccount>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		
		while(line != null){
			String[] str = line.split(",");
			li.add(new SavingsAccount(Integer.valueOf(str[0]) , str[1], str[2], str[3], Double.parseDouble(str[4]), str[5]));
			
			line = b1.readLine();
		}
		return li;
	}
	
	public ArrayList<AadhaarCard> readToFileAadhaarCard(String fileName) throws IOException {
		
		ArrayList<AadhaarCard> li = new ArrayList<AadhaarCard>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		
		while(line != null){
			String[] str = line.split(",");
			li.add(new AadhaarCard(str[0] , str[1], str[2], str[3]));
			
			line = b1.readLine();
		}
		return li;
	}
	
	public ArrayList<BankStatement> readToFileBankStatement(String fileName) throws IOException {
		
		ArrayList<BankStatement> li = new ArrayList<BankStatement>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		
		while(line != null){
			String[] str = line.split(",");
			li.add(new BankStatement(Long.parseLong(str[0]), str[1],  Double.parseDouble(str[2]), str[3], Double.parseDouble(str[4])));
			
			line = b1.readLine();
		}
		return li;
	}
	
	public ArrayList<BankInterest> readToFileSavingsInterest(String fileName) throws IOException {
		
		ArrayList<BankInterest> li = new ArrayList<BankInterest>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		
		while(line != null){
			String[] str = line.split(",");
			li.add(new BankInterest(Long.parseLong(str[0]), Double.parseDouble(str[1]), str[2]));
			
			line = b1.readLine();
		}
		return li;
	}
	
	public ArrayList<BankInterest> readToFileLoanInterest(String fileName) throws IOException {
		
		ArrayList<BankInterest> li = new ArrayList<BankInterest>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		
		while(line != null){
			String[] str = line.split(",");
			li.add(new BankInterest(Long.parseLong(str[0]), Double.parseDouble(str[1]), str[2]));
			
			line = b1.readLine();
		}
		return li;
	}
	
	
	public void writeToFileAadhaarCard() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/AadhaarCards.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/AadhaarCards.txt",true));
		for(AadhaarCard aadhaar : listOfAadhaarCard) {
			f1.write("" + aadhaar.getAadhaarNumber() + "," + aadhaar.getFirstName() + "," + aadhaar.getLastName() + "," + aadhaar.getPhoneNumber() + "\n");
		}	
		
		f1.close();
	}
	
	public void writeToFileSavingsInterest() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/SavingsAccountInterest.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/SavingsAccountInterest.txt",true));
		for(BankInterest interest : listOfSavingsAccountInterest) {
			f1.write("" + interest.getAccountNumber() + "," + interest.getAvailableBalance() + "," + interest.getDate() + "\n");
		}	
		
		f1.close();
	}
	
	public void writeToFileLoanInterest() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/LoanAccountInterest.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/LoanAccountInterest.txt",true));
		for(BankInterest interest : listOfLoanAccountInterest) {
			f1.write("" + interest.getAccountNumber() + "," + interest.getAvailableBalance() + "," + interest.getDate() + "\n");
		}	
		
		f1.close();
	}

	public void writeToFileBankStatement() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/BankStatements.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/BankStatements.txt",true));
		for(BankStatement statement : listOfBankStatement) {
			f1.write("" + statement.getAccountNumber() + "," + statement.getOperation() + "," + statement.getAmount() + ","
		           + statement.getDate() + "," + statement.getAvailableBalance() + "\n");
		}	
		
		f1.close();
	}
	
	public void writeToFileSavingsAccount() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/SavingsAccounts.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/SavingsAccounts.txt",true));
		for(SavingsAccount account : listOfSavingsAccount) {
			f1.write("" + account.getAccountNumber() + "," + account.getFirstName() + "," + account.getLastName() + "," + account.getPhoneNumber() + ","
				       + account.getBalance() + "," + account.getAadhaarCardNumber() + "\n");
		}	
		
		f1.close();
	}
	
	public void writeToFileLoanAccount() throws IOException {
		
		BufferedWriter f2 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/LoanAccounts.txt"));
		f2.write("");
		f2.close();
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/LoanAccounts.txt",true));
		for(LoanAccount account : listOfLoanAccount) {
			f1.write("" + account.getAccountNumber() + "," + account.getFirstName() + "," + account.getLastName() + "," + account.getPhoneNumber() + ","
				       + account.getLoanAmount() + "," + account.getSavingsAccountNumber() + "\n");
		}	
		
		f1.close();
	}
	
	public ArrayList<LoanAccount> readToFileLoanAccounts(String fileName) throws IOException {
		
		ArrayList<LoanAccount> li = new ArrayList<LoanAccount>();
		FileReader f1 = new FileReader(fileName);
		BufferedReader b1 = new BufferedReader(f1);
		
		String line = b1.readLine();
		

		while(line != null){
			String[] str = line.split(",");
			li.add(new LoanAccount(Integer.valueOf(str[0]) , str[1], str[2], str[3], Double.parseDouble(str[4]), Long.parseLong(str[5])));
			
			line = b1.readLine();
		}
		return li;
	}
	
	public long randomNumber() {
		
		boolean flag = true;
		
		while(true) {
			
			flag = false;
			Random rand = new Random();
			long number = rand.nextInt(1000000000) + 1000000000;
			
			for(SavingsAccount account : listOfSavingsAccount) {
				
				if(account.getAccountNumber() == number) {
				flag = true;
				}
			}
			
			for(LoanAccount account : listOfLoanAccount) {
				
				if(account.getAccountNumber() == number) {
				flag = true;
				}
			}
			
			if(flag == false)
				return number;
		}
		
	}

}