abstract class Cars {
    // properties / attributes
    int yearOfProduction;
    String colour;

    // Abstract method (has no body)
    public void stop(int yearOfProduction, String colour) {
        yearOfProduction = 2022;
        colour = "Charcoal grey";
    }

    // concrete method
    public void start() {
        System.out.println("Car is starting");
    }
}

class Mercedes extends Cars {
    @Override
    public void stop() {
        System.out.println("Mercedes has stopped!!");
    }
}

class Bima extends Cars {
    @Override
    public void start() {
        System.out.println("BMW has started");
    }
}

public class Car {
    public static void main(String[] args) {
        Cars Benz = new Mercedes();
        Cars X7 = new Bima();
        X7.start();
        X7.stop();
        Benz.start();
        Benz.stop();
    }
}
