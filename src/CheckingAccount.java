// CheckingAccount.java
public class CheckingAccount extends Account {
    private double monthlyFee;

    public CheckingAccount(double balance, double monthlyFee) {
        super(balance);
        this.monthlyFee = monthlyFee;
    }

    public void applyMonthlyFee() {
        balance -= monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}