// Proxy Class with Lazy Initialization and Caching
public class ProxyImage {
    private String filename;
    private RealImage cachedImage; // Cache reference — null until first display()

    public ProxyImage(String filename) {
        this.filename = filename;
        // RealImage is NOT created here — lazy initialization defers the
        // expensive server load until the image is actually needed.
        System.out.println("ProxyImage: Proxy created for '" + filename + "' (not yet loaded).");
    }

    public void display() {
        if (cachedImage == null) {
            // First call: load from server and cache the result
            System.out.println("ProxyImage: Cache MISS for '" + filename + "'. Fetching from server...");
            cachedImage = new RealImage(filename);
        } else {
            // Subsequent calls: serve directly from cache
            System.out.println("ProxyImage: Cache HIT for '" + filename + "'. Serving from cache.");
        }
        cachedImage.display();
    }

    // Local implementation to satisfy the proxy example in this single file.
    private static class RealImage {
        private final String filename;

        private RealImage(String filename) {
            this.filename = filename;
            System.out.println("RealImage: Loaded '" + filename + "'.");
        }

        private void display() {
            System.out.println("RealImage: Displaying '" + filename + "'.");
        }
    }
}
