import java.util.Scanner;

public class StartPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the no. of side: ");
        // int rows = sc.nextInt();

        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < rows - i; j++) {
        // System.out.print(" ");
        // }

        // for (int k = 0; k < i + 1; k++) {
        // System.out.print("*");
        // }

        // System.out.println();
        // }

        // int ascii = 85;

        // for (int i = 0; i < 6; i++) {
        // for (int j = 0; j < i + 1; j++) {
        // System.out.print((char) ascii);
        // }
        // System.out.println("");
        // ascii++;
        // }

        for (int i = 1; i <= 4; i++) {
            int num = 8;
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num--;
            }
            System.out.println();
        }
    }
}
