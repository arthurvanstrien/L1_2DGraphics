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
        Color red = Color.RED;
        Color green = Color.GREEN;
        Color blue = Color.BLUE;
        Color yellow = Color.YELLOW;
        Color cyan = Color.CYAN;
        Color magenta = Color.MAGENTA;
        Color white = Color.WHITE;
        Color black = Color.BLACK;
        Color gray = Color.GRAY;
        Color lightGray = Color.LIGHT_GRAY;
        Color darkGray = Color.DARK_GRAY;
        Color orange = Color.ORANGE;
        Color pink = Color.PINK;


    }
}
