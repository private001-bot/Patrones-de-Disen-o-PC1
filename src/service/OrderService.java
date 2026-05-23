package service;

import adapter.PaymentProcessor;
import model.Cart;
import observer.OrderObserver;
import strategy.DiscountStrategy;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private Cart cart;
    private DiscountStrategy discountStrategy;
    private List<OrderObserver> observers;

    public OrderService(Cart cart, DiscountStrategy discountStrategy) {
        this.cart = cart;
        this.discountStrategy = discountStrategy;
        this.observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {
        this.observers.add(observer);
    }
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void processOrder(PaymentProcessor paymentProcessor) {
        double total = cart.calculateTotal();
        double finalTotal = discountStrategy.applyDiscount(total);
        paymentProcessor.pay(finalTotal);

        for (OrderObserver observer : observers) {
            observer.update("Compra procesada.");
        }
    }
}
