import java.util.*;
public class Task7{
    public static void main(String[] args) {
        Task7 calculate = new Task7();
        Scanner scan = new Scanner(System.in);
        float num1, num2;
        char operand;

        System.out.print("Enter 1st number: ");
        num1 = scan.nextFloat();
        System.out.print("Enter 2nd number: ");
        num2 = scan.nextFloat();
        System.out.print("Enter operand to be used [+, -, *, /]: ");
        operand = scan.next().charAt(0);
        scan.close();

        switch (operand) {
            case '+' -> System.out.println("The sum is: "+calculate.addition(num1, num2));
            case '-' -> System.out.println("The difference is: "+calculate.subtraction(num1, num2));
            case '*' -> System.out.println("The product is: "+calculate.multiplication(num1, num2));
            case '/' -> System.out.println("The quotient is: "+calculate.division(num1, num2));
            default -> System.out.println("Invalid operand!!!");
        }
    }
    public float addition(float num1, float num2){return num1 + num2;}
    public float subtraction(float num1, float num2){return num1 + num2;}
    public float multiplication(float num1, float num2){return num1 + num2;}
    public float division(float num1, float num2){return num1 + num2;}
}