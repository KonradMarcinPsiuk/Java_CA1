/**
 * Point class contains x and y variables to identify location in the 2D space
 */
public class Point{
    private int x;
    private int y;

    /**
     * Point class contains x and y variables to identify location in the 2D space
     * @param x of type int
     * @param y of type int
     */
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**
     * Return point on the X axis
     * @return point on the X axis
     */
    public int getX() {
        return x;
    }

    /**
     * Return point on the Y axis
     * @return point on the Y axis
     */
    public int getY() {
        return y;
    }

    /**
     * Set the point on the X axis
     * @param x point on the X axis
     */
    public void setX(int x){
        this.x=x;
    }

    /**
     * Set the point on the Y axis
     * @param y point on the Y axis
     */
    public void setY(int y){
        this.y=y;
    }
}
