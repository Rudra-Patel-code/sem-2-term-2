
import java.util.Scanner;

public class ConvertTemp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = getFahrenheit(celsius);

        System.out.println(celsius + " Celsius: " + fahrenheit + " Fahrenheit");

    }

    public static double getFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
