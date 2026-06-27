public class Computer {
    // Product attributes
    private String CPU;
    private String RAM;
    private String Storage;
    private String GPU;
    private String OS;
    private boolean isWiFiEnabled;
    private boolean isBluetoothEnabled;

    // Private constructor that takes the Builder as a parameter
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
        this.isWiFiEnabled = builder.isWiFiEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters (no setters are provided to ensure immutability)
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return Storage; }
    public String getGPU() { return GPU; }
    public String getOS() { return OS; }
    public boolean isWiFiEnabled() { return isWiFiEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computer Configuration:\n");
        sb.append("  - CPU: ").append(CPU != null ? CPU : "Not Specified").append("\n");
        sb.append("  - RAM: ").append(RAM != null ? RAM : "Not Specified").append("\n");
        sb.append("  - Storage: ").append(Storage != null ? Storage : "Not Specified").append("\n");
        sb.append("  - GPU: ").append(GPU != null ? GPU : "Integrated Graphics").append("\n");
        sb.append("  - OS: ").append(OS != null ? OS : "None").append("\n");
        sb.append("  - WiFi: ").append(isWiFiEnabled ? "Enabled" : "Disabled").append("\n");
        sb.append("  - Bluetooth: ").append(isBluetoothEnabled ? "Enabled" : "Disabled");
        return sb.toString();
    }

    // Static nested Builder class
    public static class Builder {
        // Builder attributes (mirroring Product attributes)
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;
        private String OS;
        private boolean isWiFiEnabled;
        private boolean isBluetoothEnabled;

        // Builder constructor with required parameters to enforce core attributes
        public Builder(String CPU, String RAM, String Storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.Storage = Storage;
        }

        // Methods to set optional attributes returning Builder for method chaining
        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        public Builder setWiFiEnabled(boolean isWiFiEnabled) {
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // The build method that instantiates and returns the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}
