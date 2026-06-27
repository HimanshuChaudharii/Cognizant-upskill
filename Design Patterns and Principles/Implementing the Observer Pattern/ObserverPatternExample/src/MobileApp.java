// Observer contract used by the concrete observers in this example.
interface Observer {
    void update(String stockSymbol, double stockPrice);
}

// Concrete Observer 1: Mobile App
public class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public void update(String stockSymbol, double stockPrice) {
        System.out.println("  [MobileApp - " + appName + "] Push Notification: "
                + stockSymbol + " price is $" + String.format("%.2f", stockPrice));
    }
}
