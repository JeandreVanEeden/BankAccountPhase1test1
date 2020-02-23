public class Savings extends Accounts {
    private static String accounttype = "Savings";

    Savings(double startdeposit) {
        super();
        this.setBalance(startdeposit);
        this.checkinterest();

    }

    @Override
    public String toString() {
        return "Account type:" + accounttype + " Account\n" +
                "Account number: " + this.getAccountnumber() + "\n" +
                "Balance: " + this.getBalance() + "\n" +
                "Interest rate: " + this.getInterest() + "%\n";

    }
}

