import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalendarApp {
    private static Map<LocalDate, String> events = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create event");
            System.out.println("2. Update event");
            System.out.println("3. Delete event");
            System.out.println("4. View calendar");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createEvent(scanner);
                    break;
                case 2:
                    updateEvent(scanner);
                    break;
                case 3:
                    deleteEvent(scanner);
                    break;
                case 4:
                    viewCalendar();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createEvent(Scanner scanner) {
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.print("Enter the event description: ");
        String description = scanner.nextLine();

        events.put(date, description);
        System.out.println("Event created successfully!");
    }

    private static void updateEvent(Scanner scanner) {
        System.out.print("Enter the date (YYYY-MM-DD) of the event you want to update: ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        if (events.containsKey(date)) {
            System.out.print("Enter the new event description: ");
            String description = scanner.nextLine();

            events.put(date, description);
            System.out.println("Event updated successfully!");
        } else {
            System.out.println("No event found for the specified date.");
        }
    }

    private static void deleteEvent(Scanner scanner) {
        System.out.print("Enter the date (YYYY-MM-DD) of the event you want to delete: ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        if (events.containsKey(date)) {
            events.remove(date);
            System.out.println("Event deleted successfully!");
        } else {
            System.out.println("No event found for the specified date.");
        }
    }

    private static void viewCalendar() {
        System.out.println("Calendar:");
        for (LocalDate date : events.keySet()) {
            String description = events.get(date);
            System.out.println(date + ": " + description);
        }
    }
}
