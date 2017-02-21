/**
 * Created by Arthur on 21-2-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.lang.Math.*;

/**
 * Created by Arthur on 16-2-2017.
 */
public class AngledSquare extends JPanel
{
    double angle;
    int height;
    int width;
    double c;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Square angled by 45 degrees and positioned at the origin.");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new AngledSquare());
        frame.setVisible(true);
    }

    public AngledSquare()
    {
        angle = Math.toRadians(45);
        height = 200;
        width = 200;

        //Calculate the length that needs to be substracted to get the square in the origin after rotation.
        int a = height * height;
        int b = width * width;
        c = a + b;
        c = Math.sqrt(c);
        c = c / 2;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate((getWidth() / 2), (getHeight() / 2) - c);
        affineTransform.rotate(angle);
        graphics2D.fill(affineTransform.createTransformedShape(new Rectangle2D.Double(0, 0, 200, 200)));

        graphics2D.setColor(Color.RED);
        graphics2D.drawLine((getWidth() / 2), 0, (getWidth() / 2), getHeight());
        graphics2D.drawLine(0, (getHeight() / 2), getWidth(), (getHeight() / 2));
    }
}
