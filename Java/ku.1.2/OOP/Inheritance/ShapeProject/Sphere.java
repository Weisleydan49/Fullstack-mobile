package ShapeProject;

public class Sphere extends Shape {
    Sphere(int radius) {
        super(radius);
    }

    double volume() {
        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

}
