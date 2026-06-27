class Logger {
    private static final Logger INSTANCE = new Logger();

    private Logger() {
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("=== Retrieving Logger Instances ===");
        
        // Retrieve two references of the Logger class
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Perform logging actions using both references
        logger1.log("Transaction initiated by Customer A.");
        logger2.log("Transaction completed successfully for Customer A.");

        System.out.println("\n=== Verifying Singleton Identity ===");
        
        // Print hash codes to show that they point to the exact same instance in memory
        int hash1 = logger1.hashCode();
        int hash2 = logger2.hashCode();
        System.out.println("Logger 1 Memory Hash Code: " + hash1);
        System.out.println("Logger 2 Memory Hash Code: " + hash2);

        // Reference equality check
        if (logger1 == logger2) {
            System.out.println("RESULT: Success. Both references point to the exact same Logger instance.");
        } else {
            System.out.println("RESULT: Failure. Different Logger instances were created.");
        }
    }
}
