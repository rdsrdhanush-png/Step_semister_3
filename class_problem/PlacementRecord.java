class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    // Constructor
    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Method to print the record
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating PlacementRecord objects
        PlacementRecord r1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord r2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord r3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Storing objects in an array
        PlacementRecord[] records = {r1, r2, r3};

        // Printing each record
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}
