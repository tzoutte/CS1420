package lab09;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Circle objects represent a circle Shape
 * drawn to the screen at a particular position
 * with some size and color.
 *
 * @author Peter Jensen
 * @version Spring 2023
 */
public class Rect extends Shape
{
    // Instance variables.
    private int height;
    private int width;

    /**
     * Constructor - initializes the position, diameter, and
     * color of this circle object.
     *
     * @param x
     *         the x coordinate of this object's position
     *
     * @param y
     *         the x coordinate of this object's position
     *
     * @param height
     *              the height of this rectangle
     *
     * @param color
     *             the color of this circle
     */
    public Rect (int x, int y, int height, int width, Color color)
    {
        super(x, y, color);
        this.height = height;
        this.width = width;
    }

    /**
     * Draws the circle at it's current position and color
     * to the specified graphics object.
     *
     * @param g
     *         the graphics object (where to draw to)
     */
    public void draw (Graphics g)
    {
        g.setColor (color);
        g.fillRect (x, y, width, height);
    }

    /**
     * Returns true if the coordinates are within the circle.
     *
     * @param targetX
     *               an x coordinate
     *
     * @param targetY
     *               a y coordinate
     *
     * @return
     *        true if the coordinates are within the Shape
     */
    public boolean isInside (int targetX, int targetY)
    {
        return targetX >= x &&
                targetX < x + width &&
                targetY >= y &&
                targetY < y + height;
    }
}

