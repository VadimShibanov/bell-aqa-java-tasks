package Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк (n): ");
        int n = scanner.nextInt();

        System.out.print("Введите количество столбцов (m): ");
        int m = scanner.nextInt();

        int frames = Math.min(n, m) / 2;

        System.out.println("\nРезультат:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minDist = Math.min(Math.min(i, n - 1 - i), Math.min(j, m - 1 - j));

                int value = (frames - 1) - minDist;

                System.out.print(value + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}


