package idk;
abstract class Shape2 {
    // Abstract method
    abstract void printArea();
}

class Rectangle2 extends Shape2 {
    private double length;
    private double breadth;

    // Constructor to initialize length and breadth
    public Rectangle2(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Implementing printArea() for Rectangle
    @Override
    void printArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape2 {
    private double base;
    private double height;

    // Constructor to initialize base and height
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implementing printArea() for Triangle
    @Override
    void printArea() {
        double area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
}

public class ShapeExample {
    public static void main(String[] args) {
        Shape2 rectangle = new Rectangle2(5, 3);
        Shape2 triangle = new Triangle(4, 6);

        rectangle.printArea();
        triangle.printArea();
    }
}
