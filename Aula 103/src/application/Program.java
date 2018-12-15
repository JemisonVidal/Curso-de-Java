package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account = new Account(104,"Jemison", 0.0);
		BusinessAccount bacc = new BusinessAccount(105,"Yuri", 0.0, 500.0);		
		
		//Upcasting
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(106,"Jose",0.0,0.0);
		Account acc3 = new SavingsAccount(106,"João",0.0,0.02);
		
		
		//dowcasting
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(400.0);
		
		if (acc3 instanceof BusinessAccount) { 
			BusinessAccount acc5 = (BusinessAccount)acc3; acc5.loan(200.0); 
			System.out.println("Loan!"); 
		}
		if (acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3; 
			acc5.updateBalance(); 
			System.out.println("Update!"); 
		}

		

	}

}
