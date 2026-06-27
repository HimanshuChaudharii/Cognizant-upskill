interface PaymentStrategy {
    void pay(double amount);
}

public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(String name, String cardNumber, String cvv, String dateOfExpiry) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + String.format("%.2f", amount) +
                           " using card number " + maskCardNumber(cardNumber) +
                           " CVV " + maskCvv(cvv) +
                           " expiring on " + dateOfExpiry);
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }

    private String maskCvv(String cvv) {
        if (cvv == null || cvv.isEmpty()) {
            return "***";
        }
        return "***";
    }
}
