// Command Interface
interface Command {
    void execute();
}

// Concrete Command - Turn Light On
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

// Concrete Command - Turn Light Off
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

// Invoker - Remote Control that issues commands
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test Class - Demonstrates issuing commands using the RemoteControl
public class CommandPatternTest {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern - Home Automation Demo ===\n");

        // Create Receiver objects (devices)
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create Concrete Command objects
        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn = new LightOnCommand(kitchenLight);
        Command kitchenOff = new LightOffCommand(kitchenLight);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        // Issue commands via the remote control
        System.out.println("--- Living Room Light ---");
        remote.setCommand(livingRoomOn);
        remote.pressButton();

        remote.setCommand(livingRoomOff);
        remote.pressButton();

        System.out.println();

        System.out.println("--- Kitchen Light ---");
        remote.setCommand(kitchenOn);
        remote.pressButton();

        remote.setCommand(kitchenOff);
        remote.pressButton();

        System.out.println();

        // Demonstrate reusing the same command
        System.out.println("--- Turning Living Room Light back ON ---");
        remote.setCommand(livingRoomOn);
        remote.pressButton();

        System.out.println("\n=== Demo Complete ===");
    }
}

// Receiver - Represents a light that can be turned on or off
class Light {
    private final String location;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " light is ON");
    }

    public void off() {
        System.out.println(location + " light is OFF");
    }
}
