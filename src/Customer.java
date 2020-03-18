
public class Customer {
    private final String firstName;
    private final String lastName;
    private final int idNumber;
    private final Account account;
    Customer(String firstname, String lastname, int idnumber, Account account) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.idNumber = idnumber;
        this.account = account;
    }
    @Override
    public String toString() {
        return String.format("Customer Information\n" +
                "First Name:" + firstName + "\n" +
                "Last Name:" + lastName + "\n" +
                "ID number: " + idNumber + "\n" +
                account);
    }
    public String ListAccounts() {
        return "Name: " + firstName + " " + lastName + "\n" +
                account;

    }
    Account getAccount() {
        return account;
    }


}
