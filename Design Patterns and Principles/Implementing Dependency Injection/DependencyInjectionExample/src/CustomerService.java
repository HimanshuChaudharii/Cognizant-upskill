// Local fallback Customer model to resolve missing external package during compilation.
// Minimal representation used by this example.
class Customer {
    private final int id;
    private final String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

// Local fallback interface to resolve missing external repository package during compilation.
// This non-public interface mirrors the expected methods of the real repository.
interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Service Class - Business logic layer that depends on CustomerRepository
public class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection - dependency is provided through the constructor
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(int id) {
        System.out.println("[Service] Request to fetch customer with ID: " + id);
        Customer customer = customerRepository.findCustomerById(id);

        if (customer != null) {
            System.out.println("[Service] Customer found: " + customer);
        } else {
            System.out.println("[Service] No customer found with ID: " + id);
        }

        return customer;
    }
}
