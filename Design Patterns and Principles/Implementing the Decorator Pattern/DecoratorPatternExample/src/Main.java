public class Main {
    public static void main(String[] args) {
        System.out.println("=== Alert Notification Center (Decorator Design Pattern) ===\n");

        // 1. Sending notification via Email only (base component)
        System.out.println("--- Scenario 1: Standard Notification (Email Only) ---");
        Notifier standardNotifier = new EmailNotifier();
        standardNotifier.send("System maintenance scheduled at 12:00 AM.");
        
        System.out.println();

        // 2. Sending notification via Email and SMS (Email decorated with SMS)
        System.out.println("--- Scenario 2: Urgent Notification (Email + SMS) ---");
        Notifier urgentNotifier = new SMSNotifierDecorator(new EmailNotifier());
        urgentNotifier.send("High memory utilization alert: 92% exceeded.");

        System.out.println();

        // 3. Sending notification via Email, SMS, and Slack (Fully decorated)
        System.out.println("--- Scenario 3: Critical Notification (Email + SMS + Slack) ---");
        Notifier criticalNotifier = new SlackNotifierDecorator(
                                        new SMSNotifierDecorator(
                                            new EmailNotifier()
                                        )
                                    );
        criticalNotifier.send("Database connection lost. Immediate intervention required.");
    }
}
