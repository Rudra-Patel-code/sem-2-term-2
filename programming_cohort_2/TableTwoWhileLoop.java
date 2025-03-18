import java.util.Scanner;

public class TableTwoWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        System.out.println("Enter the starting range");
        int start = scanner.nextInt();

        System.out.println("Enter the ending range");
        int end = scanner.nextInt();

        int i = start;

        do {
            System.out.println(n + " * " + i + " = " + (n * i));
            i += start <= end ? 1 : -1;
        } while (start <= end ? i <= end : i >= end);
    }
}
