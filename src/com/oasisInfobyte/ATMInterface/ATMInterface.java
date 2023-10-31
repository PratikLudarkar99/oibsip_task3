package com.oasisInfobyte.ATMInterface;

import java.util.Scanner;

public class ATMInterface {

	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		while (!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				if (flag && input > limit || input < 1) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			} catch (Exception e) {
				System.out.println("Enter only Integer Value");
				flag = false;
			}
		}
		return input;
	}

	public static void main(String[] args) {
		System.out.println("\n===============!! Welcome to ATM !!=============\n");
		System.out.println("1.Register");
		System.out.println("2.Exit");
		System.out.println("Enter your choice :- ");
		int choice = takeIntegerInput(2);

		if (choice == 1) {
			BankAccount b = new BankAccount();
			b.register();
			while (true) {
				System.out.println("\n1.Login \n2.Exit ");
				System.out.println("Enter Your Choice :- ");
				int ch = takeIntegerInput(2);
				if (ch == 1) {
					if (b.login()) {
						System.out.println("===== Welcome Back ======= " + b.name + " ======");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("1. Deposit");
							System.out.println("2. Withdrow");
							System.out.println("3. Transfer");
							System.out.println("4. Check Balance");
							System.out.println("5. Transfer History");
							System.out.println("6. Exit");
							System.out.println("Enter your Choice :- ");
							int i = takeIntegerInput(6);
							switch (i) {
							case 1:
								b.deposit();
								break;
							case 2:
								b.withdrow();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transactionHistory();
								break;
//							case 6:
//								isFinished = true;
//								break;
							case 6:
								b.exit();
								isFinished =true;
								break;
								
							}
						}
					} else {
						System.exit(0);
					}
				}
			}
		} else {
			System.exit(0);
		}
	}
}
