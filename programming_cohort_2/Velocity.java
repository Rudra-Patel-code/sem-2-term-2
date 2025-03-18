public class Velocity {
    public static void main(String[] args) {
        double t = 4;
        double a = 0;

        while (a < 20) {

            double v = finalVelocity(a, t);
            System.out.println("Final velocity at a = " + (a + 1) + "is: " + v);
            a++;
        }

    }

    // function is a module that performs a specific task
    public static double finalVelocity(double a, double t) {
        double u = 0;
        double v = u + ((a + 1) * t);
        return v;
    }
}
