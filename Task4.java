import java.util.*;
public class Task4 {
    public static void main(String[] args) {
        String inputString;
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter Input to check palindrome: ");
        inputString = scn.next();
        scn.close();

        StringBuilder palindromeInputString = new StringBuilder();
        palindromeInputString.reverse();


        if(inputString.equals(palindromeInputString.toString())){
            System.out.println("The input string is a palindrome");
        }else{
            System.out.println("The input string is not a palindrome");
        }
        
    }
}
