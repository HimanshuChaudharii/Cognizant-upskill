public class Main {
    interface Image {
        void display();
    }

    static class ProxyImage implements Image {
        private String filename;
        private RealImage realImage;

        public ProxyImage(String filename) {
            this.filename = filename;
        }

        @Override
        public void display() {
            if (realImage == null) {
                realImage = new RealImage(filename);
            }
            realImage.display();
        }
    }

    static class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("  [Loading " + filename + " from server...]");
        }

        @Override
        public void display() {
            System.out.println("  [Displaying " + filename + "]");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Image Viewer Application (Proxy Design Pattern) ===\n");

        // Create proxies — no server loading happens yet (lazy initialization)
        System.out.println("--- Initializing Image Proxies ---");
        Image banner   = new ProxyImage("banner.png");
        Image logo     = new ProxyImage("logo.png");
        System.out.println();

        // ----- Scenario 1: First display (cache MISS -> loads from server) -----
        System.out.println("--- Scenario 1: First display of banner.png ---");
        banner.display();
        System.out.println();

        // ----- Scenario 2: Second display of same image (cache HIT) -----
        System.out.println("--- Scenario 2: Second display of banner.png (should use cache) ---");
        banner.display();
        System.out.println();

        // ----- Scenario 3: First display of a different image -----
        System.out.println("--- Scenario 3: First display of logo.png ---");
        logo.display();
        System.out.println();

        // ----- Scenario 4: Third call on banner (still using cache) -----
        System.out.println("--- Scenario 4: Third display of banner.png (should still use cache) ---");
        banner.display();
        System.out.println();

        // ----- Scenario 5: thumbnail was never displayed — proxy only -----
        System.out.println("--- Scenario 5: thumbnail.jpg was never displayed ---");
        System.out.println("No display() was called on thumbnail — server was never contacted.");
    }
}
