import java.util.Scanner;
import java.util.HashSet;

public class PairWithTargetSum {

    static boolean hasPairWithSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (set.contains(complement)) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter numbers:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        boolean result = hasPairWithSum(nums, target);

        System.out.println(result);

        sc.close();
    }
}
