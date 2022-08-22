package BankInterest;

import java.io.IOException;
import java.util.ArrayList;

public interface FrontDeskInterface {
	public boolean isValid(long savingsAccountNumber, String phoneNumber);
	
	public ArrayList<SavingsAccount> readToFileSavingsAccounts(String fileName) throws IOException ;
	
	public ArrayList<AadhaarCard> readToFileAadhaarCard(String fileName) throws IOException;
	
	public ArrayList<BankStatement> readToFileBankStatement(String fileName) throws IOException;
	
	public ArrayList<BankInterest> readToFileSavingsInterest(String fileName) throws IOException;
	
	public ArrayList<BankInterest> readToFileLoanInterest(String fileName) throws IOException;
	
	public void writeToFileAadhaarCard() throws IOException;
	
	public void writeToFileSavingsInterest() throws IOException;
	
	public void writeToFileLoanInterest() throws IOException;
	
	public void writeToFileBankStatement() throws IOException;
	
	public void writeToFileSavingsAccount() throws IOException;
	
	public void writeToFileLoanAccount() throws IOException;
	
	public ArrayList<LoanAccount> readToFileLoanAccounts(String fileName) throws IOException;
	
	public long randomNumber();
	
	
}
