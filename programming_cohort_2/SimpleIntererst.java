import java.util.Scanner;

public class SimpleIntererst {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Principal Amount: ");
        double p = scanner.nextDouble();

        System.out.print("Enter the Rate of Interest: ");
        double r = scanner.nextDouble();

        System.out.print("Enter the Time Period: ");
        double t = scanner.nextDouble();

        double SI = interest(p, r, t);

        System.out.println("Simple Interest is: " + SI);
    }

    public static double interest(double p, double r, double t) {
        return ((p * r * t) / 100);
    }
}