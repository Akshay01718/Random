package idk;

import java.io.*;

public class fcopy {
    public static void main(String[] args) {
        String content = "This is a sample content.";
        String filePath = "sample.txt";

        // Write content to file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Content written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        // Read content from file and convert to uppercase
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Content in uppercase:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }
}

