package idk;

import java.util.Random;

public class MThread {
    public static void main(String[] args) {
        Thread generatorThread = new Thread(new NumberGenerator());
        generatorThread.start();
    }
}

class NumberGenerator implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        
        while (true) {
            int number = random.nextInt(100); // Generate a random integer between 0 and 99
            System.out.println("Generated number: " + number);
            
            if (number % 2 == 0) {
                Thread evenThread = new Thread(new SquareCalculator(number));
                evenThread.start();
            } else {
                Thread oddThread = new Thread(new CubeCalculator(number));
                oddThread.start();
            }
            
            try {
                Thread.sleep(1000); // Wait for 1 second before generating the next number
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareCalculator implements Runnable {
    private final int number;

    public SquareCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int square = number * number;
        System.out.println("Square of " + number + " is: " + square);
    }
}

class CubeCalculator implements Runnable {
    private final int number;

    public CubeCalculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int cube = number * number * number;
        System.out.println("Cube of " + number + " is: " + cube);
    }
}
