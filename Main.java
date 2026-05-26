

import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully");
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        }
    }

    void display() {
        System.out.println("---------------------------");
        System.out.println("Account Number : " + accNo);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : " + balance);
        System.out.println("---------------------------");
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    displayAccount();
                    break;

                case 5:
                    displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, name, balance);

        accounts.add(acc);

        System.out.println("Account Created Successfully");
    }

    static Account findAccount(int accNo) {

        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                return acc;
            }
        }

        return null;
    }

    static void depositMoney() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        acc.deposit(amount);
    }

    static void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account Not Found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        acc.withdraw(amount);
    }

    static void displayAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account Not Found");
        } else {
            acc.display();
        }
    }

    static void displayAllAccounts() {

        if (accounts.size() == 0) {
            System.out.println("No Accounts Available");
            return;
        }

        for (Account acc : accounts) {
            acc.display();
        }
    }
}
