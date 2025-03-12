import java.util.Scanner;

public class Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        System.out.println("Enter the starting range");
        int start = scanner.nextInt();

        System.out.println("Enter the ending range");
        int end = scanner.nextInt();

        for (int i = start; start <= end ? i <= end : i >= end; i += start <= end ? 1 : -1) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}
