import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.GeneralPath;

/**
 * Created by Arthur on 21-2-2017.
 */
public class GeneralPathPractice extends JPanel
{
    private int size;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("General path practice.");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new GeneralPathPractice());
        frame.setVisible(true);
    }

    public GeneralPathPractice()
    {
        size = 1000;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        //Calculates the middle of the screen and adds half of the object size to center the drawn object.
        int halfScreenWidth = (getWidth() / 2) + (size / 2);
        int halfScreenHeight = (getHeight() / 2) + (size / 2);

        int largeCurveCorrection = size / 6;
        int smallCurveCorrection = size / 4; //This number is the offset used to make a curve less 'round';

        //Set the values for both curves below:
        int largeCurve[] = new int[6];
        largeCurve[0] = halfScreenWidth - size;
        largeCurve[1] = halfScreenHeight - largeCurveCorrection;
        largeCurve[2] = halfScreenWidth - size;
        largeCurve[3] = halfScreenHeight - size;
        largeCurve[4] = halfScreenWidth;
        largeCurve[5] = halfScreenHeight - size;

            //NOTE the points in this array go from the last point of the largeCurve to the origin.
        int smallCurve[] = new int[6];
        smallCurve[0] = (halfScreenWidth - ((size / 2) + (smallCurveCorrection / 4))); //Stretches the curve.
        smallCurve[1] = halfScreenHeight - size + smallCurveCorrection; //Bends the curve inwards.
        smallCurve[2] = halfScreenWidth - ((size / 2) + (smallCurveCorrection / 4)); //Stretches the curve
        smallCurve[3] = halfScreenHeight - smallCurveCorrection; //Bends the curve inwards.
        smallCurve[4] = halfScreenWidth;
        smallCurve[5] = halfScreenHeight;


        //Draw X and Y axle.
        graphics2D.setColor(Color.RED);
        graphics2D.drawLine((getWidth() / 2), 0, (getWidth() / 2), getHeight());
        graphics2D.drawLine(0, (getHeight() / 2), getWidth(), (getHeight() / 2));
        graphics2D.setColor(Color.BLACK);

        GeneralPath path = new GeneralPath();
        path.moveTo(halfScreenWidth, halfScreenHeight);
        path.curveTo(largeCurve[0],  largeCurve[1], largeCurve[2], largeCurve[3], largeCurve[4], largeCurve[5]);
        path.curveTo(smallCurve[0], smallCurve[1], smallCurve[2], smallCurve[3], smallCurve[4], smallCurve[5]);
        path.closePath();

        graphics2D.setColor(Color.lightGray);
        graphics2D.fill(path);
        graphics2D.setColor(Color.BLACK);
        graphics2D.draw(path);
    }
}
