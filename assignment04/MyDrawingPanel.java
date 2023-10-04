/**
 * This class implements extending a JPanel and making
 * a drawing on it using shapes and helper functions.
 *
 * @author Tyler J. Zoutte
 * @version February 3, 2023
 */
package assignment04;

import javax.swing.*;
import java.awt.*;

public class MyDrawingPanel extends JPanel implements Runnable
{
    public static void main(String[] args)
    {
        MyDrawingPanel mp = new MyDrawingPanel();
        SwingUtilities.invokeLater(mp);
    }

    @Override
    public void run()
    {
        // Build JFrame and have it exit on close.
        JFrame frame;
        frame = new JFrame("Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to use 'this' as it's drawing surface and display the frame.
        frame.setContentPane(this);
        frame.pack();
        frame.setVisible(true);
        frame.setBackground(new Color(0.0f, 0.5f, 0.3f));
    }

    public Dimension getMaximumSize()
    {
        // Set the frame size to 800 x 800 pixels.
        return new Dimension(800, 800);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(800, 800);
    }

    /**
     *
     * @param g  the <code>Graphics</code> context in which to paint
     */
    public void paint (Graphics g)
    {
        Color tan = new Color(0.8f, 0.7f, 0.4f);
        Color brown = new Color(0.5f, 0.4f, 0.3f);
        Color white = new Color(1.0f, 1.0f, 1.0f);
        Color black = new Color(0.0f, 0.0f, 0.0f);
        g.setColor(brown);
        g.fillOval(325, 275, 75, 75);
        g.fillOval(500, 275, 75, 75);
        g.setColor(tan);
        g.fillOval(350, 275, 200, 225);
        g.setColor(brown);
        g.fillOval(300, 400, 300, 115);
        g.setColor(white);
        g.fillOval(375, 325, 50, 60);
        g.fillOval(475, 325, 50, 60);
        g.setColor(black);
        g.fillOval(380, 330, 25, 25);
        g.fillOval(480, 330, 25, 25);
        g.fillArc(320, 435, 260, 50, 0, -180 );
        g.fillOval(435, 400, 10, 10);
        g.fillOval(455, 400, 10, 10);

        drawTeeth(g, 370, 460);

        drawName(g, 100, 150);
    }

    /**
     * Draws 5 teeth in increments of 35 horizontally
     *
     * @param g any graphics object
     * @param x the starting x position
     * @param y the y position
     */
    public void drawTeeth (Graphics g, int x, int y)
    {
        g.setColor(new Color(1.0f, 1.0f, 1.0f));
        for(int i = 0; i < 5; i++)
            g.fillRect(x + 35 * i, y, 25, 15);
    }

    /**
     * Prints 'Monkey' in increasing red brightness down the screen panel.
     *
     * @param g any graphics object
     * @param x the x position
     * @param y the starting y position
     */
    public void drawName (Graphics g, int x, int y)
    {
        for (int i = 0; i < 8; i++)
        {
            g.setColor(new Color(i * 25, 0, 0));
            g.setFont(new Font("Serif", Font.PLAIN, 36));
            g.drawString("Monkey", x,  y + i * 75);
        }
    }
}
