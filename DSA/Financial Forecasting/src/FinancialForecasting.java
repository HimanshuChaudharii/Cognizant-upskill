public class FinancialForecasting {

    /**
     * Calculates the future value of an investment using standard recursion.
     * Formula: FV = FV(n-1) * (1 + growthRate)
     * Time Complexity: O(n) where n is the number of periods (years/months).
     * Space Complexity: O(n) due to the call stack frames.
     */
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int periods) {
        // Base Case: No more periods to forecast
        if (periods == 0) {
            return presentValue;
        }
        // Recursive Case: Apply growth to the future value of the previous period
        return calculateFutureValueRecursive(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    /**
     * Calculates the future value using an optimized iterative approach.
     * Time Complexity: O(n)
     * Space Complexity: O(1) (eliminates the recursive call stack)
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        double multiplier = 1 + growthRate;
        for (int i = 0; i < periods; i++) {
            futureValue *= multiplier;
        }
        return futureValue;
    }

    /**
     * Calculates the future value using the direct mathematical formula.
     * Time Complexity: O(log n) (implemented using binary exponentiation internally in Math.pow)
     * Space Complexity: O(1)
     */
    public static double calculateFutureValueDirect(double presentValue, double growthRate, int periods) {
        return presentValue * Math.pow(1 + growthRate, periods);
    }
}
