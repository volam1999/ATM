import java.util.ArrayList;

public class Bank implements BankSys {

	ArrayList<Account> accountLists;
	ArrayList<Card> cardLists;
	int index = 0;

	public Bank() {
		accountLists = new ArrayList<Account>();
		// Mặc định 2 tài khoản ứng với 2 thẻ trong hệ thống Ngân Hàng
		Account a = new Account("4051050166", "A", 999, "Huỳnh Tấn Phát", 21, "Quy Nhơn", "123");
		Account b = new Account("4051050180", "A", 50, "Trương Vô Kỵ", 21, "Quy Nhơn", "123");
		accountLists.add(a);
		accountLists.add(b);

		cardLists = new ArrayList<Card>();
		Card c1 = new Card("C405", "4051050166");
		Card c2 = new Card("C504", "4051050180");
		cardLists.add(c1);
		cardLists.add(c2);
	}

	@Override
	public double checkBalance(String AccountID) {
		// TODO Auto-generated method stub
		return getAccount(AccountID).getBalance();
	}

	@Override
	public boolean checkWithDraw(double Ammount, String AccountID) {
		// TODO Auto-generated method stub
		if (getAccount(AccountID).getBalance() > Ammount) {
			return true;
		}
		return false;
	}

	@Override
	public boolean withDraw(double Ammount, String AccountID) {
		// TODO Auto-generated method stub
		if (checkWithDraw(Ammount, AccountID)) {
			double balance = getAccount(AccountID).getBalance();
			getAccount(AccountID).setBalance(balance - Ammount);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkTransfers(double Ammount, String FromID, String ToID) {
		// TODO Auto-generated method stub
		if (checkWithDraw(Ammount, FromID)) {
			if (isAccount(ToID)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean checkPIN(String PIN, String ID) {
		// TODO Auto-generated method stub
		if (getAccount(ID).getPIN().equals((PIN)))
			return true;
		return false;
	}

	@Override
	public boolean transfers(double Ammount, String FromID, String ToID) {
		// TODO Auto-generated method stub
		if (checkTransfers(Ammount, FromID, ToID)) {
			double balance = getAccount(FromID).getBalance();
			getAccount(FromID).setBalance(balance - Ammount);
			getAccount(ToID).setBalance(getAccount(ToID).getBalance() + Ammount);
			return true;
		}
		return false;
	}

	@Override
	public boolean checkCard(String CardID) {
		// TODO Auto-generated method stub
		for (Card card : cardLists) {
			if (card.getCardID().equals(CardID)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public String getAccountID(String CardID) {
		// TODO Auto-generated method stub
		for (Card card : cardLists) {
			if (card.getCardID().equals(CardID)) {
				return card.getAccountID();
			}
		}
		return "-1";
	}

	// Lấy tài khoản ra để xử lý
	@Override
	public Account getAccount(String AccountID) {
		// TODO Auto-generated method stub
		for (Account account : accountLists) {
			if (account.getID().equals(AccountID)) {
				return account;
			}
		}
		return null;
	}
	
	
	// Kiểm tra tài khoản có tồn tại hay không để thực hiện giao dịch
	@Override
	public boolean isAccount(String AccountID) {
		// TODO Auto-generated method stub
		return getAccount(AccountID) == null ? false : true;
	}

}
