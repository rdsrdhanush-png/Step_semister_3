import java.util.Scanner;
import java.util.Arrays;

public class PrizeTable {

    static int prizeTable(int[] marks) {

        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {

            int max = i;

            for (int j = i + 1; j < n; j++) {

                if (marks[j] > marks[max]) {
                    max = j;
                }
            }

            if (max != i) {

                int temp = marks[i];
                marks[i] = marks[max];
                marks[max] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        System.out.println("Enter marks:");

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        int swaps = prizeTable(marks);

        System.out.println("Sorted marks: " + Arrays.toString(marks));
        System.out.println("Swaps = " + swaps);

        sc.close();
    }
}
