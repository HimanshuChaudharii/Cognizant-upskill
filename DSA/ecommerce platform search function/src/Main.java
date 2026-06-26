import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create an array of products (initially unsorted)
        Product[] products = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(108, "Running Shoes", "Footwear"),
            new Product(103, "Water Bottle", "Accessories"),
            new Product(102, "Leather Wallet", "Accessories"),
            new Product(107, "Desk Lamp", "Home Decor"),
            new Product(104, "Backpack", "Travel"),
            new Product(106, "Bluetooth Speaker", "Electronics")
        };

        System.out.println("=== Unsorted Product List (for Linear Search) ===");
        for (Product p : products) {
            System.out.println(p);
        }

        // Target search IDs
        int targetId1 = 104; // Located mid-way in the unsorted array
        int targetId2 = 105; // Located at the beginning of the unsorted array
        int targetId3 = 108; // Located towards the end of the unsorted array
        int targetId4 = 999; // Non-existent product

        System.out.println("\n=== Running Linear Search ===");
        runLinearSearchDemo(products, targetId1);
        runLinearSearchDemo(products, targetId2);
        runLinearSearchDemo(products, targetId3);
        runLinearSearchDemo(products, targetId4);

        // Sort the array for Binary Search
        System.out.println("\n=== Sorting Product Array by Product ID ===");
        Arrays.sort(products);
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\n=== Running Binary Search ===");
        runBinarySearchDemo(products, targetId1);
        runBinarySearchDemo(products, targetId2);
        runBinarySearchDemo(products, targetId3);
        runBinarySearchDemo(products, targetId4);
    }

    private static void runLinearSearchDemo(Product[] products, int targetId) {
        SearchResult result = SearchAlgorithms.linearSearch(products, targetId);
        printResult("Linear Search", targetId, result);
    }

    private static void runBinarySearchDemo(Product[] products, int targetId) {
        SearchResult result = SearchAlgorithms.binarySearch(products, targetId);
        printResult("Binary Search", targetId, result);
    }

    private static void printResult(String method, int targetId, SearchResult result) {
        System.out.print(method + " for ID " + targetId + " -> ");
        if (result.getProduct() != null) {
            System.out.println("Found: " + result.getProduct().getProductName() +
                               " | Comparisons made: " + result.getComparisons());
        } else {
            System.out.println("NOT FOUND | Comparisons made: " + result.getComparisons());
        }
    }
}
