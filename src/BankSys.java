
public interface BankSys {
	public double checkBalance(String AccountID);

	public boolean checkWithDraw(double Ammount, String AccountID);

	public boolean withDraw(double Ammount, String AccountID);

	public boolean checkTransfers(double Ammount, String FromID, String ToID);

	public boolean transfers(double Ammount, String FromID, String ToID);

	public boolean checkPIN(String PIN, String ID);

	public boolean checkCard(String CardID);

	public String getAccountID(String CardID);

	public Account getAccount(String AccountID);

	public boolean isAccount(String AccountID);
}
