public class Main {
    public static void main(String[] args) {
        // Create an array of customer orders
        Order[] ordersForBubble = {
            new Order(1001, "Alice Smith", 250.50),
            new Order(1002, "Bob Jones", 1200.00),
            new Order(1003, "Charlie Brown", 75.25),
            new Order(1004, "Diana Prince", 450.00),
            new Order(1005, "Ethan Hunt", 890.75),
            new Order(1006, "Fiona Gallagher", 120.00)
        };

        // Clone the array for Quick Sort to ensure an identical dataset
        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("=== Original Orders ===");
        printOrders(ordersForBubble);

        // Run Bubble Sort
        System.out.println("\n=== Sorting using Bubble Sort (Descending) ===");
        SortingAlgorithms.bubbleSort(ordersForBubble);
        printOrders(ordersForBubble);

        // Run Quick Sort
        System.out.println("\n=== Sorting using Quick Sort (Descending) ===");
        SortingAlgorithms.quickSort(ordersForQuick);
        printOrders(ordersForQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

class SortingAlgorithms {
    static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].getTotalAmount() < orders[j + 1].getTotalAmount()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    static void quickSort(Order[] orders) {
        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalAmount();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalAmount() > pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

class Order {
    private final int orderId;
    private final String customerName;
    private final double totalAmount;

    Order(int orderId, String customerName, double totalAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Order{id=" + orderId + ", customer='" + customerName + "', amount=" + totalAmount + "}";
    }

    double getTotalAmount() {
        return totalAmount;
    }
}
