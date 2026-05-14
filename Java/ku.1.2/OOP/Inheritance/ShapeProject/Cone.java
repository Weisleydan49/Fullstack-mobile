package ShapeProject;

public class Cone extends RoundBase {
    public Cone(int radius, int height) {
        super(radius, height);
    }

    double volume() {
        return (Math.PI * Math.pow(radius, 2) * height) / 3;
    }

}
