package idk;

import java.util.Scanner;

class Area {
    private double length;
    private double breadth;

    // Constructor to initialize length and breadth
    public Area(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate and return area
    public double returnArea() {
        return length * breadth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input length and breadth from the user
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the breadth of the rectangle: ");
        double breadth = scanner.nextDouble();

        // Create an Area object
        Area rectangle = new Area(length, breadth);

        // Print the area of the rectangle
        System.out.println("The area of the rectangle is: " + rectangle.returnArea());
    }
}
