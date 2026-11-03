import java.util.ArrayList;

class Task11 {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Java Programming","John Smith",2021,39.99);
        Book book2 = new Book("Python Basics","Jane Doe",2020,29.99);
        Book book3 = new Book("C++ Essentials","Michael Johnson",2019,49.99);

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        for(int i = 0; i < bookList.size() ;i++){
            System.out.println("Book "+(i+1)+":");
            System.out.println(bookList.get(i).toString());
        }


    }
}

class Book{
    String title;
    String author;
    int yearPublished;
    double price;

    public Book(String title, String author, int yearPublished,double price){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    @Override 
    public String toString(){
        return "Title: " + "\"" + title + "\"" + "\n" 
                + "Author: " + "\"" + author + "\"" + "\n"
                + "Year Published: " + yearPublished + "\n" 
                + "Price: $" + price + "\n" ;
    }
}