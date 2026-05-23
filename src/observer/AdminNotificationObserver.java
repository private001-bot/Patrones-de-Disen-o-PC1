package observer;

public class AdminNotificationObserver implements OrderObserver {
    public void update(String message) {
        System.out.println("Notificando al administrador de la venta...");
    }
}
