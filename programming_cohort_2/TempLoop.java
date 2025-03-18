
public class TempLoop {
    public static void main(String[] args) {
        // for (int celsius = -20; celsius <= -10; celsius++) {
        // double fahrenheit = getFahrenheit(celsius);

        // }

        float celsius = -20;
        while (celsius <= -10) {
            float fahrenheit = getFahrenheit(celsius);
            System.out.println(celsius + ": Celsius: " + fahrenheit + ": Fahrenheit");
            celsius++;
        }
    }

    public static float getFahrenheit(float celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
