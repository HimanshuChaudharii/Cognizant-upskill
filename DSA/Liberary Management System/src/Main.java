import java.util.Arrays;

class Book implements Comparable<Book> {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class SearchResult {
    private final Book book;
    private final int comparisons;

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

class SearchAlgorithms {
    public static SearchResult linearSearch(Book[] books, String targetTitle) {
        int comparisons = 0;
        for (Book book : books) {
            comparisons++;
            if (book.getTitle().equals(targetTitle)) {
                return new SearchResult(book, comparisons);
            }
        }
        return new SearchResult(null, comparisons);
    }

    public static SearchResult binarySearch(Book[] books, String targetTitle) {
        int comparisons = 0;
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            comparisons++;
            int comparison = books[mid].getTitle().compareTo(targetTitle);

            if (comparison == 0) {
                return new SearchResult(books[mid], comparisons);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new SearchResult(null, comparisons);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an array of books (unsorted)
        Book[] books = {
            new Book(101, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(102, "To Kill a Mockingbird", "Harper Lee"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "Pride and Prejudice", "Jane Austen"),
            new Book(105, "The Catcher in the Rye", "J.D. Salinger"),
            new Book(106, "The Hobbit", "J.R.R. Tolkien"),
            new Book(107, "Brave New World", "Aldous Huxley")
        };

        System.out.println("=== Unsorted Books (for Linear Search) ===");
        printBooks(books);

        String searchTitle1 = "The Hobbit";
        String searchTitle2 = "1984";
        String searchTitle3 = "Moby Dick"; // Non-existent

        System.out.println("\n=== Running Linear Search ===");
        runLinearSearchDemo(books, searchTitle1);
        runLinearSearchDemo(books, searchTitle2);
        runLinearSearchDemo(books, searchTitle3);

        // Sort the array by title for Binary Search
        System.out.println("\n=== Sorting Books by Title for Binary Search ===");
        Arrays.sort(books);
        printBooks(books);

        System.out.println("\n=== Running Binary Search ===");
        runBinarySearchDemo(books, searchTitle1);
        runBinarySearchDemo(books, searchTitle2);
        runBinarySearchDemo(books, searchTitle3);
    }

    private static void runLinearSearchDemo(Book[] books, String targetTitle) {
        SearchResult result = SearchAlgorithms.linearSearch(books, targetTitle);
        printResult("Linear Search", targetTitle, result);
    }

    private static void runBinarySearchDemo(Book[] books, String targetTitle) {
        SearchResult result = SearchAlgorithms.binarySearch(books, targetTitle);
        printResult("Binary Search", targetTitle, result);
    }

    private static void printResult(String method, String targetTitle, SearchResult result) {
        System.out.print(method + " for '" + targetTitle + "' -> ");
        if (result.getBook() != null) {
            System.out.println("Found: " + result.getBook() + " | Comparisons: " + result.getComparisons());
        } else {
            System.out.println("NOT FOUND | Comparisons: " + result.getComparisons());
        }
    }

    private static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
