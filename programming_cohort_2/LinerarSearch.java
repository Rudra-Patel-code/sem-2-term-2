
import java.util.Scanner;

public class LinerarSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = { 1, 2, 4, 5, 6, 7, 8, 9, 10 };

        System.out.println("Enter the number to search: ");
        int target = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index: " + i);
                return;
            }

            if (i == arr.length - 1) {
                System.out.println("Number not found in the array.");
            }

        }

        scanner.close();
    }
}