import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockSymbol, double stockPrice);
}

// Concrete Subject
public class StockMarket {
    private List<Observer> observers = new ArrayList<>();
    private String stockSymbol;
    private double stockPrice;

    public StockMarket(String stockSymbol, double initialPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = initialPrice;
        System.out.println("StockMarket: '" + stockSymbol + "' initialized at $" + String.format("%.2f", initialPrice));
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("StockMarket: Observer registered for '" + stockSymbol + "'. Total observers: " + observers.size());
    }

    public void deregisterObserver(Observer observer) {
        boolean removed = observers.remove(observer);
        if (removed) {
            System.out.println("StockMarket: Observer deregistered from '" + stockSymbol + "'. Total observers: " + observers.size());
        } else {
            System.out.println("StockMarket: Observer not found for '" + stockSymbol + "'.");
        }
    }

    public void notifyObservers() {
        // Push model — subject sends old and new price to all registered observers
        for (Observer observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }

    // Triggers a price update and fans out a notification to all observers
    public void setStockPrice(double newPrice) {
        double oldPrice = this.stockPrice;
        this.stockPrice = newPrice;
        System.out.println("\nStockMarket: '" + stockSymbol + "' price changed: $"
                + String.format("%.2f", oldPrice) + " -> $" + String.format("%.2f", newPrice));
        notifyObservers();
    }

    public double getStockPrice() {
        return stockPrice;
    }
}
