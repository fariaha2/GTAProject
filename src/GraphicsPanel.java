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
    private JButton bakeryTemp;
    private JButton outside;
    private BufferedImage background;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle mailButton;
    private boolean phoneActive = false;
    private boolean isOutside = false;
    private boolean bakeryTrue=false;
    private Image img;
    private int count=1;


    public GraphicsPanel(String n) {
        try {
            img = ImageIO.read(new File("src/assets/DialogueBox.png"));
        } catch (IOException g) {
            System.out.println(g.getMessage());
        }
        try {
            if(phoneActive) {
                background = ImageIO.read(new File("src/assets/iFruit.png"));
            } else if(isOutside) {
                background=null;
            } else {
                background = ImageIO.read(new File("src/assets/Simeon.png"));
            }
        } catch (IOException f) {
            System.out.println(f.getMessage());
        }
        name = n;
        player = new Player();
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        phone = new JButton("Access Phone");
        bakeryTemp = new JButton("Go to Bakery");
        outside = new JButton("Yes");
        add(phone);
        add(outside);
        add(bakeryTemp);
        phone.addActionListener(this);
        bakeryTemp.addActionListener(this);
        outside.addActionListener(this);
        mailButton = new Rectangle(100, 150, 50, 50);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        if(bakeryTrue) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.ITALIC, 25));
            g.drawString("Click to continue", 480, 450);
            g.setFont(new Font("ARIAL", Font.BOLD, 25));
            g.setColor(Color.pink);
            if(count==1) {
                g.drawString("Welcome to the bakery!", 200, 300);
            } else {
                g.drawString("What would you like to order?", 200, 300);
            }
            //g.drawImage(img, 45, 23, );
        } else {
            g.drawImage(player.getSprite(), player.getxCoord(), player.getyCoord(), null);
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
            if (player.getxCoord() <= 375 && player.getxCoord() >= 300 && player.getyCoord() >= 400 && player.getyCoord() <= 450) {
                outside.setVisible(true);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Would you like to leave the house?", 100, 250);
            }
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
    public void mouseClicked(MouseEvent e) {
        if(bakeryTrue) {
            count++;
        }
    }
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
                if(!phoneActive) {
                    phoneActive=true;
                    System.out.println("true");
                } else {
                    phoneActive=false;
                    System.out.println("false");
                }
            } else if(button==outside) {
                isOutside=true;
            } else if(button==bakeryTemp) {
                bakeryTrue=true;
                try {
                    background = ImageIO.read(new File("src/assets/BakeryEntrance.png"));
                } catch (IOException eh) {
                    System.out.println(eh.getMessage());
                }
            }
        }
    }
}
