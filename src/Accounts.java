abstract class Account {
    private double balance = 0;
    private Boolean accountType;
    private double interest = 0.02;
    private int accountnumber;
    private static int numberofaccounts = 1;
    Account() {
        accountnumber = numberofaccounts++;
    }
    double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    double getInterest() {
        return interest*100;
    }
    int getAccountnumber() {
        return accountnumber;
    }
        public void withdraw(double amount) {
        if(amount + 0.5 > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
         balance -= amount + 0.5;
        System.out.println("You withdrew R" + amount + "and got charged a fee R0.5");
        System.out.println("Your new balance is: R" + balance);
    }
     public void deposit(double amount) {
        if (amount <= 0 ) {
            System.out.println("You kinda need to deposit a positive amount :) ");
            return;
        }
        //Deposits the amount input from keyboard.nextint()
        balance += amount;
        System.out.println("You deposited R" + amount );
        System.out.println("Your new balance is: R" + balance);
    }
     public double checkinterest() {
        if(balance > 10000) {
            interest = 0.07;
        } else {
            interest = 0.05;
        } return interest;
    }
}
