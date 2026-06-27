import java.util.HashMap;
import java.util.Map;

// Concrete Repository - Simulates data access with an in-memory store
public class CustomerRepositoryImpl {
    private Map<Integer, Customer> customerDatabase;

    public CustomerRepositoryImpl() {
        // Simulate a database with some pre-loaded customers
        customerDatabase = new HashMap<>();
        Customer customer1 = new Customer();
        customerDatabase.put(1, customer1);

        Customer customer2 = new Customer();
        customerDatabase.put(2, customer2);

        Customer customer3 = new Customer();
        customerDatabase.put(3, customer3);
    }

    public Customer findCustomerById(int id) {
        System.out.println("[Repository] Searching for customer with ID: " + id);
        return customerDatabase.get(id);
    }
}

// Minimal Customer model for this example
class Customer {
}
