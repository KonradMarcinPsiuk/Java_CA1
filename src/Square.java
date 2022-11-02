import java.awt.*;

/**
 * Square class, extends Rectangle class
 */
public class Square extends Rectangle{

    private int side;

    /**
     * Square class, extends Rectangle class
     * @param side size of the side of the square
     * @param color color of the square
     * @param filled true for the filled square
     * @param xCenter center point of the square on the X axis
     * @param yCenter center point of the square on the Y axis
     */
    public Square( Color color, int xCenter, int yCenter, boolean filled, int side){
        super(color, xCenter, yCenter , filled,side, side);
        this.side = side;
    }

    /**
     * Return size of the square's side
     * @return size of the square's side
     */
    public int getSide(){
        return side;
    }

    /**
     * Set the size of the square side
     * @param side size of the square side
     */
    public void setSide(int side){
        this.side=side;
    }
}
