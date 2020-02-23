import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runmenu();

    }

    public void runmenu () {
        printHeader();
        while(!exit){
            printMenu();
            int choice = getInput();
            performAction(choice);
            
            
        }
    }
    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for choosing Absa Bank");
                System.exit(choice);
                break;
            case 1:
                createanaccount();
                break;
            case 2:
                makeadeposit();
                break;
            case 3:
                makeawithrawal();
                break;
            case 4:
                listbalances();
                break;

            default:
                System.out.println("Unfortunately an unkown error occurred.");
    }
}

    private void listbalances() {
        int account = selectAccount();
        if (account >= 0) {
            }
        System.out.println(bank.getCustomer(account).getAccount());

    }

    private void makeawithrawal() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.print("Insert an amount you would like to Withdraw?: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().withdraw(amount);
        }

    }

    private void makeadeposit() {
        int account = selectAccount();
        if (account >= 0) {
            System.out.print("Insert an amount you would like to deposit?: ");
            double amount = 0;
            try {
                amount = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException e) {
                amount = 0;
            }
            bank.getCustomer(account).getAccount().deposit(amount);
        }
    }

    private int selectAccount() {
        ArrayList<Customer> customers = bank.getCustomers();
        if (customers.size() <=0) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Oops! Seems like you haven't created an account yet, please create an account to continue");
            System.out.println("-----------------------------------------------------------------------------------------");
            return -1;
        }
        System.out.println(" Please select an account: ");
        for (int i = 0; i <customers.size(); i++) {
            System.out.println((i+1) + ")" + customers.get(i).Information());
        }
        int account = 0;
        System.out.println("--------------------");
        System.out.println("Please select:");
        System.out.println("--------------------");
        try {
            account = Integer.parseInt(keyboard.nextLine()) - 1;
        }
        catch (NumberFormatException e) {
            account = -1;
        }

        if(account < 0 || account > customers.size()) {
            account = - 1;
        }
        return account;

    }

    private void createanaccount() {
        String firstname, lastname, idnumber, accounttype = "";
        double startdeposit = 0;
        boolean valid = false;
        while(!valid) {
            System.out.print("Please enter Cheque or Savings:  ");
            accounttype = keyboard.nextLine();
            if(accounttype.equalsIgnoreCase("Cheque") || accounttype.equalsIgnoreCase("savings")) {
                valid = true;

            }
            else {
                System.out.println("Please choose one of the two account types:  ");
            }
        }
        System.out.print("Please enter your name: ");
        firstname = keyboard.nextLine();
        System.out.print("Please enter your surname: ");
        lastname = keyboard.nextLine();
        System.out.print("Please enter your South african ID number: ");
        idnumber = keyboard.nextLine();
        valid = false;
        while(!valid) {
            System.out.print("Please enter a deposit amount to start your account off with:  ");
            try {
                startdeposit = Double.parseDouble(keyboard.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.print("Deposited must be a number");
            }
            if(accounttype.equalsIgnoreCase("Cheque")) {
                if(startdeposit < 100) {
                    System.out.print("Cheque accounts have a minimum deposit of R100");
                } else {
                    valid = true;
                }
            } else if(accounttype.equalsIgnoreCase("Savings")) {
                if(startdeposit < 50) {
                    System.out.print("Savings accounts have a minimum deposit of R50");
                } else {
                    valid = true;
                }
                System.out.println("***************************************************************************");
                System.out.println("Account Created with a starting balance of " + startdeposit + " Awesome!");
                System.out.println("***************************************************************************");
            }
        }

        Accounts account;
        if (accounttype.equalsIgnoreCase("cheque")) {
            account = new Cheque(startdeposit);
        } else {
            account = new Savings(startdeposit);
        }


        Customer customer = new Customer(firstname, lastname, idnumber, account);
        bank.addCustomer(customer);







        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Great News! You're one step closer to being a millionaire!");
        System.out.println("------------------------------------------------------------------------------");
    }

    private void printHeader() {
        System.out.println("+-----------------------------+");
        System.out.println("|     Welcome to Absa Bank    |");
        System.out.println("|                             |");
        System.out.println("+-----------------------------+");
    }
    private void printMenu() {
        System.out.println("Please make a selection");
        System.out.println("1) Create new account");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println("4) List current account balance");
        System.out.println("0) Exit");
    }
    private int getInput() {
        int choice = -1;
        do {
            System.out.print("Please enter your choice:    ");
        try {
            choice = Integer.parseInt(keyboard.nextLine());
        }
        catch(NumberFormatException e) {
            System.out.println("Numbers only please");
        }
        if (choice < 0 || choice > 4) {
            System.out.println("Invalid choice. Please choose again");
        }
    }while(choice < 0 || choice > 4);
        return choice;
    }
}

