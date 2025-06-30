import java.util.*;

class Transaction {
    String type;
    double amount;
    Date date;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }

    public String toString() {
        return date + " - " + type + ": ₹" + amount;
    }
}

class Account {
    private String accountHolder;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.println(" ₹" + amount + " deposited successfully.");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println(" ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println(" Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println(" No transactions yet.");
        } else {
            System.out.println(" Transaction History:");
            for (Transaction t : transactionHistory) {
                System.out.println(t);
            }
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter your name to create an account: ");
        String name = sc.nextLine();

        Account acc = new Account(name);

        int choice;
        do {
            System.out.println("\n=====  Bank Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print(" Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double wd = sc.nextDouble();
                    acc.withdraw(wd);
                    break;
                case 3:
                    System.out.println(" Current Balance: ₹" + acc.getBalance());
                    break;
                case 4:
                    acc.showTransactionHistory();
                    break;
                case 5:
                    System.out.println(" Thank you for using our bank!");
                    break;
                default:
                    System.out.println(" Invalid option. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}

