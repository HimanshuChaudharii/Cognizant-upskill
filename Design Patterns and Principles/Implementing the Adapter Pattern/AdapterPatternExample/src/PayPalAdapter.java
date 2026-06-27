// Adapter Class for PayPal

interface PaymentProcessor {
    void processPayment(double amount);
}

interface PayPalGateway {
    void makePayment(double amount, String email);
}

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;
    private String email;

    public PayPalAdapter(PayPalGateway payPalGateway, String email) {
        this.payPalGateway = payPalGateway;
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        // Translate processPayment(amount) to PayPal-specific makePayment(email, amount)
        payPalGateway.makePayment(amount, email);
    }
}
