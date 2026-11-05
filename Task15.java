public class Task15 {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5);
        Rectangle rect = new Rectangle("Green", 10, 20);

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
        System.out.println("Rectangle Area: " + rect.calculateArea());
        System.out.println("Rectangle Perimeter: " + rect.calculatePerimeter());

    }
}

interface Shape{
    double calculateArea();
    double calculatePerimeter();
}

abstract class AbstractShape implements Shape{
    String color;
    double length;
    double width;

    AbstractShape(String color, double length, double width){
        this.color = color;
        this.length = length;
        this.width = width;
    }


}

class Circle extends AbstractShape{
    private double radius;
    Circle(String color,double radius){
        super(color, 0, 0);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI*radius*radius;
        return area;
    }
    @Override
    public double calculatePerimeter() {
        double perimeter = 2*Math.PI*radius;
        return perimeter;
    }
}

class Rectangle extends AbstractShape{
    Rectangle(String color, double length, double width){
        super(color, length, width);
    }

    @Override
    public double calculateArea() {
        double area = length * width;
        return area;
    }
    @Override
    public double calculatePerimeter() {
        double perimeter = 2*(length * width);
        return perimeter;
    }
}