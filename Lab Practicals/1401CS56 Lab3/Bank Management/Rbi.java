import java.util.ArrayList;

public class Rbi	
	{	
		
	static final double MIN_BALANCE=500;
	static final double MIN_INTEREST_RATE= 4;
	static final double WITHDRAWAL_LIMIT= 20000;

		ArrayList<Customer>customers= new ArrayList<Customer>();
		ArrayList<Account>accounts= new ArrayList<Account>();
		
		double minBalance;
		double interestRate;
		double withdrawalLimit;
		
		

		Rbi()
		{
			
		}
		
		void setMinBalance()
		{
			minBalance= MIN_BALANCE;
		}
		
		void setInterestRate()
		{
			interestRate = MIN_INTEREST_RATE;
		}
		
		void setWithdrawalLimit()
		{	
			withdrawalLimit = WITHDRAWAL_LIMIT;		
		}

		void setMinBalance(double a){}
		
		void setInterestRate(double b){}
		
		void setWithdrawalLimit(double c){}
		




	} 