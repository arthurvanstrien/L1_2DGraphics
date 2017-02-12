/**
 * Created by Arthur on 1-2-2017.
 */
import javax.swing.*;
import java.awt.*;

public class Checkers extends JPanel {
    public static void main (String[] args) {
        JFrame frame = new JFrame("Checkers");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Checkers());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        int positionX = 0;
        int positionY = 0;
        int sizeX = 100;
        int sizeY = 100;
        int j = 0;
        Color black = Color.BLACK;
        Color white = Color.WHITE;


        super.paintComponent(g);
        Graphics2D grapics2D = (Graphics2D) g;

        //grapics2D.drawLine(10, 30, 100, 100);
        //grapics2D.scale(10, 10);
        //grapics2D.drawString("Dambord", 10, 10);

        for(int i = 0; i < 10; i++)
        {
            positionY = 0;

            if(i % 2 == 0) {
                j = 1;
            }
            else
            {
                j = 0;
            }

            while(j < 30)
            {
                if(j % 2 == 0)
                {
                    grapics2D.setColor(black);
                }
                else
                {
                    grapics2D.setColor(white);
                }
                grapics2D.fillRect(positionY, positionX,sizeY, sizeX);

                positionY = positionY + sizeY;
                j++;
            }

            positionX = positionX + sizeX;
        }
    }
}
