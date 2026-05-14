package ShapeProject;

public class Cylinder extends RoundBase {
    public Cylinder(int radius, int height) {
        super(radius, height);
    }

    double volume() {
        return (Math.PI * Math.pow(radius, 2) * height);
    }

}
