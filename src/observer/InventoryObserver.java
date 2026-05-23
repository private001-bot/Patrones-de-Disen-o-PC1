package observer;

public class InventoryObserver implements OrderObserver{
    public void update(String message) {
        System.out.println("Descontando stock en inventario...");
    }
}
