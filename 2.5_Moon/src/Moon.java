/**
 * Created by Arthur on 8-2-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Moon extends JPanel implements ActionListener
{
    private int counter = 0;
    private int shapeSize;
    private int positionX;
    private int screenWidth;

    public static void main (String[] args)
    {
        JFrame frame = new JFrame("Moon");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Moon());
        frame.setVisible(true);
    }

    public Moon()
    {
        Timer timer = new Timer(9, this);
        timer.start();// Start the timer here.

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();

        shapeSize = screenHeight - 200;
        positionX = (screenWidth - shapeSize) / 2;
        counter = -shapeSize;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Color gray = new Color(200,200,200);
        Color black = Color.BLACK;

        Shape circle1 = new Ellipse2D.Double(counter, 100, shapeSize, shapeSize);
        Shape circle2 = new Ellipse2D.Double(positionX, 100, shapeSize, shapeSize);

        Area total = new Area(circle1);
        total.subtract(new Area(circle2));

        graphics2D.setColor(gray);
        graphics2D.fill(total);
        graphics2D.setColor(black);
        graphics2D.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
        graphics2D.draw(total);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(counter < screenWidth)
        {
            counter++;
        }
        else
        {
            counter = -shapeSize;
        }

        repaint();
    }
}