package BankInterest;

public class AccountAadhaarLink {
	
	public boolean addAadhaar(String aadhaarNumber, long savingsAccountNumber, String phoneNumber) {
		
		for(SavingsAccount account : FrontDesk.listOfSavingsAccount) {
			
			
			if(account.getAccountNumber() == savingsAccountNumber && account.getPhoneNumber().equals(phoneNumber)) {
				
				account.setAadhaarCardNumber(aadhaarNumber);
				
				return true;
			}
		}
		return false;
	}
}
