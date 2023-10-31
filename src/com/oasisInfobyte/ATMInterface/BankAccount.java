package com.oasisInfobyte.ATMInterface;

import java.util.Scanner;

public class BankAccount {
	String name;
	String username;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionsHistory = " ";

	private static int takeIntegerInput(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name :-");
		this.name = sc.nextLine();
		System.out.println("Enter Your User Name :- ");
		this.username = sc.nextLine();
		System.out.println("Enter Your Password :- ");
		this.password = sc.nextLine();
		System.out.println("Enter your Account Number :-");
		this.accountNo = sc.nextLine();
		System.out.println("Registration Completed.  \n Please log in !!");

	}

	public boolean login() {
		Scanner sc = new Scanner(System.in);
		boolean isLogin = false;

		while (!isLogin) {
			System.out.println("Enter Your User Name :- ");
			String username = sc.nextLine();
			if (username.equals(username)) {
				while (!isLogin) {
					System.out.println("Enter Your Password :-");
					String password = sc.nextLine();
					if (password.equals(password)) {
						System.out.println("Login Successful ");
						isLogin = true;
					} else {
						System.out.println("Incorrect Password ***");
					}
					System.out.println("");
				}

			} else {
				System.out.println("*** Username Not Fount ***");
			}
		}
		return isLogin;
	}

	public void deposit() {
		System.out.println("Enter Amount to Deposit :- ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (amount <= 10000f) {
				transactions++;
				balance += amount;
				System.out.println(amount + "Rs." + " Successfully Deposited \n");
				String str = amount + "Rs. Deposited \n";
				transactionsHistory = transactionsHistory.concat(str);
			} else {
				System.out.println("Sorry.... Limit is 10000.00 !! \n");
			}
		} catch (Exception e) {
			// handle exception
		}
	}

	public void withdrow() {
		System.out.println("Enter Amount to Withdrow ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if (balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println(amount + "Rs. Withdrow  Successfully \n");
				String str = amount + "Rs Withdreow\n";
				transactionsHistory = transactionsHistory.concat(str);
			} else {
				System.out.println("/n Insufficient Balance \n");
			}

		} catch (Exception e) {
			// handle exception
		}

	}

	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Receipent Name :- ");
		String Recipent = sc.nextLine();
		System.out.println("Enter Amount to Transfer :- ");
		float amount = sc.nextFloat();
		try {
			if (balance >= amount) {
				if (balance <= 50000f) {
					transactions++;
					balance -= amount;
					System.out.println("Successfully Trasnfered to " + Recipent + "\n");
					String str = amount + "Rs. Transfer to " + Recipent + "\n";
					transactionsHistory = transactionsHistory.concat(str);

				} else {
					System.out.println("Sorry .... Limit is 50000.00 ");
				}
			} else {
				System.out.println("Insufficient Balance  ");
			}
		} catch (Exception e) {
			// handle exception
		}
	}

	public void checkBalance() {
		System.out.println("\n Available balance is " + balance + " Rs. \n");
	}

	public void transactionHistory() {
		if (transactions == 0) {
			System.out.println("Empty ");
		} else {
			System.out.println("\n" + transactionsHistory);
		}
	}

	public void exit() {
		// TODO Auto-generated method stub
		System.out.println("Exite");
	}
}
