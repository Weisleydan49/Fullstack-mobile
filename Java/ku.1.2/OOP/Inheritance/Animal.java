public class Animal {
    // Properties / Attributes
    String color;
    int age;

    // Methods
    void makeSound() {
        System.out.println("Animal makes sound");
    }

    public static void main(String[] args) {
        Cat newCat = new Cat();
        
        // This will call the overridden version in the Cat class
        newCat.makeSound();
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow!");
    }
}