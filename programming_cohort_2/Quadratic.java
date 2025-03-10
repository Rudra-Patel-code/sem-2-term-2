import java.util.ArrayList;
import java.util.List;

public class Quadratic {
    public static void main(String[] args) {
        double a = 1;
        double b = 10;
        double c = 2;

        List<Double> values = quadraticFormula1(a, b, c);

        System.out.println("Root 1 is: " + values.get(0));
        System.out.println("Root 2 is: " + values.get(1));
    }

    public static List<Double> quadraticFormula1(double a, double b, double c) {

        double x1 = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
        double x2 = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);

        List<Double> values = new ArrayList<>();
        values.add(x1);
        values.add(x2);

        return values;
    }
}
