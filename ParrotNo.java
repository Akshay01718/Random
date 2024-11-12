package idk;

class Bird {
    String category;

    public Bird(String category) {
        this.category = category;
    }

    public void show() {
        System.out.println("Category: " + category);
    }
}

class Parrot extends Bird {
    int no_of_parrots;

    public Parrot(String category, int no_of_parrots) {
        super(category);
        this.no_of_parrots = no_of_parrots;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Number of Parrots: " + no_of_parrots);
    }
}

public class ParrotNo {
    public static void main(String[] args) {
        Parrot parrot = new Parrot("Bird", 5);
        parrot.show();
    }
}

