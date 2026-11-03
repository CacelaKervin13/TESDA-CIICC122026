public class Task8{
    public static void main(String[] args) {
        processNumbers(4, 5, 6, 7);

        
    }

    public static void processNumbers(int... numbers){
        int paramSum=0;
        for(int number: numbers){
            paramSum += number; 
        }
        System.out.println("The total sum is :" +paramSum);

        
        for(int number: numbers){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i <= number ;i++){
                sb.append(i);
                if(i < number){sb.append(" + ");}
            }
            System.out.println("The commulative num for "+number+": "+sb);
        }    
    }
}
