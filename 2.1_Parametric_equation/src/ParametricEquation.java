import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Arthur on 1-3-2017.
 */
public class ParametricEquation extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Hello2D");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new ParametricEquation());
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        int x;
        int y;
        int previousX;
        int previousY;
        int scale;

        int halfWidth = getWidth() / 2;
        int halfHeight = getHeight() / 2;

        //Moves the origin point of the axle system to the middle of the screen.
        graphics2D.translate(halfWidth, halfHeight);

        //Makes the y axle scale in the opposite direction.
        // Instead of going downwards like computer screens do, we go upwards like a mathematical axle system.
        graphics2D.scale(1, -1);

        //Draw X and Y axle.
        graphics2D.setColor(Color.RED);
        graphics2D.drawLine(0, -halfHeight, 0, halfHeight);
        graphics2D.drawLine(-halfWidth, 0, halfWidth, 0);
        graphics2D.setColor(Color.BLACK);

        //Draw the line.
        previousX = 10 * 10;
        previousY = 10 * 10 * 10;
        scale = halfWidth / 100;


        for(int i = -9; i < 10; i++)
        {
            x = i * i * scale;
            y = i * i * i;

            graphics2D.drawLine(x, y, previousX, previousY);

            previousX = x;
            previousY = y;
            System.out.println(i);
            System.out.println(x + ", " + y);
        }


    }
}
