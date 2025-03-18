
public class TempLoop {
    public static void main(String[] args) {
        for (int celsius = -20; celsius <= -10; celsius++) {
            double fahrenheit = getFahrenheit(celsius);

            System.out.println(celsius + "Celsius: " + fahrenheit + "Fahrenheit");
        }
    }

    public static double getFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
