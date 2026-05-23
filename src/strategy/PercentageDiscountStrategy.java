package strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double appyDiscount(double total) {
        return total - (total * (percentage / 100));
    }
}
