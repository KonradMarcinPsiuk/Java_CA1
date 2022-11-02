import java.awt.*;

/**
 * Circle class, extends Shape
 */
public class Circle extends Shape {
    private int radius;

    /**
     * Circle class, extends Shape
     * @param color The color of the rectangle
     * @param xCenter Center position of the rectangle on the X axis
     * @param yCenter Center position of the rectangle on the Y axis
     * @param filled If true, rectangle will be filled with solid color
     * @param radius radius of the circle
     */
    public Circle( Color color, int xCenter,int yCenter,boolean filled,int radius){
        super(color, xCenter,yCenter, filled);
        this.radius = radius;
    }

    /**
     *Circle class, extends Shape
     * @param color The color of the rectangle
     * @param xCenter Center position of the rectangle on the X axis
     * @param yCenter Center position of the rectangle on the Y axis
     * @param radius radius of the circle
     */
    public Circle( Color color, int xCenter,int yCenter,int radius){
        super(color, xCenter,yCenter);
        this.radius = radius;
    }


    @Override
    public void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox) {
        g.setColor(getColor());
        if(getFilled()){
            g.fillOval(getxCenter()-radius, getyCenter()-radius,radius*2,radius*2 );
        }
        else{
            g.drawOval(getxCenter()-radius, getyCenter()-radius,radius*2,radius*2 );
        }

        if(displayShapeName)
            drawName(g);

        if(displayBoundingBox)
            drawBoundingBox(g);
    }


    @Override
    public BoundingBox getBoundingBox(){
        return new BoundingBox(new Point(getxCenter()-radius,getyCenter()+radius), new Point(getxCenter()+radius, getyCenter()-radius));
    }

    /**
     * Set radius of the circle
     * @param radius radius of the circle
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
