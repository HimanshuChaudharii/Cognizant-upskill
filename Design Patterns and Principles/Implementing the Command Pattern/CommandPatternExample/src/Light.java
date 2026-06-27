// Receiver Class - The actual device that performs the work
public class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " Light is ON");
    }

    public void turnOff() {
        System.out.println(location + " Light is OFF");
    }
}
