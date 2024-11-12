package idk;

import java.util.ArrayList;
import java.util.Scanner;

public class StringOp { 
    private ArrayList<String> stringList = new ArrayList<>();

    // Method to append a string at the end
    public void append(String str) {
        stringList.add(str);
        System.out.println("Appended \"" + str + "\" to the list.");
    }

    // Method to insert a string at a specific index
    public void insert(int index, String str) {
        if (index >= 0 && index <= stringList.size()) {
            stringList.add(index, str);
            System.out.println("Inserted \"" + str + "\" at index " + index + ".");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to search for a string
    public void search(String str) {
        if (stringList.contains(str)) {
            System.out.println("String \"" + str + "\" found in the list.");
        } else {
            System.out.println("String \"" + str + "\" not found in the list.");
        }
    }

    // Method to list all strings starting with a given letter
    public void listStartingWith(char letter) {
        System.out.println("Strings starting with '" + letter + "':");
        for (String s : stringList) {
            if (s.startsWith(String.valueOf(letter))) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringOp operations = new StringOp();
        
        // Sample data for demonstration
        operations.append("apple");
        operations.append("banana");
        operations.append("cherry");

        // Menu-driven program
        int choice;
        do {
            System.out.println("\nString Operations Menu:");
            System.out.println("1. Append a string");
            System.out.println("2. Insert a string at a specific index");
            System.out.println("3. Search for a string");
            System.out.println("4. List all strings starting with a given letter");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter string to append: ");
                    String appendStr = scanner.nextLine();
                    operations.append(appendStr);
                    break;

                case 2:
                    System.out.print("Enter index to insert at: ");
                    int index = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter string to insert: ");
                    String insertStr = scanner.nextLine();
                    operations.insert(index, insertStr);
                    break;

                case 3:
                    System.out.print("Enter string to search: ");
                    String searchStr = scanner.nextLine();
                    operations.search(searchStr);
                    break;

                case 4:
                    System.out.print("Enter starting letter: ");
                    char letter = scanner.nextLine().charAt(0);
                    operations.listStartingWith(letter);
                    break;

                case 5:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}

