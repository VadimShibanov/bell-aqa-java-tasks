package Task2;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {5, 7, 9, 2, 1},
                {0, 9, 1, 8, 7},
                {6, 3, 6, 6, 6},
                {99, 100, -2, 3, 1}
        };

        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 7, 9, 2},
                {0, 9, 1, 8},
                {6, 3, 6, 6}
        };

        System.out.println(findMinInMatrix(matrix1));
    }

    public static int findMinInMatrix(int[][] matrix) {
        int n = matrix.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if ((n % 2 != 0) && (i == n / 2)) {
                continue;
            }

            int val = matrix[i][n - 1 - i];
            if (val < min) {
                min = val;
            }
        }

        return min;
    }
}

