import java.awt.*;
import java.util.Arrays;

/**
 * Quadrilateral shape class, extends Shape, implements Rotatable
 */
public class Quadrilateral extends Shape implements Rotatable{


    private Point[] points;

    /**
     * Quadrilateral shape class, extends Shape, implements Rotatable
     * @param centerPoint Rotation center point
     * @param points array of points (corners) in 2D space
     */
    public Quadrilateral (Point centerPoint, Point[] points){
        super(Color.BLACK, centerPoint.getX(),centerPoint.getY(), false);
        this.points = points;
    }

    /**
     * Quadrilateral shape class, extends Shape, implements Rotatable
     * @param centerPoint Rotation center point
     * @param p1 point (corner) in 2D space
     * @param p2 point (corner) in 2D space
     * @param p3 point (corner) in 2D space
     * @param p4 point (corner) in 2D space
     */
    public Quadrilateral(Point centerPoint, Point p1, Point p2, Point p3, Point p4){
        super(Color.BLACK, centerPoint.getX(),centerPoint.getY(), false);
        this.points = new Point[]{p1,p2,p3,p4};
    }

    /**
     * Quadrilateral shape class, extends Shape, implements Rotatable
     * @param rectangle base shape for quadrilateral
     */
    public Quadrilateral(Rectangle rectangle){
        super(Color.BLACK, rectangle.getxCenter(),rectangle.getyCenter(), false);

        //local variables implemented for code clarity
        int rectXCenter = rectangle.getxCenter();
        int rectYCenter = rectangle.getyCenter();
        int rectHalfWidth = (rectangle.getWidth()/2);
        int rectHalfHeight = (rectangle.getHeight()/2);


        Point p1 = new Point(rectXCenter - rectHalfWidth, rectYCenter - rectHalfHeight);
        Point p2 = new Point(rectXCenter + rectHalfWidth, rectYCenter - rectHalfHeight);
        Point p3 = new Point(rectXCenter + rectHalfWidth, rectYCenter + rectHalfHeight);
        Point p4 = new Point(rectXCenter - rectHalfWidth, rectYCenter + rectHalfHeight);

        this.points = new Point[]{p1,p2,p3,p4};
    }


    @Override
    public void drawShape(Graphics g, boolean displayShapeName, boolean displayBoundingBox) {
        g.setColor(getColor());

        if(getFilled()){
            g.fillPolygon(new int[]{points[0].getX(),points[1].getX(),points[2].getX(),points[3].getX()},
                    new int[]{points[0].getY(),points[1].getY(),points[2].getY(),points[3].getY()},points.length);
        }
        else{
            g.drawPolygon(new int[]{points[0].getX(),points[1].getX(),points[2].getX(),points[3].getX()},
                    new int[]{points[0].getY(),points[1].getY(),points[2].getY(),points[3].getY()},points.length);
        }

        if(displayShapeName)
            drawName(g);

        if(displayBoundingBox)
            drawBoundingBox(g);
    }

    @Override
    public BoundingBox getBoundingBox() {

        Point[] tempArray = Arrays.copyOf(points,points.length);

        Arrays.sort(tempArray,new TopToBottomPointComparator());
        int x1 = tempArray[0].getX();
        int x2 = tempArray[tempArray.length-1].getX();

        Arrays.sort(tempArray, new LeftToRightPointComparator());
        int y1 = tempArray[tempArray.length-1].getY();
        int y2 = tempArray[0].getY();

        return new BoundingBox(new Point(x1,y1),new Point(x2,y2));
    }

    /**
     * Rotate shape by 90 degrees
     */
    @Override
    public void rotateNinetyDegrees() {
        for (Point p:points) {
            rotatePoint(p,new Point(getxCenter(),getyCenter()));
        }
    }

    /**
     * Rotate Point in relation to centerPoint
     * @param p Point to be rotated
     * @param centerPoint Center point of the rotation
     */
    private void rotatePoint(Point p, Point centerPoint){

        double mCos = Math.cos(Math.toRadians(Consts.DEGREES_TO_ROTATE));
        double mSin = Math.sin(Math.toRadians(Consts.DEGREES_TO_ROTATE));

        int pX = p.getX();
        int pY = p.getY();

        int centX = centerPoint.getX();
        int centY = centerPoint.getY();


        double rlx = (((pX - centX) * mCos) - ((pY - centY)*mSin));
        double rly = (((pX - centX) * mSin) + ((pY - centY)*mCos));

        //Math.round to eliminate 'cast to int' rounding error
        p.setX( (int) Math.round(rlx + centerPoint.getX()));
        p.setY( (int) Math.round(rly + centerPoint.getY()));
    }
}
