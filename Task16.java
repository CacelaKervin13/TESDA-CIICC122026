public class Task16 {
    public static void main(String[] args) {
        Gorilla gorilla1 = new Gorilla();

        gorilla1.feed(true);
        gorilla1.groom();
        gorilla1.pet();
    }
}

interface Animal{
    boolean feed(boolean timeToEat);
    void groom();
    void pet();
}

class Gorilla implements Animal{
    @Override
    public boolean feed(boolean timeToEat) {
        if(timeToEat){
            System.out.println("Put Gorilla food in cage.");
        }
        return true;
    }

    @Override
    public void groom(){
        System.out.println("Lather, Rinse, Repeat.");
    }

    @Override 
    public void pet(){
        System.out.println("Pet at you own risk.");
    }
}
