/**
 * Created by Arthur on 1-2-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Disco extends JPanel implements ActionListener {
    public static void main (String[] args) {
        JFrame frame = new JFrame("MyFirstJava2DApplication");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Disco());
        frame.setVisible(true);
    }

    public Disco()
    {
        Timer timer = new Timer(16, this);
        timer.start();// Start the timer here.
    }


    public void paintComponent(Graphics g) {
        int positionX = 0;
        int positionY = 0;
        int sizeX = 100;
        int sizeY = 100;
        double randomNumber;


        super.paintComponent(g);
        Graphics2D grapics2D = (Graphics2D) g;

        //grapics2D.drawLine(10, 30, 100, 100);
        //grapics2D.scale(10, 10);
        //grapics2D.drawString("Dambord", 10, 10);

        for (int i = 0; i < 20; i++) {
            positionY = 0;

            for (int j = 0; j < 40; j++) {
                randomNumber = Math.random();
                Color randomColor = Color.getHSBColor((float) randomNumber, 1, 1);

                grapics2D.setColor(randomColor);
                grapics2D.fillRect(positionY, positionX, sizeY, sizeX);

                positionY = positionY + sizeY;
            }

            positionX = positionX + sizeX;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}