import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankManager {
	private Map<String, BankAccount> accounts;
	
	public BankManager () {
		this.accounts = new HashMap<>();
	}
	
	public void addAccount(BankAccount account) {
		if(account != null)
			accounts.put(account.getAccountNumber(), account);
	}
	
	public BankAccount findAccount(String accountNumber) {
		return accounts.get(accountNumber);
	}
	
	public void transferMoney(String fromAccNum, String toAccNum, double amount) 
		throws InvalidAmountException, InsufficientBalanceException {
			BankAccount fromAcc = findAccount(fromAccNum);
			BankAccount toAcc = findAccount(toAccNum);
			if(fromAcc == null)
				throw new IllegalArgumentException("Khong tim thay tai khoan nguon: " + fromAccNum);
			if(toAcc == null)
				throw new IllegalArgumentException("Khong tim thay tai khoan dich: " + toAccNum);
			
			fromAcc.withdraw(amount);
			try {
				toAcc.deposit(amount);
			} catch(InvalidAmountException e) {
				// Hoan tien lai neu nap that bai
				fromAcc.deposit(amount);
				throw e;
			}
	}
	
	public double calculateTotalBalance(List<? extends BankAccount> accounts) {
	    double total = 0.0;
	    for (BankAccount acc : accounts) {
	        total += acc.getBalance(); 
	    }
	    return total;
	}

	// Lay danh sach tat ca tai khoan
	public List<BankAccount> getAllAccounts() {
		return new ArrayList<>(accounts.values());
	}
}
