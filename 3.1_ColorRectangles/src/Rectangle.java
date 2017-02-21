import javax.swing.*;
import java.awt.*;

/**
 * Created by Arthur on 8-2-2017.
 */
public class Rectangle extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ChessBoard");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Rectangle());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        int xPosition = 0;
        int yPosition = 0;

        int size = 500;
        Color colors[] = new Color[13];
        colors[0] = Color.RED;
        colors[1] = Color.GREEN;
        colors[2] = Color.BLUE;
        colors[3] = Color.YELLOW;
        colors[4] = Color.CYAN;
        colors[5] = Color.MAGENTA;
        colors[6] = Color.WHITE;
        colors[7] = Color.BLACK;
        colors[8] = Color.GRAY;
        colors[9] = Color.LIGHT_GRAY;
        colors[10] = Color.DARK_GRAY;
        colors[11] = Color.ORANGE;
        colors[12] = Color.PINK;

        for(int i = 0; i < 13; i++)
        {
            graphics2D.setColor(colors[i]);
            graphics2D.fillRect(xPosition, yPosition, size, size);

            if((i + 1) % 5 == 0)
            {
                xPosition = 0;
                yPosition = yPosition + size;
            }
            else
            {
                xPosition = xPosition + size;
            }
        }

    }
}
