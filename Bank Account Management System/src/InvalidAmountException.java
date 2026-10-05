// Ném ra khi số tiền nạp/rút <= 0
public class InvalidAmountException extends Exception{
	public InvalidAmountException(String message) {
		super(message);
	}
}
