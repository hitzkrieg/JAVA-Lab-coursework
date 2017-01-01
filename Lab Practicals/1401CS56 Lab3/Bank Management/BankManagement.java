import java.util.Scanner;
import java.util.ArrayList;

class BankManagement
{

	static final double MIN_BALANCE=500;
	static final double MIN_INTEREST_RATE= 4;
	static final double WITHDRAWAL_LIMIT= 20000;

public static void main(String[] args)
	{	
		String name;
		String customerId;
		Scanner stdIn= new Scanner(System.in);
		System.out.println("Making a variable sbi of Class Rbi and storing object of type Bank(which extends Rbi)"); 
		Rbi sbi = new Bank();

		System.out.println("Now invoking setMinBalance(), setInterestRate(), setWithdrawalLimit()");
		/* Implementing Polymorphism */

		sbi.setMinBalance(1000);
		sbi.setInterestRate(6);
		sbi.setWithdrawalLimit(18000);
		
		System.out.println("\nFinding out which methods were called:\n");
		System.out.println("Interest rate= " + sbi.interestRate);
		System.out.println("Minimum Balance= " + sbi.minBalance);
		System.out.println("Withdrawal Limit= " + sbi.withdrawalLimit);
		
		System.out.println("Creating a Customer. Please fill details:");
		
		System.out.println("Enter name: ");
		name= stdIn.nextLine();
		System.out.println("Customer id: ");
		customerId= stdIn.nextLine();
		
		Customer c= new Customer(name, customerId);
		System.out.println("\n Adding customer and Account to the Bank object:");
		sbi.accounts.add(new Account("A13445", sbi.minBalance, sbi.interestRate, sbi.withdrawalLimit));
		sbi.customers.add(c);
		
		System.out.println("\nCurrent account details:");
		sbi.accounts.get(0).printDetails();

		System.out.println("\nDepositing cash of Rs. 1000");
		sbi.accounts.get(0).depositCash(1000);

		System.out.println("\nWithdrawing cash of Rs. 1500");
		sbi.accounts.get(0).withdrawCash(1500);

		System.out.println("\nWithdrawing cash of Rs. 500");
		sbi.accounts.get(0).withdrawCash(500);

		

		
		
		
 
		
		
		



	}
}

