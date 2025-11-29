import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author LENOVO
 */
public class ReportSystemTest {
    
     @Test
    public void testAddNewReport() {

        ReportSystem system = new ReportSystem();

        // simulate user input:
        // issue = option 1
        // location = C12
        // name = Reem
        String fakeInput = "1\nC12\nReem\n";
        Scanner scan = new Scanner(fakeInput);

        system.addNewReport(scan);

        
        assertEquals(1, system.getReports().size());

        Report r = system.getReports().get(0);

        assertEquals(1, r.getId());
        assertEquals("Projector - No signal", r.getIssue());
        assertEquals("C12", r.getLocation());
        assertEquals("Reem", r.getSubmittedBy());
        assertEquals("NEW", r.getStatus());
    }

    @Test
    public void testFindReportById() {

        ReportSystem system = new ReportSystem();

        // manually add reports
        system.getReports().add(new Report(1, "PC", "C11", "Sara"));
        system.getReports().add(new Report(2, "Network", "C15", "Reem"));

        Report found = system.findReportById(2);

        assertNotNull(found);
        assertEquals("Reem", found.getSubmittedBy());
    }

    @Test
    public void testUpdateReportStatus() {

        ReportSystem system = new ReportSystem();

        // add one report
        system.getReports().add(new Report(1, "PC", "C12", "Reem"));

        // simulate user input:
        // id = 1
        // choose status = 3 → RESOLVED
        String input = "1\n3\n";
        Scanner scan = new Scanner(input);

        system.updateReportStatus(scan);

        Report r = system.getReports().get(0);

        assertEquals("RESOLVED", r.getStatus());
    }

    @Test
    public void testStats() {

        ReportSystem system = new ReportSystem();

        system.getReports().add(new Report(1, "PC", "A10", "Sara"));  // NEW
        system.getReports().add(new Report(2, "Network", "B12", "Reem")); // NEW
        Report r = new Report(3, "Projector", "C22", "Huda");
        r.setStatus("RESOLVED");

        system.getReports().add(r);

        // We test numbers:
        assertEquals(3, system.getReports().size());
    }
    
    
}
