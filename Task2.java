class Task2{
    public static void main(String[] args) {
        byte one = 1;
        short zero = 0;
        int three = 3;
        float fl = 2.0F;
        char letterH='H', letterW='w', letterR='r', letterL='l', letterD='d';
        boolean checker = true;

        String message = ""+letterH+three+one+one+zero
                        +" "+letterW+zero+letterR+letterL+letterD 
                        +" "+" "+fl+" "+checker;

        System.out.println(message);
    }
}