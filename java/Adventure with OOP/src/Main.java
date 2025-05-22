public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(550);
        System.out.println("Your Balance is: " + bankAccount.getBalance());
        bankAccount.withdraw(50);
        System.out.println("Your current Balance is: " + bankAccount.getBalance());

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.deposit(500);
        System.out.println("Your Saving Balance Interest rate is: " + savingAccount.calculateSavingInterest(500, 9 ));

        DpsAccount dpsAccount = new DpsAccount();
        System.out.println("Your DPS balance interest rate is: " + dpsAccount.calculateDpsInterestRate(500, 9, 3));

        FixedDpsAccount fixedDpsAccount =  new FixedDpsAccount();
        System.out.println("Your Fixed Balance Interest rate is : " + fixedDpsAccount.calculateDpsInterestRate(500, 9, 3));

    }
}