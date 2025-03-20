
import java.util.Scanner;

public class Table2 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter table no : ");
        int tableno = sc.nextInt();
        System.out.println("Please enter start range : ");
        int startRange = sc.nextInt();
        System.out.println("Please enter end range : ");
        int endRange = sc.nextInt();

        System.out.println("Please enter 'a' for acsending or 'd' for descending : ");

        char c = sc.next().charAt(0);

        if (c == 'd') {
            int i = endRange;
            do {
                if (i != 15) {

                    System.out.println(tableno + " * " + i + " = " + tableno * i);
                }
                i--;
            } while (i >= startRange);

            // while (i >= startRange) {
            // System.out.println(tableno + " * " + i + " = " + tableno * i);
            // i--;
            // }

            // for (int i = endRange; i >= startRange; i--) {
            // System.out.println(tableno + " * " + i + " = " + tableno * i);
            // }
        }

        else if (c == 'a') {

            for (int i = startRange; i < endRange + 1; i++) {
                if (i != 15) {

                    System.out.println(tableno + " * " + i + " = " + tableno * i);
                }
            }

            // do (i < endRange + 1) {
            // System.out.println(tableno + " * " + i + " = " + tableno * i);
            // i++;
            // } while (i < endRange + 1);

            // while (i < endRange + 1) {
            // System.out.println(tableno + " * " + i + " = " + tableno * i);
            // i++;
            // }
        }

        else {
            // TODO code application logic here
            System.out.println("invalid sort selection");
        }
    }
}
