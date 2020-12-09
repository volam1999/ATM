
public class Card {
	private String CardID;
	private String AccountID;
	
	public Card(String cardID, String accountID) {
		super();
		CardID = cardID;
		AccountID = accountID;
	}

	public String getCardID() {
		return CardID;
	}

	public void setCardID(String cardID) {
		CardID = cardID;
	}

	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}
	
}
