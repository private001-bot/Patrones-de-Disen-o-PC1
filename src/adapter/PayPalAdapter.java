package adapter;

public class PayPalAdapter {
    private ExternalPayPalService payPalService;

    public PayPalAdapter(ExternalPayPalService payPalService) {
        this.payPalService = payPalService;
    }
    public void pay(double amount) {
        payPalService.makePayment("PEN", amount);
    }
}
