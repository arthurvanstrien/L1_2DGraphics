import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * Created by Arthur on 22-2-2017.
 */
public class ReflectedRectangle extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Reflected Rectangle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new ReflectedRectangle());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        int halfWidth = getWidth() / 2;
        int halfHeight = getHeight() / 2;

        AffineTransform affineTransform = new AffineTransform(2/5.0-1, 4/5.0, 0, 4/5.0, 16/5.0-1, 0);

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

        //Draw angled line:
        graphics2D.setColor(Color.BLUE);
        graphics2D.drawLine(-(halfHeight / 2), -halfHeight,halfHeight / 2,halfHeight);


    }
}
