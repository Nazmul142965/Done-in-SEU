public class SavingAccount extends BankAccount{
    double calculateSavingInterest(double balanec, double interestRate) {
        return balance * (interestRate / 100);

    }

}
