import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product with ID " + product.getProductId() + " already exists.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Product Added: " + product.getProductName());
    }

    public void updateProduct(int id, String name, int quantity, double price) {
        Product product = products.get(id);
        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product Updated: " + name);
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void deleteProduct(int id) {
        Product removedProduct = products.remove(id);
        if (removedProduct != null) {
            System.out.println("Product Deleted: " + removedProduct.getProductName());
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
