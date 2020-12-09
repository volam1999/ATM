
import java.util.Scanner;

public class ATM implements ATMSys, CardReader {
	Scanner s = new Scanner(System.in);
	static ATM atm = new ATM();
	static String cardID = "";
	static String accountID = "";
	static double withdraw;
	static Bank bank = new Bank();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		insertCard();
		menu();
	}

	private static void insertCard() {
		while (true) {
			// Mã thẻ và tài khoản mặc định lưu ở trong Bank
			System.out.println("Please Insert Card Here: ");
			cardID = atm.getCardID();
			if (bank.checkCard(cardID)) {
				int count = 0;
				while (true) {
					if (count == 3) {
						System.exit(0);
					}
					System.out.println("Please Input The PIN CODE: ");
					String code = atm.getPIN();
					accountID = atm.getAccountID(bank, cardID);
					if (bank.checkPIN(code, accountID)) {
						System.out.println("Welcome To TPBANK");
						break;
					} else {
						System.out.println("The CODE is INVALID, Try Again...");
						count++;
					}
				}
				break;

			} else {
				System.out.println("Card Is INVALID! Please Try Again...");
			}
		}
	}

	// Giao diện đơn giản cho cây ATM
	// Đã cài sẵn 2 tài khoản với mã thẻ: C405 và C504 vào lớp Bank để xem chi tiết
	private static void menu() {
		while (true) {
			Scanner s1 = new Scanner(System.in);
			System.out.println("Automated Teller Machine");
			System.out.println("Choose 1 for Withdraw");
			System.out.println("Choose 2 for Deposit");
			System.out.println("Choose 3 for Check Balance");
			System.out.println("Choose 4 for Take Card");
			System.out.println("Choose 5 for EXIT");
			System.out.print("Choose the operation you want to perform:");
			int n = Integer.parseInt(s1.nextLine());
			switch (n) {
			case 1:
				System.out.print("Enter money to be withdrawn:");
				withdraw = s1.nextDouble();
				if (bank.withDraw(withdraw, accountID)) {
					System.out.println("Please collect your money");
				} else {
					System.out.println("Insufficient Balance");
				}
				System.out.println("");
				break;

			case 2:
				System.out.print("Enter money to be deposited:");
				double ammount = Double.parseDouble(s1.nextLine());
				System.out.print("Enter The ID To Deposit:");
				String toID = s1.nextLine();
				if (bank.transfers(ammount, accountID, atm.getAccountID(bank, toID))) {
					System.out.println("Your Money has been successfully depsited");
					System.out.println("");
				} else {
					System.out.println("ERROR, Please Check...");
				}
				break;

			case 3:
				System.out.println("Balance : " + bank.checkBalance(atm.accountID));
				System.out.println("");
				break;

			case 4:
				insertCard();
				break;
			case 5:
				System.exit(0);
			}
		}
	}

	@Override
	public String getCardID() {
		return s.nextLine();
	}

	@Override
	public String getPIN() {
		// TODO Auto-generated method stub
		return s.nextLine();
	}

	@Override
	public String getAccountID(Bank bank, String CardID) {
		// TODO Auto-generated method stub
		return bank.getAccountID(CardID);
	}

}
