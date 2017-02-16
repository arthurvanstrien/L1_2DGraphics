import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Created by Arthur on 16-2-2017.
 */
public class TurningRectangle extends JPanel
{
    double angle;
    int screenWidth;
    int screenHeight;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Turning Rectangle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new TurningRectangle());
        frame.setVisible(true);
    }

    public TurningRectangle()
    {
        angle = Math.toRadians(45);
        screenHeight = getHeight();
        screenWidth = getWidth();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate((getWidth() / 2), (getHeight() / 2));
        affineTransform.rotate(angle);
        graphics2D.fill(affineTransform.createTransformedShape(new Rectangle2D.Double(0, 0, 200, 200)));


        graphics2D.setColor(Color.YELLOW);
        //graphics2D.fillRect(100, 100, 100, 100);
    }
}
