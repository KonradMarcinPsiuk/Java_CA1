import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomPanel extends JPanel {

    private ShapesManager shapesManager;

    public CustomPanel(ShapesManager shapeManager ){
        this.shapesManager = shapeManager;
        addMouseListener();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        shapesManager.drawShapes(g);
    }


     //Add mouse listener to the panel class
    private void addMouseListener(){

        addMouseListener(new MouseAdapter() {

            //Mouse click event handler
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                //iterate through the shapes
                for (Shape s:shapesManager.getShapes()) {

                    //Get bounding box of the shape
                    BoundingBox box = s.getBoundingBox();

                    //Get mouse position in relation to the panel
                    int eX = e.getPoint().x;
                    int eY = e.getPoint().y;

                    //Get corners of the bounding box
                    Point bottomLeft = box.getBottomLeftPoint();
                    Point topRight = box.getTopRightPoint();

                    //Check if mouse position is within the bounding box
                    if((eX>=bottomLeft.getX() && eX<=topRight.getX()) && (eY>=topRight.getY()) && eY<=bottomLeft.getY())
                    {
                        //Print X and Y points of the bounding box
                        System.out.println(box);

                        //Handle click of the button 1 (left click)
                        if(e.getButton()==MouseEvent.BUTTON1)
                            s.switchFilling();

                        //Handle click of the button 3 (right click)
                        if(e.getButton()==MouseEvent.BUTTON3){

                            //Check if shape implement Movable interface
                            if(s instanceof Movable){

                                //Execute moveTenUnits method
                               ((Movable) s).moveTenUnits();

                                //((Movable) s).moveShape(20,-10);
                           }

                            //Check if shape implement Rotatable interface
                           if(s instanceof Rotatable){

                               //Execute rotateNinetyDegrees method
                               ((Rotatable)s).rotateNinetyDegrees();
                           }
                        }

                        //Repaint the shapes
                        CustomPanel.super.repaint();
                    }

                }
            }
        });
    }
}