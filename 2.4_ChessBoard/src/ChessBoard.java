/**
 * Created by Arthur on 8-2-2017.
 */
import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    public static void main (String[] args) {
        JFrame frame = new JFrame("ChessBoard");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new ChessBoard());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        int positionX = 0;
        int positionY = 0;
        int sizeX = 100;
        int sizeY = 100;
        int j = 0;
        int firstLoop = 8;
        int secondLoop = 8;
        boolean colorBlack = true;
        Color black = Color.BLACK;
        Color white = Color.WHITE;

        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        for(int i = 0; i < firstLoop; i++)
        {
            positionX = 0;
            j = 0;

            while(j < secondLoop)
            {
                if(colorBlack == true)
                {
                    graphics2D.setColor(black);
                    colorBlack = false;
                }
                else
                {
                    graphics2D.setColor(white);
                    colorBlack = true;
                }
                graphics2D.fillRect(positionX, positionY, sizeX, sizeY);

                positionX = positionX + sizeX;
                j++;
            }

            if(colorBlack == true)
            {
                colorBlack = false;
            }
            else
            {
                colorBlack = true;
            }

            positionY = positionY + sizeY;

            System.out.println(positionY);
        }

        graphics2D.setColor(black);
        graphics2D.scale(10, 10);
        graphics2D.drawString("Schaakbord", 85, 10);
        graphics2D.scale(3, 3);
        graphics2D.drawString(":-)", 30, 15);
    }
}