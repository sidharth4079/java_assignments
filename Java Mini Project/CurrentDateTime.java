package BankInterest;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class CurrentDateTime {    
	
	public String currentDateTime() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String currentDate = dtf.format(now);
		
		return currentDate;
  }    
} 
