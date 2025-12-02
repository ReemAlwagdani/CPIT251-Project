/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Scanner;

public class ReportSystem {

   // List of all reports in the system
    private ArrayList<Report> reports = new ArrayList<Report>();

    // Counter to generate the next report ID
    private int nextId = 1;

    
    /**
     * Create a new malfunction report
     * Reads input from the user, creates a Report object, and adds it to the list.
     */
    public void addNewReport(Scanner in) {

        String issue = IssueMenu.chooseIssue(in);
        if (issue == null) {
            System.out.println("Invalid issue choice. Report was not created.");
            return;
        }

        System.out.print("Enter Class number: ");
        String location = in.nextLine();

        System.out.print("Enter your name: ");
        String name = in.nextLine();

        if (location.isEmpty() || name.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        Report r = new Report(nextId++, issue, location ,name);
        reports.add(r);

        System.out.println("Report added successfully with ID: " + r.getId());
    }

    /**
     * View all reports
     * Prints all reports stored in the system.
     */
    public void viewAllReports() {
        if (reports.isEmpty()) {
            System.out.println("No reports yet.");
            return;
        }

        System.out.println("\n--- All Reports ---");
        for (Report r : reports) {
            System.out.println(r.toString());
        }
    }

    /**
     * Update report status
     * This method is intended for IT staff / technicians.
     */
    public void updateReportStatus(Scanner in) {
        System.out.print("Enter report ID to update: ");
        int id = in.nextInt();
        in.nextLine(); 

        Report found = findReportById(id);

        if (found == null) {
            System.out.println("Report not found.");
            return;
        }

        System.out.println("Current status: " + found.getStatus());
        System.out.println("Choose new status:");
        System.out.println("1. NEW");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. RESOLVED");
        System.out.print("Enter choice: ");
        int s = in.nextInt();
        in.nextLine(); 

        if (s == 1) {
            found.setStatus("NEW");
        } else if (s == 2) {
            found.setStatus("IN_PROGRESS");
        } else if (s == 3) {
            found.setStatus("RESOLVED");
        } else {
            System.out.println("Invalid status choice.");
            return;
        }

        System.out.println("Status updated successfully.");
    }

    /**
     * Allow user to check the status of a specific report by ID.
     * This is mainly used by Reporters to track their reports.
     */
    public void viewReportStatusById(Scanner in) {
        System.out.print("Enter report ID: ");
        int id = in.nextInt();
        in.nextLine(); 

        Report found = findReportById(id);

        if (found == null) {
            System.out.println("Report not found.");
        } else {
            System.out.println("\nReport ID: " + found.getId());
            System.out.println("Issue: " + found.getIssue());
            System.out.println("Location: " + found.getLocation());
            System.out.println("Submitted by: " + found.getSubmittedBy());
            System.out.println("Current status: " + found.getStatus());
        }
    }

    
    public Report findReportById(int id) {
        for (Report r : reports) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    /**
     * Show basic statistics.
     * Shows total, open, and resolved reports.
     */
    public void showStats() {
        int total = reports.size();
        int open = 0;

        for (Report r : reports) {
            String st = r.getStatus();
            if (st.equals("NEW") || st.equals("IN_PROGRESS")) {
                open++;
            }
        }

        int resolved = total - open;

        System.out.println("\n--- Statistics ---");
        System.out.println("Total reports: " + total);
        System.out.println("Open reports: " + open);
        System.out.println("Resolved reports: " + resolved);
    }
    public ArrayList<Report> getReports() {
    return reports;
}

}