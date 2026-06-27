// Invoker Class - Issues commands without knowing the receiver details
public class RemoteControl {
    private Command command;

    // Set the command to be executed
    public void setCommand(Command command) {
        this.command = command;
    }

    // Execute the currently set command
    public void pressButton() {
        if (command == null) {
            System.out.println("Error: No command has been assigned to the remote!");
            return;
        }
        command.execute();
    }
}
