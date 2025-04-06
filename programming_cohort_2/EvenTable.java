
import java.util.Scanner;

public class EvenTable {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the starting number: ");
        int start = sc.nextInt();

        System.out.print("Enter the ending number: ");
        int end = sc.nextInt();

        int i = start;
        while (i < end + 1) {

            if (i % 2 == 0) {
                System.out.println("Table of " + i);
                System.out.println("-------------");

                int j = 0;
                do {
                    System.out.println(i + " * " + (j + 1) + " = " + (i * (j + 1)));
                    j++;
                } while (j < 10);

                System.out.println("\n\n");

            }

            i++;
        }

        // for (int i = start; i < end + 1; i++) {

        // if (i % 2 == 0) {
        // System.out.println("Table of " + i);
        // System.out.println("-------------");

        // for (int j = 0; j < 10; j++) {
        // System.out.println(i + " * " + (j + 1) + " = " + (i * (j + 1)));
        // }

        // System.out.println("\n\n1");

        // }
        // }

    }
}

/*
 * for
 * for(int i = 0; i < 10; i++){
 * }
 * do while
 * while
 * 
 */