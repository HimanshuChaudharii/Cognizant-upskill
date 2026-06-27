// Adaptee Class 1: PayPal Gateway
public class PayPalGateway {
    public void makePayment(String email, double amount) {
        System.out.println("PayPal Gateway: Processing payment of $" + amount + " to account: " + email);
    }
}
