public class SearchAlgorithms {

    /**
     * Performs a linear search on an array of books to find a book by its title.
     * Works on both sorted and unsorted arrays.
     * Time Complexity:
     * - Best Case: O(1)
     * - Worst Case: O(n)
     * - Average Case: O(n)
     */
    public static SearchResult linearSearch(Book[] books, String targetTitle) {
        int comparisons = 0;
        for (Book book : books) {
            comparisons++;
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return new SearchResult(book, comparisons);
            }
        }
        return new SearchResult(null, comparisons);
    }

    /**
     * Performs a binary search on a sorted array of books to find a book by its title.
     * Requires the array to be sorted alphabetically by title.
     * Time Complexity:
     * - Best Case: O(1)
     * - Worst Case: O(log n)
     * - Average Case: O(log n)
     */
    public static SearchResult binarySearch(Book[] books, String targetTitle) {
        int comparisons = 0;
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midTitle = books[mid].getTitle();
            comparisons++;

            int cmp = midTitle.compareToIgnoreCase(targetTitle);
            if (cmp == 0) {
                return new SearchResult(books[mid], comparisons);
            } else if (cmp < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        return new SearchResult(null, comparisons);
    }
}
