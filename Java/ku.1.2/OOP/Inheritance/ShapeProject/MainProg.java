package ShapeProject;

import javax.swing.JOptionPane;

public class MainProg {
    public static void main(String[] args) {
        System.out.println("1. Sphere");
        System.out.println("2. Cone");
        System.out.println("3. Cylinder");
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Enter your choice"));
        if (choice == 1) {// if choice is Sphere
            int r = Integer.parseInt(JOptionPane.showInputDialog("Enter the radius"));
            Sphere sp = new Sphere(r);
            System.out.println("The Volume of the sphere is" + sp.volume());
        }
        if (choice == 2) {// if choice is Cone
            int r = Integer.parseInt(JOptionPane.showInputDialog("Enter the radius"));
            int h = Integer.parseInt(JOptionPane.showInputDialog("Enter the height"));
            Cone cn = new Cone(r, h);
            System.out.println("The Volume of the Cone is " + cn.volume());
        }
        if (choice == 3) {// if choice is Cylinder
            int r = Integer.parseInt(JOptionPane.showInputDialog("Enter the radius"));
            int h = Integer.parseInt(JOptionPane.showInputDialog("Enter the height"));
            Cylinder cyl = new Cylinder(r, h);
            System.out.println("The Volume of the Cylinder is " + cyl.volume());
        } else
            System.out.println("ERROR IN INPUT");
    }
}
