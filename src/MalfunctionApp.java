
/**
 *
 * @author yareen
 */
import java.util.Scanner;
public class MalfunctionApp {

    public static void main(String[] args) {
          System.out.println("\t\tWelcome to Malfunction Report System!\n"
                + "\t_______________________________________________\n");

        Scanner input = new Scanner(System.in);
        ReportSystem system = new ReportSystem();

        int role = 0;

        //role menu 
        while (true) {

            System.out.println("\nSelect your role:");
            System.out.println("1. Reporter (student / instructor)");
            System.out.println("2. IT staff / technician");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            role = input.nextInt();
            input.nextLine(); 

            if (role == 1) {
                // Run menu for Reporter
                runUserMenu(input, system);

            } else if (role == 2) {
                // Run menu for IT staff
                runITMenu(input, system);

            } else if (role == 3) {
                // Exit the whole system
                break;

            } else {
                System.out.println("Invalid role. Please try again.");
            }
        }

        System.out.println("\nThank you for using Malfunction Report System.");
        input.close();
    }

    /**
     * Menu for Reporter
     * Users can:
     * 1) Add a new report
     * 2) View the status of a specific report
     */
    private static void runUserMenu(Scanner input, ReportSystem system) {
        int choice = 0;
        String anotherService = "";

        while (!anotherService.equalsIgnoreCase("no") && choice != 3) {

            printUserMenu();
            choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1) {
                system.addNewReport(input);          // Add a new report
            } else if (choice == 2) {
                system.viewReportStatusById(input);  // View report status by ID
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Please enter a correct number.");
            }

            if (choice != 3) { 
                System.out.println("_______________________________________________"
                        + "\n\nWould you like to use another user service? (yes/no)");
                anotherService = input.next();
            }
        }

        System.out.println("\nThank you for using Malfunction Report System!");
        System.out.println("_______________________________________________");
        System.out.println("");
        System.out.println("");
        System.out.println("\t\tWelcome to Malfunction Report System!\n"
                + "\t_______________________________________________\n");
    }

    /**
     * Menu for IT staff.
     * IT staff can:
     * 1) View all reports
     * 2) Update report status
     * 3) Show statistics
     */
    private static void runITMenu(Scanner input, ReportSystem system) {
        int choice = 0;
        String anotherService = "";

        while (!anotherService.equalsIgnoreCase("no") && choice != 4) {

            printITMenu();
            choice = input.nextInt();
            input.nextLine(); 

            if (choice == 1) {
                system.viewAllReports();          // View all reports
            } else if (choice == 2) {
                system.updateReportStatus(input); // Update report status
            } else if (choice == 3) {
                system.showStats();               // Show statistics
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Please enter a correct number.");
            }

            if (choice != 4) { 
                System.out.println("_______________________________________________"
                        + "\n\nWould you like to do another IT action? (yes/no)");
                anotherService = input.next();
            }
        }

        System.out.println("\nThank you for using Malfunction Report System!");
        System.out.println("_______________________________________________");
        System.out.println("");
        System.out.println("");
        System.out.println("\t\tWelcome to Malfunction Report System!\n"
                + "\t_______________________________________________\n");
    }

    // Print Reporter menu options
    private static void printUserMenu() {
        System.out.print("\n=== User Menu ===\n"
                + "press 1: to add a new malfunction report\n"
                + "press 2: to view the status of a report\n"
                + "press 3: to exit user menu\n"
                + "_______________________________________________\n"
                + "your choice is: ");
    }

    // Print IT staff menu options
    private static void printITMenu() {
        System.out.print("\n=== IT Staff Menu ===\n"
                + "press 1: to view all reports\n"
                + "press 2: to update report status\n"
                + "press 3: to show reports statistics\n"
                + "press 4: to exit IT menu\n"
                + "_______________________________________________\n"
                + "your choice is: ");
    }
}


