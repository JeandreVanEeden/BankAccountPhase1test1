public class Cheque extends Account {
    String accounttype = "Cheque";
    Cheque (double startdeposit) {
            super();
            this.setBalance(startdeposit);
            this.checkinterest();
        }
        @Override
        public String toString() {

            return ("Account type: " + accounttype + " Account\n" +
                    "Account number: " + this.getAccountnumber() + "\n" +
                    "Balance: " + this.getBalance() + "\n" +
                     "Interest rate: " + this.getInterest() + "\n");
        }

    }

