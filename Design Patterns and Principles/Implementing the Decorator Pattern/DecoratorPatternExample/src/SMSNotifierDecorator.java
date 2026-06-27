// Concrete Decorator: SMS
public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Call the wrapped object's method
        sendSMS(message);    // Add new behavior
    }

    private void sendSMS(String message) {
        System.out.println("SMS: Sending -> " + message);
    }
}
