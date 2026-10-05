
public class SavingAccount extends BankAccount {
	private double interestRate;
	// Class Invariant 
	public static final double MIN_BALANCE = 50000.0;
	
	public SavingAccount(String accountNumber, String holderName, double balance, double interestRate) 
		throws InvalidAmountException, InsufficientBalanceException {
			super(accountNumber, holderName, balance);
			if(balance < MIN_BALANCE) {
				throw new InsufficientBalanceException("Số dư tối thiểu của tài khoản tiết kiệm phải từ " + MIN_BALANCE + " VNĐ!");
			}
			this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	// Ghi đè phương thức withdraw
	@Override 
	public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
		//Pre-condition
		if(amount <= 0) {
			throw new InvalidAmountException("Số tiền cần rút phải lớn hơn 0!");
		}
		if(getBalance() - amount < MIN_BALANCE) {
			throw new InsufficientBalanceException("Không thể rút! Số dư sau khi rút không được nhỏ hơn 50.000 VNĐ");
		}
		setBalance(getBalance() - amount); 
	}
	
}
