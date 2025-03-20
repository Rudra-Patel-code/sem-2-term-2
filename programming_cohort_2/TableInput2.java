
import java.util.Scanner;

public class TableInput2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting no.: ");
        int a = scanner.nextInt();

        System.out.print("Enter the starting no.: ");
        int d = scanner.nextInt();

        int i = a;

        while (i <= d) {
            System.out.println("Table of: " + i);
            System.out.println("----------");
            int j = 0;
            do {
                System.out.println((i) + " * " + (j + 1) + " = " + (i) * (j + 1) + " ");
                j++;
            } while (j < 10);
            System.out.println("\n");
            i++;
        }

    }

}