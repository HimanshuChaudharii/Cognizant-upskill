interface Observer {
    void update(String stockSymbol, double stockPrice);
}

interface Subject {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Subject {
    private final String stockSymbol;
    private double stockPrice;
    private final java.util.List<Observer> observers = new java.util.ArrayList<>();

    StockMarket(String stockSymbol, double stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        System.out.println("Created stock: " + stockSymbol + " at $" + stockPrice);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer registered.");
    }

    @Override
    public void deregisterObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("Observer deregistered.");
        } else {
            System.out.println("Observer not found.");
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }

    void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        System.out.println(stockSymbol + " price updated to $" + stockPrice);
        notifyObservers();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Stock Market Monitor (Observer Design Pattern) ===\n");

        // Create concrete subject (stock)
        StockMarket appleStock = new StockMarket("AAPL", 175.00);
        System.out.println();

        // Create concrete observers
        MobileApp mobileUser1   = new MobileApp("TradePro Mobile");
        MobileApp webDashboard  = new MobileApp("MarketWatch Dashboard");
        MobileApp mobileUser2   = new MobileApp("StockAlert Mobile");

        // --- Scenario 1: Register all three observers ---
        System.out.println("--- Scenario 1: Registering Observers ---");
        appleStock.registerObserver(mobileUser1);
        appleStock.registerObserver(webDashboard);
        appleStock.registerObserver(mobileUser2);
        System.out.println();

        // --- Scenario 2: Price rises — all three observers are notified ---
        System.out.println("--- Scenario 2: Stock Price Rises ---");
        appleStock.setStockPrice(182.50);
        System.out.println();

        // --- Scenario 3: Price falls — all three observers are notified ---
        System.out.println("--- Scenario 3: Stock Price Falls ---");
        appleStock.setStockPrice(178.30);
        System.out.println();

        // --- Scenario 4: Deregister one observer and update again ---
        System.out.println("--- Scenario 4: Deregistering mobileUser2 ---");
        appleStock.deregisterObserver(mobileUser2);
        System.out.println();

        System.out.println("--- Scenario 5: Price Update After Deregistration ---");
        appleStock.setStockPrice(190.00);
        System.out.println();

        // --- Scenario 6: Attempt to deregister an unregistered observer ---
        System.out.println("--- Scenario 6: Deregistering Unregistered Observer ---");
        appleStock.deregisterObserver(mobileUser2);
    }

    private static class MobileApp implements Observer {
        private final String appName;

        private MobileApp(String appName) {
            this.appName = appName;
        }

        @Override
        public void update(String stockSymbol, double stockPrice) {
            System.out.println(appName + " received update: " + stockSymbol + " is now $" + stockPrice);
        }
    }
}
