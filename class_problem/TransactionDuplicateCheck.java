import java.util.Scanner;
import java.util.HashSet;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < transactionIds.length; i++) {

            if (set.contains(transactionIds[i])) {
                return true;
            }

            set.add(transactionIds[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        String[] ids = new String[n];

        System.out.println("Enter transaction IDs:");

        for (int i = 0; i < n; i++) {
            ids[i] = sc.next();
        }

        boolean result = hasDuplicate(ids);

        System.out.println(result);

        sc.close();
    }
}
