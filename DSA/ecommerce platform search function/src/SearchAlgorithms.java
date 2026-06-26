public class SearchAlgorithms {

    /**
     * Performs a linear search on an array of products to find a product by its ID.
     * Time Complexity:
     * - Best Case: O(1)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     */
    public static SearchResult linearSearch(Product[] products, int targetId) {
        int comparisons = 0;
        for (Product product : products) {
            comparisons++;
            if (product.getProductId() == targetId) {
                return new SearchResult(product, comparisons);
            }
        }
        return new SearchResult(null, comparisons);
    }

    /**
     * Performs a binary search on a sorted array of products to find a product by its ID.
     * Requires the array to be sorted by productId.
     * Time Complexity:
     * - Best Case: O(1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */
    public static SearchResult binarySearch(Product[] products, int targetId) {
        int comparisons = 0;
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = products[mid].getProductId();
            comparisons++;

            if (midId == targetId) {
                return new SearchResult(products[mid], comparisons);
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(null, comparisons);
    }
}
