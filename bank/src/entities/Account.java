package entities;

public class Account {
	private int number;
	private String name;
	private double balance;

	public Account(int number, String name, double initialDeposit) {
		this.number = number;
		this.name = name;
		deposit(initialDeposit);
	}

	public Account(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double value) {
		this.balance += value;
	}

	public void withdraw(double value) {
		this.balance -= value + 5.00;
	}

	public String toString() {
		return "Dados da conta - Número: " 
			+ number + " | Titular: " 
			+ name 
			+ " | Saldo: "
			+ String.format("%.2f", balance);
	}
}
