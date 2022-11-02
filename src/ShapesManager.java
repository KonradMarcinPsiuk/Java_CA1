import java.awt.*;
import java.util.ArrayList;

/**
 * Manage the array of shapes
 */
public class ShapesManager {
    private ArrayList<Shape> shapes =new ArrayList<>();
    private boolean displayName, displayBoundingBox = true;

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * Draw shapes stored in the array in provided graphics object
     * @param graphicsContext graphics object
     */
    public void drawShapes(Graphics graphicsContext){
        for (var s:shapes) {
            s.drawShape(graphicsContext,displayName,displayBoundingBox);
        }
    }

    /**
     * Return array of shares
     * @return array of shares
     */
    public ArrayList<Shape> getShapes(){
          return shapes;
    }

    /**
     * Set the parameter that control the visibility of the shape names
     * @param displayName If true, shapes name will be visible
     */
    public void setDisplayName(boolean displayName) {
        this.displayName = displayName;
    }

    /**
     * Set the parameter that control the visibility of the binding box
     * @param displayBoundingBox If true, binding box will be visible
     */
    public void setDisplayBoundingBox(boolean displayBoundingBox) {
        this.displayBoundingBox = displayBoundingBox;
    }
}

