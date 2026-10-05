
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
	
	/**
	 * Nạp tiền khỏi tài khoản ngân hàng.
	 * @param amount Số tiền cần nạp
	 * @throws InvalidAmountException Tiền điều kiện: amount <= 0
	 * @post-condition balance_new == balance_old + amount
	 * @invariant balance_new >= 0
	 */
	public void deposit(double amount) throws InvalidAmountException {
		// Pre-condition
		if(amount <= 0) {
			throw new InvalidAmountException("Số tiền nạp phải lớn hơn 0");
		}
		// Post-condition
		this.balance += amount;
	}

	/**
	 * Rút tiền vào tài khoản ngân hàng. 
	 * @param amount Số tiền cần rút
	 * @throws InvalidAmountException Tiền điều kiện: amount <= 0
	 * @throws InsufficientBalanceException Tiền điều kiện: balance < amount
	 * @post-condition balance_new == balance_old - amount
	 * @invariant balance_new >= 0
	 */
	public abstract void withdraw(double amount) 
			throws InsufficientBalanceException, InvalidAmountException;
}
