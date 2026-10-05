
public class SavingAccount extends BankAccount {
	private double interestRate;
	// Class Invariant 
	public static final double MIN_BALANCE = 50000.0;
	
	public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) 
		throws InvalidAmountException, InsufficientBalanceException {
			super(accountNumber, holderName, balance);
			if(balance < MIN_BALANCE) {
				throw new InsufficientBalanceException("So du toi thieu cua tai khoan tiet kiem phai tu " + MIN_BALANCE + " VND!!!");
			}
			this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override 
	public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
		//Pre-condition
		if(amount <= 0) {
			throw new InvalidAmountException("So tien can rut phai lon hon 0!");
		}
		if(getBalance() - amount < MIN_BALANCE) {
			throw new InsufficientBalanceException("Khong the rut! So du sau khi rut khong duoc nho hon 50.000 VND!");
		}
		setBalance(getBalance() - amount); 
	}
	
}
