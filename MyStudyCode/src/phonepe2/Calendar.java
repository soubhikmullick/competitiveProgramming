package phonepe2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
Design a calendar service that can create events for users.

Mandatory Requirements:

Users can enter their shift timings (working hours) or create busy slots. It’s possible for users to have more than
one shift in a day.
Users can fetch events of themselves and other users.
Users can create events with other users for a defined start time and end time and delete events created by themselves.
Organizer of an event can fetch the most favorable upcoming empty slot for a given set of users and a particular
duration.
For instance user A would like to check the favorable slot with user B, user C to set an event of 4 hours duration.
This would require user A to check the upcoming events in his/her calendar as well as for user B, user C.
Users can fetch events where they have conflicts for themselves for a particular day.
Bonus Extensions:

Organizers can have the capability to create recurring events in future for a specific number of times. Recurring
events will have the exact same start and end time of day with the same set of users.
 */
public class Calendar {
    private static User createUser(Scanner scanner, CalendarService calendarService) {
        String userId, username;
        while (true) {
            System.out.print("Enter User ID: ");
            userId = scanner.nextLine();
            if (calendarService.getUserById(userId) == null) {
                break; // Unique ID, break out of the loop
            } else {
                System.out.println("User with ID '" + userId + "' already exists. Please enter a different User ID.");
            }
        }

        System.out.print("Enter Username: ");
        username = scanner.nextLine();
        return new User(userId, username);
    }

    private static void setShiftsAndBusySlots(Scanner scanner, User user) {
        System.out.println("Enter shift timings (working hours) in the format 'HH:mm - HH:mm' or 'done' to stop adding shifts:");
        while (true) {
            String shift = scanner.nextLine();
            if (shift.equalsIgnoreCase("done")) {
                break;
            }

            // Validate the input format for shift timings
            if (shift.matches("\\d{2}:\\d{2}\\s*-\\s*\\d{2}:\\d{2}")) {
                user.addShiftTiming(shift);
            } else {
                System.out.println("Invalid format. Shift timing should be in the format 'HH:mm - HH:mm'.");
            }
        }

        System.out.println("Enter busy slots in the format 'yyyy-MM-dd HH:mm - HH:mm' or 'done' to stop adding busy slots:");
        while (true) {
            String busySlot = scanner.nextLine();
            if (busySlot.equalsIgnoreCase("done")) {
                break;
            }

            // Validate the input format for busy slots
            if (busySlot.matches("\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}\\s*-\\s*\\d{2}:\\d{2}")) {
                user.addBusySlot(busySlot);
            } else {
                System.out.println("Invalid format. Busy slot should be in the format 'yyyy-MM-dd HH:mm - HH:mm'.");
            }
        }
    }
    private static Event createEvent(Scanner scanner) {
        System.out.print("Enter Event ID: ");
        String eventId = scanner.nextLine();
        System.out.print("Enter Organizer ID: ");
        String organizerId = scanner.nextLine();
        System.out.print("Enter Participant IDs (comma-separated): ");
        String participantsInput = scanner.nextLine();
        List<String> participantIds = Arrays.asList(participantsInput.split(","));

        System.out.print("Enter Start Time (yyyy-MM-dd HH:mm): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter End Time (yyyy-MM-dd HH:mm): ");
        String endTime = scanner.nextLine();

        return new Event(eventId, organizerId, participantIds, startTime, endTime);
    }
    public static void main(String[] args) {
        CalendarService calendarService = new CalendarService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calendar Chatbot!");
        System.out.println("What would you like to do?");
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Add User\n2. Set User Shifts and Busy Slots\n3. Create Event\n4. Delete Event");
            System.out.println("5. View Events\n6. View Conflicting Events\n7. View Upcoming Empty Slots\n8. Exit");
            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character after reading the integer input

            switch (choice) {
                case 1:
                    System.out.println("\nEnter user details:");
                    User newUser = createUser(scanner,calendarService);
                    calendarService.addUser(newUser);
                    System.out.println("User added successfully!");
                    break;
                case 2:
                    System.out.print("\nEnter user ID to set shifts and busy slots: ");
                    String userId = scanner.nextLine();
                    User user = calendarService.getUserById(userId);
                    if (user == null) {
                        System.out.println("User not found. Please add the user first.");
                    } else {
                        setShiftsAndBusySlots(scanner, user);
                        System.out.println("Shifts and busy slots updated successfully for User ID: " + userId);
                    }
                    break;
                case 3:
                    System.out.println("\nEnter event details:");
                    Event newEvent = createEvent(scanner);
                    calendarService.createEvent(newEvent);
                    System.out.println("Event created successfully!");
                    break;
                case 4:
                    System.out.print("\nEnter event ID to delete: ");
                    String eventId = scanner.nextLine();
                    System.out.print("Enter your user ID as the organizer of the event: ");
                    String organizerId = scanner.nextLine();
                    calendarService.deleteEvent(eventId, organizerId);
                    System.out.println("Event deleted successfully!");
                    break;
                case 5:
                    System.out.print("\nEnter user ID to view events: ");
                    userId = scanner.nextLine();
                    List<Event> userEvents = calendarService.getEventsForUser(userId);
                    System.out.println("Events for User ID: " + userId);
                    for (Event event : userEvents) {
                        System.out.println(event.getEventId() + ": " + event.getStartTime() + " - " + event.getEndTime());
                    }
                    break;
                case 6:
                    System.out.print("\nEnter user ID to view conflicting events: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter a date to check for conflicting events (yyyy-MM-dd): ");
                    String date = scanner.nextLine();
                    List<Event> conflictingEvents = calendarService.getConflictingEventsForUser(userId, date);
                    System.out.println("Conflicting Events for User ID: " + userId + " on " + date);
                    for (Event event : conflictingEvents) {
                        System.out.println(event.getEventId() + ": " + event.getStartTime() + " - " + event.getEndTime());
                    }
                    break;
                case 7:
                    System.out.print("\nEnter a date to check for upcoming empty slots (yyyy-MM-dd): ");
                    date = scanner.nextLine();
                    System.out.print("Enter the duration (in hours) for the event: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume the remaining newline character after reading the integer input

                    System.out.print("Enter comma-separated User IDs to check for upcoming empty slots: ");
                    String inputUserIds = scanner.nextLine();
                    List<String> userIds = Arrays.asList(inputUserIds.split(","));

                    List<Event> emptySlots = calendarService.getUpcomingEmptySlot(userIds, date, duration);
                    System.out.println("Upcoming Empty Slots on " + date + " for " + duration + " hours:");
                    for (Event emptySlot : emptySlots) {
                        System.out.println(emptySlot.getOrganizerId() + ": " + emptySlot.getStartTime() + " - " + emptySlot.getEndTime());
                    }
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option (1-8).");
            }

        }
        System.out.println("Thank you for using the Calendar Chatbot. Goodbye!");
    }

}
