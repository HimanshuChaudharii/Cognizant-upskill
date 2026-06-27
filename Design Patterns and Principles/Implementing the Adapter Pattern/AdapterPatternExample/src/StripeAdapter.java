// Adapter Class for Stripe
public class StripeAdapter {
    private Object stripeGateway;
    private String cardToken;

    public StripeAdapter(Object stripeGateway, String cardToken) {
        this.stripeGateway = stripeGateway;
        this.cardToken = cardToken;
    }

    public void processPayment(double amount) {
        // Translate processPayment(amount) to Stripe-specific charge(cardToken, amount)
        try {
            stripeGateway.getClass().getMethod("charge", double.class, String.class)
                    .invoke(stripeGateway, amount, cardToken);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to process payment via Stripe gateway", e);
        }
    }
}
