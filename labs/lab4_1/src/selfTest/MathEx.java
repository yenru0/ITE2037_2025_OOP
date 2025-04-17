package selfTest;

public class MathEx {

    public static void main(String[] args) {
        System.out.println("HajinJu " + "2024062806");
        int a = 60984;
        int b = 808;

        double x = 2.0;
        double y = 3.0;
        double r;

        /* Random Number, 0<=r<10 */
        r = Math.random() * 10;

        System.out.printf("Maximum: %d%n", Math.max(a, b));
        System.out.printf("Mininum: %d%n", Math.min(a, b));
        System.out.println("x^y: " + Math.pow(x, y));
        System.out.println("y^x: " + Math.pow(y, x));
        System.out.println("Radius: " + r);
        System.out.println("Circle area: " + Math.PI * Math.pow(r, 2));
    }

}
