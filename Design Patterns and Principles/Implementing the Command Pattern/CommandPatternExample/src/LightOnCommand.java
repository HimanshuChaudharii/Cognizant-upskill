interface Command {
    void execute();
}

// Receiver
class Light {
    public void on() {
        System.out.println("Light is ON");
    }
}

// Concrete Command - Turns the light ON
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
