public class Logger {
    // Volatile variable guarantees visibility of changes across threads
    private static volatile Logger instance;

    // Private constructor prevents instantiation from other classes
    private Logger() {
        // Safeguard against instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Logger instance already initialized. Use getInstance().");
        }
    }

    /**
     * Public static method to retrieve the single instance of Logger.
     * Implements double-checked locking for thread safety and high performance.
     */
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Logger.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    /**
     * Utility method to log messages.
     */
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
