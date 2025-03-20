
import java.util.Scanner;

public class TableInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting no.: ");
        int a = scanner.nextInt();

        System.out.print("Enter the starting no.: ");
        int d = scanner.nextInt();

        int i = a;

        do {
            System.out.println("Table of: " + i);
            System.out.println("----------");
            for (int j = 0; j < 10; j++) {
                System.out.println((i) + " * " + (j + 1) + " = " + (i) * (j + 1) + " ");
            }
            System.out.println("\n");
            i++;
        } while (i <= d);

    }

}