package lee.atm.mybankingapp.atm_code;

import java.util.Scanner;

public class ATMProgramme {

    // globally accessible variable - BALANCE
    static int balance = 500;
    static int transferAmount;
    static int leePhone = 500764975;
    static int leePin = 1111;
//    static int aniaPhone = 668408402;
//    static int aniaPin = 2222;
//    static int mariaPhone = 103593062;
//    static int mariaPin = 3333;
//    static int gautamPhone = 104969271;
//    static int gautamPin = 4444;


    // start MENU
    public static void mainMenu() {
        System.out.println("""
                \nWelcome back...\s
                Choose an option:\s
                1. Make a withdrawal\s
                2. Show balance\s
                3. Make a cash deposit\s
                4. Transfer funds / pay a bill \s
                5. BLIK - simplified transfers\s
                6. Change PIN\s
                """);
        menuOptions();
    }

    public static void confirm() {
        Scanner input = new Scanner(System.in);
        String compare;
        System.out.println("\nPress 'Y' to confirm or 'N' to cancel");
        compare = input.next();
        if (compare.equals("y") || compare.equals("Y")) {
            System.out.println("Transfer sent\n"
                    + "Your new balance is " + balance + " PLN\n\n" +
                    "Press '0' to return to the main menu");
            returnToMainMenu();
        } else if (compare.equals("n") || compare.equals("N")) {
            System.out.println("Transfer cancelled\n" +
                    "Your balance is unchanged at: " + (balance + transferAmount) + " PLN\n\n" +
                    "Press '0' to return to the main menu");
            returnToMainMenu();
        } else {
            System.out.println("Invalid key.");
            confirm();
        }
    }

    public static void setAmounts(int choice) {

        switch (choice) {
            case 1 -> {
                balance = balance - 20;
                System.out.println("You have withdrawn: 20.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 2 -> {
                balance = balance - 50;
                System.out.println("You have withdrawn: 50.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 3 -> {
                balance = balance - 100;
                System.out.println("You have withdrawn: 100.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 4 -> {
                balance = balance - 150;
                System.out.println("You have withdrawn: 150.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 5 -> {
                balance = balance - 200;
                System.out.println("You have withdrawn: 200.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 6 -> {
                balance = balance - 250;
                System.out.println("You have withdrawn: 250.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 7 -> {
                balance = balance - 500;
                System.out.println("You have withdrawn: 500.0 PLN \n" +
                        "Your current balance is: " + balance + " PLN");
            }
            case 8 -> System.out.println("Your current balance is: " + balance + " PLN");
        }
        System.out.println("\nPress '0' to return to main menu.");
        {
            returnToMainMenu();
        }
    }

    // press 0 for main menu
    public static void returnToMainMenu() {
        Scanner input = new Scanner(System.in);
        int returnMenu = input.nextInt();
//        String notAllowed = input.next();

        if (returnMenu == 0) {
            mainMenu();
        } else {
            System.out.println("Invalid choice, try again!");
            returnToMainMenu();
        }
    }

    // calculation of custom balance
    public static void customBalance() {
        Scanner input = new Scanner(System.in);
        int toDeduct;

        System.out.println("Your current balance is: " + balance + " PLN\n" +
                "Enter amount to withdraw: ");
        toDeduct = input.nextInt();

        if (toDeduct < 20) {
            System.out.println("You cannot withdraw " + toDeduct + "" +
                    "- the minimum you can withdraw is 20 PLN");
            // toDeduct = input.nextInt();
            customBalance();
        } else if (toDeduct > balance) {
            System.out.println("Insufficient funds, enter a lower amount:");
            //toDeduct = input.nextInt();
            customBalance();
        } else {
            balance = balance - toDeduct;
            System.out.println("Your current balance is: " + balance + " PLN\n\n" +
                    "Press '0' to return to the main menu");
            returnToMainMenu();
        }
    }

    // options MENU
    public static void menuOptions() {

        Scanner input = new Scanner(System.in);
        int options = input.nextInt();

        if (options == 1 || options == 2 || options == 3 || options == 4 || options == 5 || options == 6) {
            switch (options) {
//                case 0 -> System.out.println("See you again soon!\n\n");

                case 1 -> withdraw();

                case 2 -> setAmounts(8);

                case 3 -> depositCash();

                case 4 -> transferFunds();

                case 5 -> blik();

                case 6 -> changePin();

                default -> {
                    System.out.println("Invalid choice, please try again.\n");
                    mainMenu();
                }

            }
        } else {
            System.out.println("Invalid choice, choose an option from 1 to 6\n");
            mainMenu();
        }
    }

    // withdraw MENU
    public static void withdraw() {
        System.out.println("""
                How much would you like to withdraw:\s

                1. 20      5. 200
                2. 50      6. 250
                3. 100     7. 500
                4. 150     8. custom\s

                Press '0' to return to main menu.
                """);
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 0) {
            mainMenu();
        }
        switch (choice) {
            case 1 -> {
                setAmounts(1);
                returnToMainMenu();
            }
            case 2 -> {
                setAmounts(2);
                returnToMainMenu();
            }
            case 3 -> {
                setAmounts(3);
                returnToMainMenu();
            }
            case 4 -> {
                setAmounts(4);
                returnToMainMenu();
            }
            case 5 -> {
                setAmounts(5);
                returnToMainMenu();
            }
            case 6 -> {
                setAmounts(6);
                returnToMainMenu();
            }
            case 7 -> {
                setAmounts(7);
                returnToMainMenu();
            }
            case 8 -> {
                customBalance();
                returnToMainMenu();
            }
        }
    }

    public static void depositCash() {
        Scanner cashAmount = new Scanner(System.in);
        System.out.println("How much would you like to deposit:");
        int cash = cashAmount.nextInt();
        {
            if (cash < 20) {
                System.out.println("You cannot deposit " + cash + " PLN\n" +
                        "- the minimum deposit is 20 PLN");
                depositCash();
            } else if (cash > 10000) {
                System.out.println("You cannot deposit " + cash + " PLN\n" +
                        "- the maximum deposit for a single transaction is 10,000 PLN");
                depositCash();
            }
        }
        balance = balance + cash;
        System.out.println("You have deposited: " + cash + " PLN\n"
                + "Your new balance is: " + balance
                + "\nPress '0' to return to the main menu.");
        returnToMainMenu();

    }

    public static void transferFunds() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the recipient's name:");
        String name = input.next();

        int accNum;
        do {
            System.out.println("Enter the recipient's 9-digit account number:");
            accNum = input.nextInt();
            if (accNum < 100000000 || accNum > 999999999) {
                System.out.println("Account number must have 9 digits, please enter a valid number.");
            } else {
                break;
            }
        }
        while (true);

        do {
            System.out.println("Enter amount to transfer:");
            transferAmount = input.nextInt();
            if (transferAmount < 1) {
                System.out.println("You cannot transfer " + transferAmount + " PLN\n"
                        + " - the minimum transfer is 1 PLN");
            } else if (transferAmount > balance) {
                System.out.println("You have insufficient funds in your account, " +
                        "please choose a lower amount\n" +
                        "Your current balance is: " + balance + " PLN");
            } else {
                break;
            }
        }
        while (true);

        System.out.println("\nCheck the details provided:\n" +
                "Recipient name: " + name +
                "\nRecipient account number: " + accNum +
                "\nAmount to transfer: " + transferAmount);
        balance = balance - transferAmount;
        confirm();
        System.out.println("Press '0' to return to the main menu");
        returnToMainMenu();
    }

    public static void blik() {
        System.out.println("BLIK \n" +
                "- simple transfers using mobile numbers rather than long account numbers");
//        goodPhone();
//        goodAccount();
//        goodPin();

        Scanner input = new Scanner(System.in);

        int fromNum;
        do {
            System.out.println("Enter your phone number:");
            fromNum = input.nextInt();
            if (fromNum < 100000000 || fromNum > 999999999) {
                System.out.println("Invalid number, entry must have 9 digits");
            } else if (fromNum != leePhone) {
                System.out.println("Number not registered to user");
            } else {
                break;
            }
        }
        while (true);

        int toNum;
        do {
            System.out.println("Enter recipient's phone number:");
            toNum = input.nextInt();
            if (toNum < 100000000 || toNum > 999999999) {
                System.out.println("Invalid number, entry must have 9 digits");
            } else {
                break;
            }
        }
        while (true);

        do {
            System.out.println("Enter amount to transfer:");
            transferAmount = input.nextInt();
            if (transferAmount < 1) {
                System.out.println("Amount cannot be " + transferAmount + " PLN\n"
                        + " - minimum amount 1 PLN\n" +
                        "Enter amount to transfer:");
            } else if (transferAmount > balance) {
                System.out.println("You have insufficient funds in your account, " +
                        "please choose a lower amount\n" +
                        "Your current balance is: " + balance + " PLN\n" +
                        "Enter amount to transfer:");
            } else {
                break;
            }
        }
        while (true);

        int pin;
        do {
            System.out.println("Enter PIN:");
            pin = input.nextInt();
            if (pin < 1000 || pin > 9999) {
                System.out.println("Invalid PIN, entry must have 4 digits");
            } else if (pin != leePin) {
                System.out.println("Wrong PIN");
            } else {
                break;
            }
        }
        while (true);

        System.out.println("\nCheck the details provided:\n" +
                "Your phone number: " + fromNum +
                "\nRecipient's phone number: " + toNum +
                "\nAmount to transfer: " + transferAmount);
        balance = balance - transferAmount;
        confirm();
        System.out.println("Press '0' to return to main menu");
        returnToMainMenu();
    }

    public static void changePin() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter old pin:");
        int oldPin = input.nextInt();
        if (oldPin != leePin) {
            System.out.println("Incorrect PIN, try again");
            changePin();
        } else {
            System.out.println("Enter a new PIN:");
            int newPin = input.nextInt();
            System.out.println("Enter new PIN again:");
            int newPin2 = input.nextInt();
            if (newPin != newPin2) {
                System.out.println("PIN numbers do not match");
                changePin();
            } else {
                System.out.println("Type 'Y' to confirm or 'N' to cancel");
                String confirm = input.next();
                if (confirm.equals("Y") || confirm.equals("y")) {
                    leePin = newPin;
                    System.out.println("PIN changed");
                    System.out.println("Your new PIN is: " + leePin);
                } else if (confirm.equals("N") || confirm.equals("n")) {
                    System.out.println("PIN change cancelled");
                    System.out.println("Press '0' to return to main menu");
                    returnToMainMenu();
                }
            }
        }
    }


//    public static void goodPin (){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter PIN number:");
//        int pinCheck = input.nextInt();
//        if (pinCheck < 1000 || pinCheck > 9999){
//            System.out.println("Pin must have 4 digits");
//        }
//    }
//    public static void goodAccount (){
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter account number:");
//        int accCheck = input.nextInt();
//        if (accCheck < 100000000 || accCheck > 999999999){
//            System.out.println("Account number must have 9 digits");
//        }
//    }
//    public static void goodPhone () {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter your number:");
//        int toPhone = input.nextInt();
//        if (toPhone < 100000000 || toPhone > 999999999) {
//            System.out.println("Phone number must have 9 digits");
//        }
//    }
//    public static void goodAmount() {
//        Scanner input = new Scanner(System.in);
//
//    }

//                input.nextInt();
//            } else if (phoNum != leePhone) {
//                System.out.println("Incorrect number for user");
////            phoNum = input.nextInt();

//        if (phoNum == leePhone)
//            System.out.println("Enter your pin:");
//        pin = input.nextInt();
//        {
//            if (pin == leePin) {
//                mainMenu();
//            } else {
//                System.out.println("Wrong pin, try again");
//                input.nextInt();
//            }
//            System.out.println("Press '0' to return to main menu.");
//            returnToMainMenu();


    public static void user() {
        System.out.println("""
                *-*-*-*-*-*-*-*-*-*-*-*-*
                * Welcome to the vault *
                *-*-*-*-*-*-*-*-*-*-*-*-*

                Hello, please enter username:\s""");
        Scanner input = new Scanner(System.in);
        String Ania = "Ania";
        String Maria = "Maria";
        String Lee = "Lee";
        String Gautam = "Gautam";
        String Leo = "Leo";
        String name = input.next();
        if (name.equals(Ania) || name.equals(Maria) || name.equals(Lee) || name.equals(Gautam) || name.equals(Leo)) {
            System.out.println("Welcome back " + name + "\n");
            pinEntry();
        } else {
            System.out.println("User not found, try again");
            user();
        }
    }

    public static void pinEntry() {
        Scanner input = new Scanner(System.in);
        final int pin = 1234;
        int count = 3;

        System.out.println("""
                   -Vault No.352.
                     Deposit, deposit more, and invest in my stocks...
                   Good luck!

                Enter pin:\s""");
        int checkPin = input.nextInt();

        for (int i = 0; i < 3; i++) {
            if (checkPin < 1000 || checkPin > 9999) {
                System.out.println("Pin must have 4 digits only");
                System.out.println("Enter pin: ");
                checkPin = input.nextInt();
            }
            if (checkPin == pin) {
                mainMenu();
            } else {
                count--;
                System.out.println("Invalid pin, you have " + count + " tries remaining");

                System.out.println("Enter pin: ");
                checkPin = input.nextInt();
            }

            if (count == 0) {
                System.out.println("Pin blocked");
            }
        }
    }

    // main
    public static void main(String[] args) {

        user();
    }
}

// stocks
