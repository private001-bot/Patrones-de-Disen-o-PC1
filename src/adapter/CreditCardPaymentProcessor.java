package adapter;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Pago realizado con Tarjetas de Credito por S/ " + amount);
    }
}
