public class Main {
    public static void main(String[] args) {
        System.out.println("=== Computer Factory (Builder Design Pattern) ===\n");

        // 1. Basic Office Computer (only required parts and OS)
        System.out.println("--- Configuration 1: Basic Office PC ---");
        Computer officePC = new Computer.Builder("Intel Core i3", "8GB DDR4", "256GB SSD")
                .setOS("Windows 11 Home")
                .build();
        System.out.println(officePC);
        System.out.println();

        // 2. High-end Gaming Computer (all optional parts specified)
        System.out.println("--- Configuration 2: High-end Gaming PC ---");
        Computer gamingPC = new Computer.Builder("AMD Ryzen 7 7800X3D", "32GB DDR5", "2TB NVMe SSD")
                .setGPU("NVIDIA GeForce RTX 4080 Super")
                .setOS("Windows 11 Pro")
                .setWiFiEnabled(true)
                .setBluetoothEnabled(true)
                .build();
        System.out.println(gamingPC);
        System.out.println();

        // 3. Server Configuration (no GPU, massive RAM/Storage, Linux OS)
        System.out.println("--- Configuration 3: High-capacity Server ---");
        Computer server = new Computer.Builder("Dual Intel Xeon Platinum", "256GB ECC RAM", "10TB RAID SSD")
                .setOS("Ubuntu Server 24.04 LTS")
                .setWiFiEnabled(false) // Servers typically use wired connections
                .setBluetoothEnabled(false)
                .build();
        System.out.println(server);
    }
}

class Computer {
        private final String cpu;
        private final String ram;
        private final String storage;
        private final String gpu;
        private final String os;
        private final boolean wiFiEnabled;
        private final boolean bluetoothEnabled;

        private Computer(Builder builder) {
                this.cpu = builder.cpu;
                this.ram = builder.ram;
                this.storage = builder.storage;
                this.gpu = builder.gpu;
                this.os = builder.os;
                this.wiFiEnabled = builder.wiFiEnabled;
                this.bluetoothEnabled = builder.bluetoothEnabled;
        }

        @Override
        public String toString() {
                return "Computer{" +
                                "cpu='" + cpu + '\'' +
                                ", ram='" + ram + '\'' +
                                ", storage='" + storage + '\'' +
                                ", gpu='" + gpu + '\'' +
                                ", os='" + os + '\'' +
                                ", wiFiEnabled=" + wiFiEnabled +
                                ", bluetoothEnabled=" + bluetoothEnabled +
                                '}';
        }

        static class Builder {
                private final String cpu;
                private final String ram;
                private final String storage;
                private String gpu = "Integrated Graphics";
                private String os = "No OS Installed";
                private boolean wiFiEnabled = false;
                private boolean bluetoothEnabled = false;

                Builder(String cpu, String ram, String storage) {
                        this.cpu = cpu;
                        this.ram = ram;
                        this.storage = storage;
                }

                Builder setGPU(String gpu) {
                        this.gpu = gpu;
                        return this;
                }

                Builder setOS(String os) {
                        this.os = os;
                        return this;
                }

                Builder setWiFiEnabled(boolean wiFiEnabled) {
                        this.wiFiEnabled = wiFiEnabled;
                        return this;
                }

                Builder setBluetoothEnabled(boolean bluetoothEnabled) {
                        this.bluetoothEnabled = bluetoothEnabled;
                        return this;
                }

                Computer build() {
                        return new Computer(this);
                }
        }
}
