// Adaptee Class 2: Stripe Gateway
public class StripeGateway {
    public void charge(String cardToken, double amount) {
        System.out.println("Stripe Gateway: Charging card with amount $" + amount + " (Card Token: " + cardToken + ")");
    }
}
