// SavingsAccount.java
public class SavingsAccount extends Account {
    private double monthlyInterestRate;
    private double monthlyInterestPayment;

    public SavingsAccount(double balance, double monthlyInterestRate) {
        super(balance);
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void applyMonthlyInterest() {
        monthlyInterestPayment = balance * monthlyInterestRate;
        balance += monthlyInterestPayment;
    }

    public double getMonthlyInterestPayment() {
        return monthlyInterestPayment;
    }
}