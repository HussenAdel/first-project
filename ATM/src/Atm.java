
public class Atm {
	private double Balance=0.0;
	private long DepositValue;
	private long withdrawalValue;
	final long CardNumber = 5;
	
	public void DepositMethod(long DepositValue)
	{this.Balance+=DepositValue;
	
	}
	public void withdrawalMethod(long withdrawalValue)
	{this.Balance-=withdrawalValue;
	
	}
	public void setBalance(double balance) {
		this.Balance=balance;
	}
	public Double getBalance()
	{
		return this.Balance;
	}

}
