public class CalculatorFunction {
    public static void main(String[] args) {
        double a = 10;
        double b = 20;

        addition(a, b);
        subtraction(a, b);
        multiplication(a, b);
        division(a, b);
    }

    public static void addition(double a, double b) {
        double c = a + b;
        System.out.println("Addition of " + a + " and " + b + " is: " + c);

    }

    public static void subtraction(double a, double b) {
        double c = a - b;
        System.out.println("Subtraction of a and b is: " + c);
    }

    public static void multiplication(double a, double b) {
        double d = a * b;
        System.out.println("Subtraction of " + a + " and " + b + " is: " + d);
    }

    public static void division(double a, double b) {
        double c = a / b;
        System.out.println("Division of " + a + " and " + b + " is: " + c);
    }
}