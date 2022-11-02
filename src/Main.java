import javax.swing.*;
import java.awt.*;

class WindowCreator {
    public static void main(String[] args) {

        ShapesManager shapesManager = new ShapesManager();
        shapesManager.setDisplayName(true);
        shapesManager.setDisplayBoundingBox(true);

        //todo sprawdzic czy wszystkie konstruktory sa dostepne
        shapesManager.addShape(new Circle(Color.GREEN,300,80,50));

        Rectangle rect = new Rectangle(Color.BLUE, 50,120,true,50,80);
        shapesManager.addShape(rect);

        Rectangle rect2 = new Rectangle(Color.RED, 140,180,40,30);

        Quadrilateral quad = new Quadrilateral(rect2);
        shapesManager.addShape(quad);

        CustomWindow customWindow = new CustomWindow(shapesManager);
        customWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customWindow.setTitle("Test Window");
        customWindow.setVisible(true);
    }
}