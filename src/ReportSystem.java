/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jansb
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ReportSystem {

    
    private ArrayList<Report> reports = new ArrayList<>();

    private int nextId = 1;

   
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


}