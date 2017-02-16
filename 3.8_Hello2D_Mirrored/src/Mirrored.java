import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur on 16-2-2017.
 */
public class Mirrored extends JPanel
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Hello2D");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Mirrored());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(Color.RED);
        Font font = new Font("Monospaced", Font.BOLD, 200);
        setFont(font);
        graphics2D.scale(-1, 1);
        graphics2D.drawString("Hello2D", -(getWidth() / 2) - 400 , (getHeight() / 2) + 100);
    }
}
