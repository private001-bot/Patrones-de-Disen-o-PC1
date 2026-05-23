import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total = total + product.getPrice();
        }
        return total;
    }
}
