
/**
 *
 * @author Hanmo
 */


import java.util.Scanner;
public class IssueMenu {
 
    /**
     * Show a predefined list of issues and return the selected issue text.
     * Returns null if the user enters an invalid number.
     */
    public static String chooseIssue(Scanner in) {
        System.out.println("\nSelect the issue:");
        System.out.println("1. Projector - No signal");
        System.out.println("2. Projector - Lamp problem");
        System.out.println("3. PC - Not turning on");
        System.out.println("4. PC - Very slow");
        System.out.println("5. Network - No internet");
        System.out.print("Enter issue number: ");

        int issueChoice = in.nextInt();
        in.nextLine(); 

        switch (issueChoice) {
            case 1:
                return "Projector - No signal";
            case 2:
                return "Projector - Lamp problem";
            case 3:
                return "PC - Not turning on";
            case 4:
                return "PC - Very slow";
            case 5:
                return "Network - No internet";
            default:
                return null;
        }
    }
    
}


