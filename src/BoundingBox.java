import java.text.MessageFormat;

/**
 * Bounding box of the shape
 */
public class BoundingBox {
    private Point bottomLeft;
    private Point topRight;


    /**
     * Bounding box of the shape
     * @param bottomLeftPoint Left bottom point of the box
     * @param topRightPoint Right top point of the box
     */
    public BoundingBox(Point bottomLeftPoint, Point topRightPoint){
        this.bottomLeft = bottomLeftPoint;
        this.topRight = topRightPoint;
    }

    /**
     * @return Return the bottom left point in 2D space
     */
    public Point getBottomLeftPoint(){
        return bottomLeft;
    }


    /**
     * @return Return the top right point in 2D space
     */
    public Point getTopRightPoint(){
        return topRight;
    }

    /**
     * Set top right point in 2D space
     * @param topRight Set top right point in 2D space
     */
    public void setTopRightPoint(Point topRight) {
        this.topRight = topRight;
    }

    /**
     * Set bottom left point in 2D space
     * @param bottomLeft Set top right point in 2D space
     */
    public void setBottomLeftPoint(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    @Override
    public String toString(){
        return MessageFormat.format("Bounding box - Bottom left: x{0}:y{1}, Top right: x{2}:y{3}",
                bottomLeft.getX(),bottomLeft.getY(),topRight.getX(),topRight.getX());
    }
}
