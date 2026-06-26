public class SortingAlgorithms {

    /**
     * Sorts an array of orders in descending order of totalPrice using Bubble Sort.
     * Time Complexity:
     * - Best Case: O(n) (when the array is already sorted, using the swapped flag optimization)
     * - Worst Case: O(n^2)
     * - Average Case: O(n^2)
     * Space Complexity: O(1) (in-place)
     */
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // For descending order, swap if the current element is smaller than the next
                if (orders[j].getTotalPrice() < orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts an array of orders in descending order of totalPrice using Quick Sort.
     * Time Complexity:
     * - Best Case: O(n log n)
     * - Worst Case: O(n^2) (when the pivot choice is highly skewed, e.g., already sorted array)
     * - Average Case: O(n log n)
     * Space Complexity: O(log n) (due to recursive call stack)
     */
    public static void quickSort(Order[] orders) {
        quickSortHelper(orders, 0, orders.length - 1);
    }

    private static void quickSortHelper(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSortHelper(orders, low, pi - 1);
            quickSortHelper(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // index of larger element for descending order

        for (int j = low; j < high; j++) {
            // For descending order, we place elements larger than or equal to pivot on the left
            if (orders[j].getTotalPrice() >= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i+1] and orders[high] (the pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}
