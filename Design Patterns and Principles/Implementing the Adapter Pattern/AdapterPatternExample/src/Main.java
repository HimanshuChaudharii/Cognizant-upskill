public class Main {
    public static void main(String[] args) {
        System.out.println("=== Payment Gateway Integration (Adapter Design Pattern) ===\n");

        // 1. Processing a payment through PayPal Adapter
        System.out.println("--- Scenario 1: PayPal Transaction ---");
        PayPalGateway payPalGateway = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway, "customer_paypal@example.com");
        // Client interacts only with the target interface
        payPalProcessor.processPayment(120.50);
        
        System.out.println();

        // 2. Processing a payment through Stripe Adapter
        System.out.println("--- Scenario 2: Stripe Transaction ---");
        StripeGateway stripeGateway = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway, "tok_visa_45678");
        // Client interacts only with the target interface
        stripeProcessor.processPayment(350.75);
    }
}

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    void makePayment(double amount, String email) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + email);
    }
}

class StripeGateway {
    void charge(double amount, String token) {
        System.out.println("Processing Stripe payment of $" + amount + " with token " + token);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway gateway;
    private final String email;

    PayPalAdapter(PayPalGateway gateway, String email) {
        this.gateway = gateway;
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        gateway.makePayment(amount, email);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway gateway;
    private final String token;

    StripeAdapter(StripeGateway gateway, String token) {
        this.gateway = gateway;
        this.token = token;
    }

    @Override
    public void processPayment(double amount) {
        gateway.charge(amount, token);
    }
}
