// Subject Interface
public interface Stock {
    void registerObserver(java.util.Observer observer);
    void deregisterObserver(java.util.Observer observer);
    void notifyObservers();
}
