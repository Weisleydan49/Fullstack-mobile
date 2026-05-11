import javax.swing.*;

abstract class Cars {
    // properties / attributes
    int yearOfProduction;
    String colour;

    // Abstract nethod(has no doby)
    public void stop() {

    }

    // concrete method
    public void start() {
        JOptionPane.showMessageDialog(null, "Car is sarting");
    }
}

class Mercedes extends Cars {
    @Override
    public void stop() {
        JOptionPane.showMessageDialog(null, "Merceds has stopped!!");
    }
}

class Bima extends Cars {
    @Override
    public void start() {
        JOptionPane.showMessageDialog(null, "BMW has started");
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
