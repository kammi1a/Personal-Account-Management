import java.util.ArrayList;

// 1. TransactionType Enum:
enum TransactionType {
    DEPOSIT,   // Represents a deposit transaction.
    WITHDRAWAL // Represents a withdrawal transaction.
}

// 2. Amount Class:
class Amount {
    double amount; // The transaction amount.
    TransactionType transactionType; // An enum value indicating the type of transaction (DEPOSIT or WITHDRAWAL).

    // Constructor
    Amount(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }
}

// 3. PersonalAccount Class
class PersonalAccount {
    int accountNumber; // A unique identifier for the account.
    String accountHolder; // The name of the account holder.
    double balance; // The current balance in the account.
    ArrayList<Amount> transactions; // A list to store deposit and withdrawal transactions.

// 4. Methods for PersonalAccount Class:
   //Constructor to initialize accountNumber, accountHolder, and set initial balance to 0.0.
    PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    // Method to deposit money into the account.
    void deposit(double amount) {
        if (amount > 0) {
            transactions.add(new Amount(amount, TransactionType.DEPOSIT));
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    // Method to withdraw money from the account.
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            transactions.add(new Amount(amount, TransactionType.WITHDRAWAL));
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to print the transaction history of the account.
    void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Amount transaction : transactions) {
            System.out.println(transaction.transactionType + ": $" + transaction.amount);
        }
    }

    // Method to retrieve the current balance of the account.
    double getBalance() {
        return balance;
    }

    // Method to retrieve the account number.
    int getAccountNumber() {
        return accountNumber;
    }

    // Method to retrieve the account holder's name.
    String getAccountHolder() {
        return accountHolder;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create an account
        PersonalAccount account = new PersonalAccount(13579, "Kamila Zhooshbaeva");
      
        account.deposit(5000); // Deposit money
        account.withdraw(2500);  // Withdraw money
        account.withdraw(3000);  // Attempt to withdraw more than available
        account.printTransactionHistory(); // Print transaction history

        System.out.println("Current balance: $" + account.getBalance());

        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolder());
    }
}


