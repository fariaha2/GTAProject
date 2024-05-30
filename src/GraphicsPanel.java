import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private JButton phone;
    private JButton exit;
    private JButton phoneCall;
    private JButton outside;
    private BufferedImage background;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle mailButton;
    private boolean phoneActive = false;

    public GraphicsPanel(String n) {
        try {
            background = ImageIO.read(new File("src/Simeon.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        name=n;
        player = new Player();
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        phone = new JButton("Access Phone");
        outside = new JButton("Yes");
        add(phone);
        add(outside);
        phone.addActionListener(this);
        outside.addActionListener(this);
        mailButton = new Rectangle(100, 150, 50, 50);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
     /*   if(background= ImageIO.read(new File("src/iFruit.png"))) {

        } */
        g.drawImage(background, 0, 0, null);
        g.drawImage(player.getSprite(), player.getxCoord(), player.getyCoord(), null);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        phone.setLocation(485, 30);
        phone.setVisible(true);
        outside.setVisible(false);
        outside.setLocation(125, 275);

        if (pressedKeys[65]) {
            player.moveLeft();
        }
        if (pressedKeys[68]) {
            player.moveRight();
        }
        if (pressedKeys[87]) {
            player.moveUp();
        }
        if (pressedKeys[83]) {
            player.moveDown();
        }
        if(player.getxCoord()<=375 && player.getxCoord()>=300 && player.getyCoord()>=400 && player.getyCoord()<=450) {
            outside.setVisible(true);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Would you like to leave the house?", 100, 250);
        }
    }
    public void keyTyped(KeyEvent e) { }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }
    public void mouseClicked(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if (phoneActive) {
            if (mailButton.contains(e.getPoint())) {
                System.out.println("mail!!!");
            }
        }
    }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void loadingScreen(Graphics g) {
        super.paintComponent(g);
       // try {

        //} catch (IOException e) {

       // }
        //g.drawString("Fun fact:", 350, 400);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == phone) {
                phoneActive = true;
                try {
                   background = ImageIO.read(new File("src/iFruit.png"));
                } catch (IOException f) {
                    System.out.println(f.getMessage());
                }
            } else if(button==exit){

            } else if(button==phoneCall) {

            } else if(button==outside) {
                background=null;
            }
        }
    }
}
