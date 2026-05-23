package strategy;

public class FixedAmountDiscountStrategy {
    private double discountAmount;

    public FixedAmountDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double applyDiscount(double total) {
        return total - discountAmount;
    }
}
