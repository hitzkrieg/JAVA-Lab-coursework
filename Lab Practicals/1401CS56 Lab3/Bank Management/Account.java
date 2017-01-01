public class Account
	{
		String accNo;
		String customerId;
		double balance;
		double minBalance;
		double interestRate;
		double withdrawalLimit;
		

		Account(String accNo, double minBalance, double interestRate, double withdrawalLimit)
		{
			this.accNo= accNo;
			this.minBalance= minBalance;
			this.interestRate= interestRate;
			this.balance= minBalance;
			this.withdrawalLimit= withdrawalLimit;
		}

		void printDetails()
		{
			System.out.println("Account number: " + this.accNo);
			System.out.println("Balance: " + this.balance);
		}
		
		void depositCash(double amt)
		{
			this.balance= this.balance + amt;
			System.out.println("Transaction is complete.");
			printDetails();

		}
		void withdrawCash(double amt)
		{
			if(amt<= this.withdrawalLimit)
			{

				if(this.balance - this.minBalance >= amt)
				{
					this.balance= this.balance - amt;
					System.out.println("Transaction is complete.");
					printDetails();
				}
				else 
				System.out.println("Transaction incomplete. Balance will fall below "+ this.minBalance);
			}
			else System.out.println("Transaction incomplete. Amount greater than" + this.withdrawalLimit);
		}
	}			