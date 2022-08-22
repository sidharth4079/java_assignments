package BankInterest;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Account {

	private long accountNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	
	public Account() {
		
	}

	public Account(long accountNumber, String firstName, String lastName, String phoneNumber) {
		if(isValid(firstName, lastName, phoneNumber)) {
			this.accountNumber = accountNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
		}
		else try {
			throw new InValidAccountDetailException("please enter valid account detail");
		}
		catch(InValidAccountDetailException exception) {
			exception.printStackTrace();
		}
	}
	
	public boolean isValid(String firstName, String lastName, String phoneNumber) {
		if(phoneNumber.matches("(0/91)?[7-9][0-9]{9}") && firstName != null && lastName != null )
			return true;
		return false;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}