package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Porgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int number = sc.nextInt();

			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();

			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();

			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();

			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));

		} catch (DomainException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.print("Enexpected error");
		} finally {
			sc.close();
		}

	}

}
