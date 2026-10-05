
public abstract class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;
	
	public BankAccount(String accountNumber, String holderName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) throws InvalidAmountException {
		// Pre-condition
		if(amount <= 0) {
			throw new InvalidAmountException("So tien nap vao phai lon hon 0");
		}
		// Post-condition
		this.balance += amount;
	}

	public abstract void withdraw(double amount) 
			throws InsufficientBalanceException, InvalidAmountException;
}
