import java.util.*;
public class Task5{
    public static void main(String[] args) {
        ArrayList<Integer> inputs = new ArrayList<>();
        int inputCount = 1;
        Scanner scn = new Scanner(System.in);
        
        while (inputCount <=3 ) {
            System.out.print("Enter an input: ");
            inputs.add(scn.nextInt());
            inputCount++;
        }scn.close();
        if(inputs.get(0) == inputs.get(1) && inputs.get(1) == inputs.get(2)){
            System.out.println("All numbers are equals");
        }else{
            Collections.sort(inputs);
            System.out.println("The highest input is: " + inputs.get(2));
        }
    }
}