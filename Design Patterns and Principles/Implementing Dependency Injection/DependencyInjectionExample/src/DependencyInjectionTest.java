// Main Class - Demonstrates Dependency Injection via Constructor Injection
public class DependencyInjectionTest {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection - Customer Management Demo ===\n");

        // 1. Create the concrete repository (the dependency)
        CustomerRepository repository = new CustomerRepository();

        // 2. Inject the repository into the service via constructor
        CustomerService service = new CustomerService(repository);

        // 3. Use the service to find customers
        System.out.println("--- Finding Customer with ID 1 ---");
        service.getCustomerById(1);

        System.out.println();

        System.out.println("--- Finding Customer with ID 3 ---");
        service.getCustomerById(3);

        System.out.println();

        System.out.println("--- Finding Customer with ID 5 (does not exist) ---");
        service.getCustomerById(5);

        System.out.println("\n=== Demo Complete ===");
    }
}

class CustomerRepository {
    public String findById(int id) {
        switch (id) {
            case 1:
                return "Customer 1: Alice";
            case 3:
                return "Customer 3: Bob";
            default:
                return null;
        }
    }
}

class CustomerService {
    private final CustomerRepository repository;

    CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerById(int id) {
        String customer = repository.findById(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
