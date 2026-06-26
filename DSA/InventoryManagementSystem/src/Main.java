public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("=== Adding Products ===");
        Product p1 = new Product(101, "Laptop", 50, 999.99);
        Product p2 = new Product(102, "Smartphone", 100, 499.99);
        Product p3 = new Product(103, "Headphones", 200, 79.99);

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        // Try adding a duplicate product ID
        inventory.addProduct(new Product(101, "Tablet", 30, 299.99));

        System.out.println("\n=== Displaying Products ===");
        inventory.displayProducts();

        System.out.println("\n=== Updating Product ===");
        inventory.updateProduct(102, "Smartphone (Gen 2)", 120, 549.99);
        // Try updating a non-existent product
        inventory.updateProduct(104, "Smartwatch", 10, 199.99);

        System.out.println("\n=== Displaying Products After Update ===");
        inventory.displayProducts();

        System.out.println("\n=== Searching Product ===");
        Product found = inventory.getProduct(101);
        if (found != null) {
            System.out.println("Found product: " + found);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n=== Deleting Product ===");
        inventory.deleteProduct(103);
        // Try deleting a non-existent product
        inventory.deleteProduct(105);

        System.out.println("\n=== Displaying Products After Deletion ===");
        inventory.displayProducts();
    }
}
