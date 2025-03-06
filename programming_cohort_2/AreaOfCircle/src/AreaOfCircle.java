public class AreaOfCircle {
    public static void main(String[] args) {
        double rad = 3;
        double area = area(rad);
        System.out.println("Area of circle with radius " + rad + " is: " + area);
    }

    public static double area(double rad) {
        return 3.14 * rad * rad;
    }
}
