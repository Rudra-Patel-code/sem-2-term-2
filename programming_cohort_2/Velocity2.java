public class Velocity2 {
    public static void main(String[] args) {
        double vf = 0;
        double vi = 2;
        double a = 2;
        double d = 5;

        vf = finalVelocity(vi, a, d);
        System.out.println("Final velocity is: " + vf);

    }

    public static double finalVelocity(double vi, double a, double d) {
        double vf = Math.sqrt((vi * vi) + (2 * a * d));
        return vf;
    }
}
