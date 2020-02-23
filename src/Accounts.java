public class Accounts {
    private double balance = 0;
    private double interest = 0.02;
    private int accountnumber;
    private static int numberofaccounts = 1000000;

    Accounts() {
        accountnumber = numberofaccounts++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterest() {
        return interest*100;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void withdraw (double amount) {
        if(amount + 0.5 > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= amount + 0.5;
        System.out.println("You withdrew R" + amount + "and got charged a fee R0.5");
        System.out.println("Your new balance is: R" + balance);
    }

    public void deposit (double amount) {
        if (amount <= 0 ) {
            System.out.println("You kinda need to deposit a positive amount :) ");
            return;
        }
        checkinterest();
        amount = amount + amount * interest;
        balance += amount;
        System.out.println("You deposited R" + amount + " with an interest rate of " + (interest*100) + "%");
        System.out.println("Your new balance is: R" + balance);

    }

    public void checkinterest() {
        if(balance > 10000) {
            interest = 0.05;
        } else {

        } interest = 0.02;

    }

}
