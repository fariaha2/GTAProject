import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private JButton phone;
    private JButton bakeryButton;
    private JButton outside;
    private JButton menu;
    private BufferedImage background;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle mailButton;
    private boolean phoneActive = false;
    private boolean isOutside = false;
    private boolean bakeryTrue=false;
    private BufferedImage dialogueBox;
    private BufferedImage phoneImage;
    private BufferedImage menuImage;
    private int count=1;


    public GraphicsPanel(String n) {
        try {
            dialogueBox = ImageIO.read(new File("src/assets/DialogueBox.png"));
            phoneImage = ImageIO.read(new File("src/assets/iFruit.png"));
            background = ImageIO.read(new File("src/assets/Simeon.png"));
        } catch (IOException g) {
            System.out.println(g.getMessage());
        }
        name = n;
        player = new Player();
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        phone = new JButton("Access Phone");
        bakeryButton = new JButton("Go to Bakery");
        outside = new JButton("Yes");
        menu = new JButton("Menu");
        JLabel picLabel = new JLabel(new ImageIcon(dialogueBox));
        JLabel phoneLabel = new JLabel(new ImageIcon(phoneImage));
        add(picLabel);
        add(phoneLabel);
        picLabel.setVisible(false);
        phoneLabel.setVisible(false);
        add(phone);
        add(outside);
        add(bakeryButton);
        add(menu);
        phone.addActionListener(this);
        bakeryButton.addActionListener(this);
        outside.addActionListener(this);
        menu.addActionListener(this);
        menu.setVisible(false);
        bakeryButton.setVisible(false);
        mailButton = new Rectangle(100, 150, 50, 50);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        if(phoneActive) {
            g.drawImage(phoneImage, 250, 0, this);
        } else if(bakeryTrue) {
            bakeryButton.setVisible(false);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.ITALIC, 25));
            g.drawString("Click to continue", 480, 450);
            g.setFont(new Font("ARIAL", Font.BOLD, 25));
            g.setColor(Color.pink);
            g.drawImage(dialogueBox, 165, 230, this);
            if(count==1) {
                g.drawString("Welcome to the bakery!", 200, 300);
            } else {
                g.drawString("What would you like ", 200, 270);
                g.drawString("to order?", 200, 310);
                menu.setVisible(true);
                menu.setLocation(550, 270);
            }
        } else if(isOutside) {
            background=null;
            phone.setVisible(false);
            bakeryButton.setVisible(true);
            outside.setVisible(false);
            menu.setVisible(false);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Where would you like to go?", 125, 100);
            bakeryButton.setLocation(125, 200);

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
    /* public void loadingScreen(Graphics g) {
        super.paintComponent(g);
       try {

       } catch (IOException e) {
       }
       g.drawString("Fun fact:", 350, 400);


    }*/
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
            } else if(button==bakeryButton) {
                bakeryTrue=true;
                try {
                    background = ImageIO.read(new File("src/assets/BakeryEntrance.png"));
                } catch (IOException eh) {
                    System.out.println(eh.getMessage());
                }
            } else if(button==menu) {
                System.out.println("wow");
            }
        }
    }
}
