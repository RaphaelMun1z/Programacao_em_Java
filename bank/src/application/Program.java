package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Informe o número da conta: ");
		int accountNumber = sc.nextInt();

		sc.nextLine();

		System.out.print("Informe o nome do titular: ");
		String accountHolder = sc.nextLine();

		System.out.print("Há um depósito inicial (s/n)? ");
		char thereIsInitialDeposit = sc.next().charAt(0);

		Account account;

		if (thereIsInitialDeposit == 's') {
			System.out.print("Informe o valor do depósito inicial: ");
			double initialDeposit = sc.nextDouble();

			account = new Account(accountNumber, accountHolder, initialDeposit);
		} else {
			account = new Account(accountNumber, accountHolder);
		}

		System.out.println();
		System.out.println(account);
		System.out.println();

		System.out.println("Quanto deseja depositar? ");
		double depositValue = sc.nextDouble();
		account.deposit(depositValue);

		System.out.println();
		System.out.println(account);
		System.out.println();

		System.out.println("Quanto deseja sacar? ");
		double withdrawValue = sc.nextDouble();
		account.withdraw(withdrawValue);

		System.out.println();
		System.out.println(account);
		System.out.println();

		sc.close();
	}
}
