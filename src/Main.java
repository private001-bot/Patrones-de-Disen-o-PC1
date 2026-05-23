
import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import observer.AdminNotificationObserver;
import observer.EmailNotificationObserver;
import observer.InventoryObserver;
import service.OrderService;
import strategy.DiscountStrategy;
import strategy.PercentageDiscountStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE TIENDA VIRTUAL ===");

        Product laptop = new Product("Laptop Gamer", 3500.00);
        Product mouse = new Product("Mouse Inalambrico", 150.00);

        Cart cart = new Cart();
        cart.addProduct(laptop);
        cart.addProduct(mouse);

        System.out.println("Productos agregados al carrito.");

        System.out.println("Subtotal: S/ " + cart.calculateTotal());

        DiscountStrategy discount = new PercentageDiscountStrategy(10);
        OrderService orderService = new OrderService(cart, discount);

        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());

        ExternalPayPalService externalService = new ExternalPayPalService();
        PaymentProcessor paymentProcessor = new PayPalAdapter(externalService);

        System.out.println("\n=== PROCESANDO COMPRA ===");
        orderService.processOrder(paymentProcessor);

        System.out.println("=== COMPRA FINALIZADA EXITOSAMENTE ===");

    }
}
