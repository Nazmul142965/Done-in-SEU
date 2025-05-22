public class BankAccount {
    int accountNumber;
    double balance;
    double interestRate;

    void deposit(double amount) {
        balance = balance + amount;
    }

    void withdraw(double amount){
        balance = balance -amount;
    }

    double getBalance() {
        return balance;
    }
}
