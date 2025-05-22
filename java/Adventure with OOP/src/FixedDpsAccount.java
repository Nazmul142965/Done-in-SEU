public class FixedDpsAccount extends BankAccount {
    double calculateDpsInterestRate(double balance, double interestRate, int time) {
        return (balance*(1 + interestRate / 100 ) - balance );
    }
}
