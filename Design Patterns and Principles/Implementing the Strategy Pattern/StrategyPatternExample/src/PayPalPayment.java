interface PaymentStrategy {
    void pay(double amount);
}

// Concrete Strategy - PayPal Payment
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + String.format("%.2f", amount) +
                           " using PayPal account: " + maskEmail(email) +
                           " with password length: " + (password == null ? 0 : password.length()));
    }

    private String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return "****";
        }
        int atIndex = email.indexOf("@");
        String localPart = email.substring(0, atIndex);
        String domain = email.substring(atIndex);
        if (localPart.length() <= 2) {
            return localPart + "****" + domain;
        }
        return localPart.substring(0, 2) + "****" + domain;
    }
}
