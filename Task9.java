import static java.lang.Math.*;
import java.util.*;

public class Task9{

    public static int add(int a, int b) {
        return Math.addExact(a, b);
    }

    public static int subtract(int a, int b) {
        return Math.subtractExact(a, b);
    }

    public static int multiply(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    public static float divide(int a, int b) {
        return Math.divideExact(a, b);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1, num2;

        System.out.print("Enter 1st number: ");
        num1 = scn.nextInt();
        System.out.print("Enter 2nd number: ");
        num2 = scn.nextInt();
        scn.close();
        System.out.println("**********************************");

        System.out.println("The sum is: "+add(num1, num2));
        System.out.println("The difference is: "+subtract(num1, num2));
        System.out.println("The quotient is: "+multiply(num1, num2));
        System.out.println("The product is: "+divide(num1, num2));
    }
}