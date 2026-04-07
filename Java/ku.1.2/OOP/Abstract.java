public class Abstract {
    public static void main(String[] args) {
        abstract class Car {
            // An abtsract method must be implemented by a subclass
            public abstract void makeSound();
            // A concrete method is shared by all subclasses

            public void honk() {
                System.out.println("Beep!! Beep!!");
            }

        }
        // Create a subclass that extends Car
        class McLaren extends Car {
            @Override
            public void makeSound() {
                System.out.println("Vroom!! Vroom!!");
            }
        }

        // Create an object of the subclass
        McLaren mycar = new McLaren();

        // Call the abstract method
        mycar.makeSound();

        // Call the concrete method
        mycar.honk();
    }
}