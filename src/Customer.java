public class Customer {


    private final String firstname;
    private final String lastname;
    private final String idnumber;
    private final Accounts account;



    public Customer(String firstname, String lastname, String idnumber, Accounts account ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idnumber = idnumber;
        this.account = account;
    }
    @Override
    public String toString() {
        return "\nCustomer Information\n" +
                "First Name:" + firstname + "\n" +
                "Last Name:" + lastname + "\n" +
                "ID number: " + idnumber + "\n" +
                account;
    }
    public String Information() {
        return  "\n" +
                "First Name:" + firstname  +"\n" +
                "Last Name:" + lastname  +"\n" +
                "ID number: " + idnumber + "\n" +
                "Account: " +account + "\n";
    }
    Accounts getAccount() {
        return account;
    }


}
