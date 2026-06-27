// Test Class - Demonstrates selecting and using different payment strategies at runtime

public class StrategyPatternTest {
    public static void main(String[] args) {
        Object context = createPaymentContext();
        Class<?> paymentStrategyClass = loadClass("PaymentStrategy");

        System.out.println("=== Strategy Pattern - Payment System Demo ===\n");

        // Strategy 1: Pay using Credit Card
        System.out.println("--- Selecting Credit Card Payment ---");
        Object creditCard = createInstance("CreditCardPayment",
            new Class<?>[] { String.class, String.class, String.class, String.class },
            new Object[] { "John Doe", "1234567890123456", "786", "12/2028" });
        invoke(context, "setPaymentStrategy", new Class<?>[] { paymentStrategyClass }, new Object[] { creditCard });
        invoke(context, "executePayment", new Class<?>[] { double.class }, new Object[] { 150.75 });

        System.out.println();

        // Strategy 2: Pay using PayPal
        System.out.println("--- Selecting PayPal Payment ---");
        Object payPal = createInstance("PayPalPayment",
            new Class<?>[] { String.class, String.class },
            new Object[] { "john.doe@example.com", "securePass123" });
        invoke(context, "setPaymentStrategy", new Class<?>[] { paymentStrategyClass }, new Object[] { payPal });
        invoke(context, "executePayment", new Class<?>[] { double.class }, new Object[] { 89.99 });

        System.out.println();

        // Demonstrating runtime strategy switching
        System.out.println("--- Switching back to Credit Card Payment ---");
        Object anotherCard = createInstance("CreditCardPayment",
            new Class<?>[] { String.class, String.class, String.class, String.class },
            new Object[] { "Jane Smith", "9876543210987654", "123", "06/2027" });
        invoke(context, "setPaymentStrategy", new Class<?>[] { paymentStrategyClass }, new Object[] { anotherCard });
        invoke(context, "executePayment", new Class<?>[] { double.class }, new Object[] { 250.00 });

        System.out.println("\n=== Demo Complete ===");
    }

    private static Object createPaymentContext() {
        try {
            return Class.forName("PaymentContext").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to create PaymentContext", e);
        }
    }

    private static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load " + className, e);
        }
    }

    private static Object createInstance(String className, Class<?>[] parameterTypes, Object[] args) {
        try {
            return Class.forName(className).getDeclaredConstructor(parameterTypes).newInstance(args);
        } catch (Exception e) {
            throw new RuntimeException("Unable to create " + className, e);
        }
    }

    private static void invoke(Object target, String methodName, Class<?>[] parameterTypes, Object[] args) {
        try {
            target.getClass().getMethod(methodName, parameterTypes).invoke(target, args);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke " + methodName, e);
        }
    }
}
