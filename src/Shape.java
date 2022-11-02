import java.awt.*;

import static com.Helpers.GetContrastColor.getContrast;

/**
 * Shape super class
 */
public abstract class Shape {

    //by default initialized to color: Black
    private Color color;
    private boolean filled;
    private int xCenter,yCenter;


    /**
     * Shaper super class
     * @param color color of the shape
     * @param xCenter center point of the shape on X axis
     * @param yCenter center point of the shape on Y axis
     * @param filled if true, shape filled with solid color
     */
    public Shape(Color color,int xCenter,int yCenter, boolean filled){
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter=yCenter;
        this.filled = filled;
    }

    /**
     * Shaper super class
     * @param color color of the shape
     * @param xCenter center point of the shape on X axis
     * @param yCenter center point of the shape on Y axis
     */
    public Shape(Color color,int xCenter,int yCenter){
        this.color = color;
        this.xCenter = xCenter;
        this.yCenter=yCenter;
    }

    /**
     * Draw the shape in provided Graphic parameter
     * @param g Graphic parameter
     * @param displayShapeName If True it displays name of the shape (by class)
     * @param displayBoundingBox If True it displays bounding box of the shape
     */
    public abstract void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox);

    protected void drawName(Graphics g){
        if(filled){
            g.setColor(getContrast(color));
        }
        else{
            g.setColor(color);
        }
        g.drawString(this.getClass().getSimpleName(),xCenter,yCenter);
    }

    /**
     * Draw bounding box of the shape in the provided Graphics object
     * @param g Graphics object
     */
    protected void drawBoundingBox(Graphics g){
        BoundingBox box = getBoundingBox();

        int x = box.getBottomLeftPoint().getX();
        int y = box.getBottomLeftPoint().getY();
        int width = box.getTopRightPoint().getX()-box.getBottomLeftPoint().getX();
        int height = box.getBottomLeftPoint().getY()-box.getTopRightPoint().getY();
        y -= height;

        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
    }

    /**
     * Return center point of the X axis
     * @return center point of the X axis
     */
    public int getxCenter(){
        return xCenter;
    }

    /**
     * Return center point of the Y axis
     * @return center point of the Y axis
     */
    public int getyCenter(){
        return yCenter;
    }

    /**
     * Return color of the shape
     * @return Color of the shape
     */
    public Color getColor(){
        return color;
    }


    /**
     * Switch the filled property of the shape
     */
    public void switchFilling(){
        filled = !filled;
    }

    /**
     * Return filled property of the shape
     * @return filled property of the shape
     */
    public boolean getFilled(){
        return filled;
    }

    /**
     * Return bounding box of the shape
     * @return Return bounding box of type BoundingBox
     */
    public abstract BoundingBox getBoundingBox();

    /**
     * Set the center point on the X axis
     * @param xCenter point on the X axis
     */

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    /**
     * Set the center point on the Y axis
     * @param yCenter point on the Y axis
     */

    public void setyCenter(int yCenter){
        this.yCenter = yCenter;
    }

    /**
     * Set the color of the shape
     * @param color color of the shape
     */

    public void setColor(Color color){
        this.color = color;
    }
}
