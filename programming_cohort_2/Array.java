
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        double[] array = new double[5];

        Scanner sc = new Scanner(System.in);

        int n = array.length;
        int i = 0;
        do {

            System.out.print("Enter the value of the item " + (i + 1) + " : ");

            array[i] = sc.nextDouble();
            i++;

        } while (i < n);

        i = 0;
        while (i < n) {

            System.out.print("You have entered the value at item " + (i + 1) + " : ");

            System.out.println(array[i]);
            i++;

        }

    }

}
