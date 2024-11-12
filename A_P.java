package idk;

interface Shape {
    double area();
    double perimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius; 
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
 
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class A_P {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
    }
}

