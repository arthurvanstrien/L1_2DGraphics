/**
 * Created by Arthur on 1-2-2017.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BSOD extends JPanel
{
    public static void main (String[] args)
    {
        JFrame frame = new JFrame("MyFirstJava2DApplication");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new BSOD());
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        try{
            final BufferedImage image = ImageIO.read(new File("BSOD.jpg"));
            graphics2D.drawImage(image, 0, 0, null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
