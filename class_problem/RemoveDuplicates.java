import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicates {

    static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int j = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int length = removeDuplicates(nums);

        System.out.println("Length = " + length);

        System.out.print("Unique elements: ");

        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}
