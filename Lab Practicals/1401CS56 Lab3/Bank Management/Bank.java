import java.util.ArrayList;

public 	class Bank extends Rbi
	{
	static final double MIN_BALANCE=500;
	static final double MIN_INTEREST_RATE= 4;
	static final double WITHDRAWAL_LIMIT= 20000;
		Bank()
		{
				
		}
		
		void setMinBalance(double min )
		{
			if(min< MIN_BALANCE)
			this.minBalance= MIN_BALANCE;
			else this.minBalance= min;
		}
		
		void setInterestRate(double rate)
		{
			if(rate< MIN_INTEREST_RATE)
			this.interestRate= MIN_INTEREST_RATE;
			else this.interestRate= rate;
			
		}
		
		void setWithdrawalLimit(double limit)
		{
			if(limit > WITHDRAWAL_LIMIT)
			withdrawalLimit = WITHDRAWAL_LIMIT;	
			else withdrawalLimit=limit;
		}
				






	}

