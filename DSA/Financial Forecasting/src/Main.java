public class Main {
    public static void main(String[] args) {
        double principal = 1000.00; // Present Value
        double growthRate = 0.05;   // 5% growth rate
        int periods = 10;           // 10 years / periods

        System.out.println("=== Running Financial Forecast (Periods: " + periods + ") ===");
        System.out.printf("Initial Principal: $%.2f%n", principal);
        System.out.printf("Growth Rate: %.1f%%%n%n", growthRate * 100);

        // 1. Recursive Method
        double recursiveResult = FinancialForecasting.calculateFutureValueRecursive(principal, growthRate, periods);
        System.out.printf("1. Recursive Future Value: $%.2f%n", recursiveResult);

        // 2. Iterative Method
        double iterativeResult = FinancialForecasting.calculateFutureValueIterative(principal, growthRate, periods);
        System.out.printf("2. Iterative Future Value: $%.2f%n", iterativeResult);

        // 3. Direct Mathematical Method
        double directResult = FinancialForecasting.calculateFutureValueDirect(principal, growthRate, periods);
        System.out.printf("3. Direct Formula Future Value: $%.2f%n%n", directResult);

        System.out.println("=== Testing Recursion Limits (Large Periods) ===");
        int largePeriods = 25000;
        System.out.println("Attempting to run recursive method with " + largePeriods + " periods...");

        try {
            double result = FinancialForecasting.calculateFutureValueRecursive(principal, growthRate, largePeriods);
            System.out.printf("Recursive Success! Future Value: $%.2f%n", result);
        } catch (StackOverflowError e) {
            System.out.println("Result: Recursive method failed due to StackOverflowError.");
            System.out.println("Explanation: The call stack exceeded its maximum limit due to deep recursion.");
        }

        System.out.println("\nAttempting to run optimized iterative method with " + largePeriods + " periods...");
        try {
            double result = FinancialForecasting.calculateFutureValueIterative(principal, growthRate, largePeriods);
            System.out.printf("Iterative Success! Future Value: $%.2e%n", result);
        } catch (Throwable t) {
            System.out.println("Iterative method failed: " + t.getMessage());
        }

        System.out.println("\nAttempting to run optimized direct method with " + largePeriods + " periods...");
        try {
            double result = FinancialForecasting.calculateFutureValueDirect(principal, growthRate, largePeriods);
            System.out.printf("Direct Formula Success! Future Value: $%.2e%n", result);
        } catch (Throwable t) {
            System.out.println("Direct formula failed: " + t.getMessage());
        }
    }

    static class FinancialForecasting {
        static double calculateFutureValueRecursive(double principal, double growthRate, int periods) {
            if (periods == 0) {
                return principal;
            }
            return calculateFutureValueRecursive(principal * (1 + growthRate), growthRate, periods - 1);
        }

        static double calculateFutureValueIterative(double principal, double growthRate, int periods) {
            double futureValue = principal;
            for (int i = 0; i < periods; i++) {
                futureValue *= (1 + growthRate);
            }
            return futureValue;
        }

        static double calculateFutureValueDirect(double principal, double growthRate, int periods) {
            return principal * Math.pow(1 + growthRate, periods);
        }
    }
}
