
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the size of the array
        System.out.print("Enter the number of elements: ");

        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Sort the array (binary search requires a sorted array)
        Arrays.sort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));

        // Input the target element to search for
        System.out.print("Enter the element to search: ");

        int target = scanner.nextInt();

        // Perform binary search
        int result = binarySearch(array, target);

        // Output the result
        if (result == -1) {

            System.out.println("Element not found.");

        } else {

            System.out.println("Element found at index: " + result);

        }

        scanner.close();

    }

    public static int binarySearch(int[] array, int target) {

        int left = 0;

        int right = array.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {

                return mid;

            }

            // If the target is greater, ignore the left half
            if (array[mid] < target) {

                left = mid + 1;

            } // If the target is smaller, ignore the right half
            else {

                right = mid - 1;

            }

        }

        // Target is not present in the array
        return -1;

    }

}
