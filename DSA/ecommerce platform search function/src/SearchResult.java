public class SearchResult {
    private Product product;
    private int comparisons;

    public SearchResult(Product product, int comparisons) {
        this.product = product;
        this.comparisons = comparisons;
    }

    public Product getProduct() {
        return product;
    }

    public int getComparisons() {
        return comparisons;
    }
}
