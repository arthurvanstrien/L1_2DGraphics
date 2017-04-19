import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;

/**
 * Created by Arthur on 30-3-2017.
 */
public class AnimatedText extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    int buttonPressed;
    int positionX;
    int positionY;
    int counter;
    int scale;
    float hueLeft;
    float hueRight;
    float shiftHueValue;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Text");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new AnimatedText());
        frame.setVisible(true);
    }

    public AnimatedText() {
        addMouseMotionListener(this);
        addMouseListener(this);
        scale = 75;
        shiftHueValue = (float) 1 / 255;
        hueLeft = 0;
        hueRight = shiftHueValue * 127;
        buttonPressed = 0;
        positionX = 200; //Start position X
        positionY = 200; //Start position Y
        counter = 0;
        Timer timer = new Timer(1000 / 60, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        Font font = new Font("Monospaced", Font.BOLD, scale);
        String string = "Number of frames: " + counter;
        int textWidth = graphics2D.getFontMetrics().stringWidth(string);
        GradientPaint gradientPaint = new GradientPaint(positionX, positionY, Color.getHSBColor(hueLeft, 1, 1), textWidth, (scale / 3) * 2, Color.getHSBColor(hueRight, 1, 1));
        graphics2D.setPaint(gradientPaint);
        setFont(font);
        graphics2D.drawString(string, positionX, positionY);
    }

    public void update(int positionX, int positionY)
    {
        if(hueRight < 1)
            hueRight = hueRight + shiftHueValue;
        else
            hueRight = 0;

        if(hueLeft < 1)
            hueLeft = hueLeft + shiftHueValue;
        else
            hueLeft = 0;

        counter++;
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        update(positionX, positionY);
    }

    @Override
    public void mouseEntered(MouseEvent event) {}

    @Override
    public void mouseExited(MouseEvent event) {}

    @Override
    public void mouseMoved(MouseEvent event) {}

    @Override
    public void mouseClicked(MouseEvent event)
    {
        if(event.getButton() == 3)
        {
            if(scale == 50)
                scale = 75;
            else if (scale == 75)
                scale = 100;
            else if (scale == 100)
                scale = 50;
            else
                scale = 50;
        }
    }

    @Override
    public void mousePressed(MouseEvent event)
    {
        if(event.getButton() == 1)
        {
            buttonPressed = 1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
        if(event.getButton() == 1)
        {
            buttonPressed = 0;
        }
    }

    @Override
    public void mouseDragged(MouseEvent event)
    {
        int oldPositionX = 0;
        int oldPositionY = 0;

        if(buttonPressed == 1)
        {
            oldPositionX = positionX;
            oldPositionY = positionY;

            Point point = event.getPoint();
            positionX = point.x;
            positionY = point.y;
        }
    }
}
