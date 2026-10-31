import java.util.Scanner;

public class WarehouseBinGrid {

    static void warehouseSummary(int[][] grid) {

        int total = 0;
        int max = grid[0][0];

        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                total = total + grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Total = " + total);
        System.out.println("Maximum = " + max);
        System.out.println("Max Coordinate = (" + maxRow + ", " + maxCol + ")");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int m = sc.nextInt();

        System.out.print("Enter columns: ");
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid elements:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        warehouseSummary(grid);

        sc.close();
    }
}
