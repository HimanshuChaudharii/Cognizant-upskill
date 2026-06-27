// Concrete Observer 2: Web App
public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double oldPrice, double newPrice) {
        String direction = newPrice > oldPrice ? "UP" : (newPrice < oldPrice ? "DOWN" : "FLAT");
        System.out.println("  [WebApp - " + appName + "] Dashboard Update: "
                + stockSymbol + " " + direction + " $" + String.format("%.2f", newPrice));
    }
}
