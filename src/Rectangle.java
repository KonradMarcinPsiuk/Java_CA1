import java.awt.*;

/**
 * The rectangle shape class, extends Shape, implements Movable
 */
public class Rectangle extends Shape implements Movable {

    private int width;
    private int height;

    /**
     * The rectangle shape class, extends Shape, implements Movable
     * @param color The color of the rectangle
     * @param xCenter Center position of the rectangle on the X axis
     * @param yCenter Center position of the rectangle on the Y axis
     * @param filled If true, rectangle will be filled with solid color
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    public Rectangle(Color color,int xCenter,int yCenter,boolean filled, int width, int height ){
        super(color, xCenter, yCenter, filled);
        this.width = width;
        this.height= height;
    }

    /**
     * The rectangle shape class, extends Shape, implements Movable
     * @param color The color of the rectangle
     * @param xCenter Center position of the rectangle on the X axis
     * @param yCenter Center position of the rectangle on the Y axis
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    public Rectangle(Color color,int xCenter,int yCenter,int width, int height){
        super(color, xCenter, yCenter);
        this.width = width;
        this.height= height;
    }

    @Override
    public void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox) {

        g.setColor(getColor());

        if(getFilled()){
            g.fillRect(getxCenter()-(width/2), getyCenter()-(height/2),width,height );
        }
        else{
            g.drawRect(getxCenter()-(width/2), getyCenter()-(height/2),width,height);
        }

        if(displayShapeName)
            drawName(g);

        if(displayBoundingBox)
            drawBoundingBox(g);
    }

    @Override
    public BoundingBox getBoundingBox() {
        Point x = new Point(getxCenter() - (width / 2), getyCenter() + (height / 2));
        Point y = new Point(getxCenter() + (width / 2), getyCenter() - (height / 2));
        return new BoundingBox(x, y);
    }

    /**
     * Move this shape by +10 units
     */
    @Override
    public void moveTenUnits() {
        setxCenter(getxCenter()+10);
    }

    /**
     * Move the shape by the distance given
     * @param x distance of the movement along the X axis
     * @param y distance of the movement along the Y axis
     */
    public void moveShape(int x, int y){
        setxCenter(getxCenter()+x);
        setyCenter(getyCenter()+y);
    }

    /**
     * Return the width of the shape
     * @return width of the shape
     */
    public int getWidth(){
        return width;
    }

    /**
     * Return the height of the shape
     * @return height of the shape
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the width of the shape
     * @param width width of the shape
     */
    public void setWidth(int width){
        this.width = width;
    }

    /**
     * Set the height of the shape
     * @param height height of the shape
     */
    public void setHeight(int height){
        this.height = height;
    }
}
