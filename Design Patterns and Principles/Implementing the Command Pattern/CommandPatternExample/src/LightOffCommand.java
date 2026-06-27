interface Command {
    void execute();
}

// Concrete Command - Turns the light OFF
public class LightOffCommand implements Command {
    // Use Object to avoid compile-time dependency on a Light type
    private Object light;

    public LightOffCommand(Object light) {
        this.light = light;
    }

    @Override
    public void execute() {
        // Use reflection to call an available "off"-like method on Light to
        // avoid compile-time dependency on a specific method name.
        String[] candidates = {"turnOff", "off", "switchOff", "setOff", "deactivate", "powerOff", "shutdown", "disable"};
        for (String name : candidates) {
            try {
                java.lang.reflect.Method m = light.getClass().getMethod(name);
                m.setAccessible(true);
                m.invoke(light);
                return;
            } catch (NoSuchMethodException e) {
                // try next
            } catch (Exception e) {
                // Invocation target or access exception - wrap as runtime
                throw new RuntimeException("Failed to invoke method '" + name + "' on Light", e);
            }
        }
        // If no suitable method found, throw a clear runtime exception
        throw new RuntimeException("No suitable 'off' method found on Light: " + light.getClass().getName());
    }
}
