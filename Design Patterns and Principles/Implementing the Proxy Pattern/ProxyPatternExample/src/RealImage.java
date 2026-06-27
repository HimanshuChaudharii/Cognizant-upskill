interface Image {
    void display();
}

// Real Subject Class
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer(); // Heavy operation during construction
    }

    // Simulates expensive network call to fetch image from a remote server
    private void loadFromServer() {
        System.out.println("RealImage: Loading '" + filename + "' from remote server...");
        try {
            Thread.sleep(500); // Simulates network latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("RealImage: '" + filename + "' successfully loaded.");
    }

    @Override
    public void display() {
        System.out.println("RealImage: Displaying '" + filename + "'.");
    }
}
