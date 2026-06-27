// Concrete Decorator: Slack
public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the wrapped object's method
        sendSlack(message);  // Add new behavior
    }

    private void sendSlack(String message) {
        System.out.println("Slack: Sending -> " + message);
    }
}
