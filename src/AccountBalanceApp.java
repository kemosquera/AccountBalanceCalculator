import java.util.Scanner;

public class AccountBalanceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CheckingAccount checking = new CheckingAccount(1000.00, 1.00);
        SavingsAccount savings = new SavingsAccount(1000.00, 0.01); // 1% interest rate

        System.out.println("Welcome to the Account application\n");

        System.out.println("Starting Balances");
        System.out.printf("Checking: $%.2f%n", checking.getBalance());
        System.out.printf("Savings:  $%.2f%n%n", savings.getBalance());

        System.out.println("Enter the transactions for the month");

        String continueChoice;
        do {
            // Validate transaction type (w/d)
            String transactionType;
            do {
                System.out.print("\nWithdrawal or deposit? (w/d): ");
                transactionType = sc.next().toLowerCase();
                if (!transactionType.equals("w") && !transactionType.equals("d")) {
                    System.out.println("Invalid input. Please enter 'w' for withdrawal or 'd' for deposit.");
                }
            } while (!transactionType.equals("w") && !transactionType.equals("d"));

            // Validate account type (c/s)
            String accountType;
            do {
                System.out.print("Checking or savings? (c/s): ");
                accountType = sc.next().toLowerCase();
                if (!accountType.equals("c") && !accountType.equals("s")) {
                    System.out.println("Invalid input. Please enter 'c' for checking or 's' for savings.");
                }
            } while (!accountType.equals("c") && !accountType.equals("s"));

            // Validate amount (positive number)
            double amount;
            do {
                System.out.print("Amount?: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount. Please enter a numeric value.");
                    System.out.print("Amount?: ");
                    sc.next(); // clear invalid input
                }
                amount = sc.nextDouble();
                if (amount <= 0) {
                    System.out.println("Amount must be positive. Please try again.");
                }
            } while (amount <= 0);

            // Perform transaction
            if (accountType.equals("c")) {
                if (transactionType.equals("w")) {
                    checking.withdraw(amount);
                } else {
                    checking.deposit(amount);
                }
            } else {
                if (transactionType.equals("w")) {
                    savings.withdraw(amount);
                } else {
                    savings.deposit(amount);
                }
            }

            // Validate continue option (y/n)
            do {
                System.out.print("\nContinue? (y/n): ");
                continueChoice = sc.next().toLowerCase();
                if (!continueChoice.equals("y") && !continueChoice.equals("n")) {
                    System.out.println("Invalid input. Please enter 'y' to continue or 'n' to exit.");
                }
            } while (!continueChoice.equals("y") && !continueChoice.equals("n"));

        } while (continueChoice.equals("y"));

        // Apply monthly fees and interest
        checking.applyMonthlyFee();
        savings.applyMonthlyInterest();

        // Final output
        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("Checking fee:              $%.2f%n", checking.getMonthlyFee());
        System.out.printf("Savings interest payment:  $%.2f%n", savings.getMonthlyInterestPayment());

        System.out.println("\nFinal Balances");
        System.out.printf("Checking: $%.2f%n", checking.getBalance());
        System.out.printf("Savings:  $%.2f%n", savings.getBalance());

        sc.close();
    }
}