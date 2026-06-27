// Context Class - Holds reference to a PaymentStrategy and delegates payment execution
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the selected strategy
    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: No payment strategy selected!");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
