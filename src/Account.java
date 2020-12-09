
public class Account {
	private String ID;
	private String type;
	private double balance;
	private String name;
	private int age;
	private String address;
	private String PIN;
	
	public Account(String iD, String type, double balance, String name, int age, String address, String PIN) {
		super();
		ID = iD;
		this.type = type;
		this.balance = balance;
		this.name = name;
		this.age = age;
		this.address = address;
		this.PIN = PIN;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}
	
}
