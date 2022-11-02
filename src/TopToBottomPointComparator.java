import java.util.Comparator;

/**
 * This is Point comparator that compare two Point classes to find the Point that is the most to the top
 */
public class TopToBottomPointComparator implements Comparator<Point> {
    /**
     * This is Point comparator that compare two Point classes to find the Point that is the most to the top
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     */
    @Override
    public int compare(Point o1, Point o2) {
        return o1.getX()-o2.getX();
    }
}
