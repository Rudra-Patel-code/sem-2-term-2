public class CalculatorFunction {
    public static void main(String[] args) {
        double a = 10;
        double b = 20;
        double c = 0;

        c = addition(a, b);
        System.out.println("Addition of " + a + " and " + b + " is: " + c);

        c = subtraction(a, b);
        System.out.println("Subtraction of " + a + " and " + b + " is: " + c);

        c = multiplication(a, b);
        System.out.println("Multiplication of " + a + " and " + b + " is: " + c);

        c = division(a, b);
        System.out.println("Division of " + a + " and " + b + " is: " + c);
    }

    public static double addition(double a, double b) {
        return (a + b);

    }

    public static double subtraction(double a, double b) {
        return (a - b);
    }

    public static double multiplication(double a, double b) {
        return (a * b);
    }

    public static double division(double a, double b) {
        return (a / b);
    }
}