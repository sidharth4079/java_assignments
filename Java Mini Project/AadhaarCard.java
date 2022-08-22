package BankInterest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AadhaarCard {
	
	private String aadhaarNumber;
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public AadhaarCard() {
		
	}
	
	public AadhaarCard(String aadhaarNumber, String firstName, String lastName, String phoneNumber) throws IOException {
		super();
		if(isValid(firstName, lastName, phoneNumber)) {
			this.aadhaarNumber = aadhaarNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNumber = phoneNumber;
		}
		else try {
			throw new InValidAadhaarDetailException("please give valid aadhaar detail");
		}
		catch(InValidAadhaarDetailException exception) {
			exception.printStackTrace();
		}
	}
	
	public void writeToFile() throws IOException {
		
		BufferedWriter f1 = new BufferedWriter(new FileWriter("/home/npci-admin/Desktop/AadharCards.txt",true));
		f1.write("" + aadhaarNumber + "," + firstName + "," + lastName + "," + phoneNumber + "," + "\n");
		f1.close();
	}
	
	public boolean isValid(String firstName, String lastName, String phoneNumber) {
		if(phoneNumber.length() == 10  && firstName != null && lastName != null )
			return true;
		return false;
	}
	
	
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
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
		return "AadhaarCards [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
