import java.util.Scanner;

public class LibraryCatalogLookup {

    static String findBook(String[] isbn, String[] titles, String targetIsbn) {

        int low = 0;
        int high = isbn.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (isbn[mid].equals(targetIsbn)) {
                return titles[mid];
            }
            else if (isbn[mid].compareTo(targetIsbn) < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] isbn = {
            "0001112223",
            "0002223334",
            "0003334445",
            "0004445556",
            "0005556667"
        };

        String[] titles = {
            "Introduction to Algebra",
            "Beginning Python",
            "Classic Mythology",
            "Data and Society",
            "European History"
        };

        System.out.print("Enter ISBN to search: ");
        String target = sc.nextLine();

        String result = findBook(isbn, titles, target);

        System.out.println("Book Title: " + result);

        sc.close();
    }
}
