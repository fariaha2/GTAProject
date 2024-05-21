import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class GraphicsPanel extends JPanel implements ActionListener {
    private JButton phone;
    private JButton exit;
    private JButton phoneCall;
    private BufferedImage background;
    private int tier;
    private int money;
    private String name;

    public GraphicsPanel(String n) {
        tier=1;
        money=50000;
        name=n;

    }
    public void loadingScreen(Graphics g) {
        super.paintComponent(g);
       // try {

        //} catch (IOException e) {

       // }
        g.drawString("Fun fact:", 350, 400);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == phone) {
                try {
                   ImageIO.read(new File("src/iFruit.png"));
                } catch (IOException f) {
                    System.out.println(f.getMessage());
                }
            } else if(button==exit){

            } else if(button==phoneCall) {

            }
        }
    }
}
