// Repository Interface - Defines the contract for data access
public interface CustomerRepository {
    Customer findCustomerById(int id);
}

// Minimal model type referenced by the repository interface
class Customer {
}
