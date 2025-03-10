public class Velocity {
    public static void main(String[] args) {
        double v = 0;
        double u = 2;
        double a = 2;
        double t = 5;

        v = finalVelocity(u, a, t);
        System.out.println("Final velocity is: " + v);

    }

    // function is a module that performs a specific task
    public static double finalVelocity(double u, double a, double t) {
        double v = u + (a * t);
        return v;
    }
}
