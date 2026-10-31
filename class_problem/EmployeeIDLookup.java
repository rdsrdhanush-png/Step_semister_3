import java.util.Scanner;
import java.util.HashMap;

public class EmployeeIDLookup {

    static HashMap<String, String> buildLookup(
            String[] ids, String[] departments) {

        HashMap<String, String> lookup = new HashMap<>();

        for (int i = 0; i < ids.length; i++) {
            lookup.put(ids[i], departments[i]);
        }

        return lookup;
    }

    static String getDepartment(
            HashMap<String, String> lookup, String employeeId) {

        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        String[] ids = new String[n];
        String[] departments = new String[n];

        System.out.println("Enter employee ID and department:");

        for (int i = 0; i < n; i++) {
            ids[i] = sc.next();
            departments[i] = sc.next();
        }

        HashMap<String, String> lookup =
                buildLookup(ids, departments);

        System.out.print("Enter employee ID to search: ");
        String searchId = sc.next();

        String result = getDepartment(lookup, searchId);

        System.out.println("Department: " + result);

        sc.close();
    }
}
