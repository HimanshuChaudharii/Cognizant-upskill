public class SearchResult {
    private Book book;
    private int comparisons;

    public SearchResult(Book book, int comparisons) {
        this.book = book;
        this.comparisons = comparisons;
    }

    public Book getBook() {
        return book;
    }

    public int getComparisons() {
        return comparisons;
    }
}
