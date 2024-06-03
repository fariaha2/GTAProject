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
    private JButton bakeryButton;
    private JButton atBeach;
    private JButton goToCasino;
    private JButton outside;
    private JButton menu;
    private JButton home;
    private JButton slots;
    private JButton blackjack;
    private BufferedImage background;
    private BufferedImage food;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle internetButton;
    private Rectangle purchases;
    private boolean internet=false;
    private boolean phoneActive = false;
    private boolean isOutside = false;
    private boolean bakeryTrue=false;
    private boolean buying=false;
    private boolean atCasino=false;
    private BufferedImage dialogueBox;
    private BufferedImage phoneImage;
    private BufferedImage internetPage;
    private BufferedImage farm;
    private int count=-1;
    private ArrayList<Rectangle> menuItems;
    private ArrayList<String> fileNames;
    private ArrayList<Properties> properties;


    public GraphicsPanel(String n) {
        try {
            dialogueBox = ImageIO.read(new File("src/assets/DialogueBox.png"));
            phoneImage = ImageIO.read(new File("src/assets/iFruit.png"));
            background = ImageIO.read(new File("src/assets/Simeon.png"));
            internetPage = ImageIO.read(new File("src/assets/IMG_1571.png"));
        } catch (IOException g) {
            System.out.println(g.getMessage());
        }
        fileNames = new ArrayList<>();
        setFileNames();
        setUpProperties();
        name = n;
        player = new Player();
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        phone = new JButton("Access Phone");
        bakeryButton = new JButton("Go to Bakery");
        goToCasino = new JButton("Go to Casino");
        outside = new JButton("Yes");
        menu = new JButton("Menu");
        atBeach = new JButton("Go to Beach");
        home = new JButton("Go Home");
        slots = new JButton("Hit the Slots");
        blackjack = new JButton("Play Blackjack");
        slots.setFocusable(false);
        blackjack.setFocusable(false);
        home.setFocusable(false);
        atBeach.setFocusable(false);
        menu.setFocusable(false);
        outside.setFocusable(false);
        bakeryButton.setFocusable(false);
        goToCasino.setFocusable(false);
        phone.setFocusable(false);
        add(phone);
        add(outside);
        add(bakeryButton);
        add(goToCasino);
        add(menu);
        add(atBeach);
        add(home);
        add(slots);
        add(blackjack);
        phone.addActionListener(this);
        bakeryButton.addActionListener(this);
        goToCasino.addActionListener(this);
        outside.addActionListener(this);
        menu.addActionListener(this);
        atBeach.addActionListener(this);
        home.addActionListener(this);
        slots.addActionListener(this);
        blackjack.addActionListener(this);
        menu.setVisible(false);
        atBeach.setVisible(false);
        bakeryButton.setVisible(false);
        goToCasino.setVisible(false);
        home.setVisible(false);
        slots.setVisible(false);
        blackjack.setVisible(false);
        internetButton = new Rectangle(350, 250, 40, 40);
        purchases = new Rectangle(280, 100, 200, 40);
        menuItems = new ArrayList<>();
        int yC = 110;
        int xC = 50;
        for(int i=0; i<34; i++) {
            if(i==11) {
                xC=250;
                yC=110;
            }
            if(i==22) {
                xC=450;
                yC=110;
            }
            Rectangle rectangle = new Rectangle(xC, yC, 145, 22);
            yC=yC+30;
            menuItems.add(rectangle);
        }

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(count<0) {
            g.drawImage(background, 0, 0, null);
        }
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        if(phoneActive) {
            if(internet) {
                if(buying) {
                    try {
                        background = ImageIO.read(new File("src/assets/USMAP.png"));
                    } catch (IOException f) {
                        f.getMessage();
                    }
                    g.setFont(new Font("Arial", Font.BOLD, 22));
                    g.drawString("Welcome to the property map! Click on the red dots to view info", 5, 460);
                    //g.fillRect(50, 50, 150, 90);
                    g.drawRect(350, 350, 10, 10);
                    g.setColor(Color.red);
                    g.fillOval(200, 200, 10, 10); // colorado
                    g.fillOval(530, 350, 10, 10); // florida
                    g.fillOval(300, 170, 10, 10); // nebraska
                    g.fillOval(550, 150, 10, 10); // penn
                    g.fillOval(320, 300, 10, 10); // texas
                    g.fillOval(50, 220, 10, 10); // cali
                    g.fillOval(120, 100, 10, 10); // idaho
                    g.fillOval(530, 240, 10, 10); // north c
                    g.fillOval(350, 70, 10, 10); // minn
                    g.fillOval(410, 170, 10, 10); // illinois
                } else {
                    g.drawImage(internetPage, 250, 0, this);
                }
            } else {
                g.drawImage(phoneImage, 250, 0, this);
            }
        } else if(bakeryTrue) {
            atBeach.setVisible(false);
            bakeryButton.setVisible(false);
            if(count==-1 || count==-2) {
                g.drawImage(dialogueBox, 165, 230, this);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.ITALIC, 25));
                g.drawString("Click to continue", 480, 450);
            }
            g.setFont(new Font("ARIAL", Font.BOLD, 25));
            g.setColor(Color.pink);
            if(count==-1) {
                g.drawString("Welcome to the bakery!", 200, 300);
            } else if(count==-2){
                g.drawString("What would you like ", 200, 270);
                g.drawString("to order?", 200, 310);
                menu.setVisible(true);
                menu.setLocation(550, 270);
            } else if(count<0){
                g.drawImage(background, 20, 0, null);
                g.setColor(Color.black);
                g.drawString("Click to order", 480, 450);

            } else {
                try {
                    background = ImageIO.read(new File("src/DialogueBox.png"));
                } catch (IOException gjhfj) {
                    gjhfj.getMessage();
                }
            }
        } else if(atCasino) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Welcome! What are you trying to do?", 80, 150);
            slots.setVisible(true);
            blackjack.setVisible(true);
            slots.setLocation(135, 175);
            blackjack.setLocation(435, 175);
        } else if(isOutside) {
            try {
                background = ImageIO.read(new File("src/assets/Outside.png"));
            } catch (IOException a) {
                System.out.println(a.getMessage());
            }
            phone.setVisible(false);
            bakeryButton.setVisible(true);
            atBeach.setVisible(true);
            goToCasino.setVisible(true);
            home.setVisible(true);
            outside.setVisible(false);
            menu.setVisible(false);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Where would you like to go?", 125, 150);
            bakeryButton.setLocation(125, 200);
            atBeach.setLocation(425, 200);
            goToCasino.setLocation(275, 200);
            home.setLocation(285, 250);
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
    public void setFileNames() {
        fileNames.add("0_apple_pie_dish");
        fileNames.add("1_bacon_dish");
        fileNames.add("2_burger_napkin");
        fileNames.add("3_cheesecake_dish");
        fileNames.add("4_chocolatecake_dish");
        fileNames.add("5_cookies_dish");
        fileNames.add("6_donut_dish");
        fileNames.add("7_dumplings_dish");
        fileNames.add("8_eggtart_dish");
        fileNames.add("9_frenchfries_dish");
        fileNames.add("10_fruitcake_dish");
        fileNames.add("11_garlicbread_dish");
        fileNames.add("12_giantgummybear_dish");
        fileNames.add("13_gingerbreadman_dish");
        fileNames.add("14_hotdog_dish");
        fileNames.add("15_icecream_bowl");
        fileNames.add("16_jelly_dish");
        fileNames.add("17_lemonpie_dish");
        fileNames.add("18_macncheese_dish");
        fileNames.add("19_nacho_dish");
        fileNames.add("20_pudding_dish");
        fileNames.add("21_pancakes_dish");
        fileNames.add("22_pizza_dish");
        fileNames.add("23_popcorn_bowl");
        fileNames.add("24_roastedchicken_dish");
        fileNames.add("25_ramen");
        fileNames.add("26_salmon_dish");
        fileNames.add("27_strawberrycake_dish");
        fileNames.add("28_sandwich_dish");
        fileNames.add("29_sushi_dish");
        fileNames.add("30_waffle_dish");
    }
    public void setUpProperties() {
        properties = new ArrayList<>();
        /*
            Properties one = new Properties();
            Properties two = new Properties();
            Properties three = new Properties();
            Properties four = new Properties();
            Properties five = new Properties();
            Properties six = new Properties();
            Properties seven = new Properties();
            Properties eight = new Properties();
            Properties nine = new Properties();
            Properties ten = new Properties();
         */
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
            count--;
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if (phoneActive) {
            if (internetButton.contains(e.getPoint())) {
                internet=true;
            }
            if(purchases.contains(e.getPoint())) {
                buying=true;
            }
            if(buying) {

            }
        }
       for(int i=0; i<menuItems.size(); i++) {
           if(menuItems.get(i).contains(e.getPoint())) {
               count=i;
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
                } else {
                    phoneActive=false;
                    internet=false;
                    buying=false;
                }
            } else if(button==outside) {
                isOutside=true;
            } else if(button==bakeryButton) {
                goToCasino.setVisible(false);
                home.setVisible(false);
                bakeryTrue=true;
                try {
                    background = ImageIO.read(new File("src/assets/BakeryEntrance.png"));
                } catch (IOException eh) {
                    System.out.println(eh.getMessage());
                }
            } else if(button==menu) {
                menu.setVisible(false);
                count++;
                try {
                    background = ImageIO.read(new File("src/assets/Menu2.png"));
                } catch(IOException tired) {
                    System.out.println(tired.getMessage());
                }
            } else if(button==goToCasino) {
                atCasino=true;
                bakeryButton.setVisible(false);
                home.setVisible(false);
                atBeach.setVisible(false);
                goToCasino.setVisible(false);
                try {
                    background = ImageIO.read(new File("src/assets/Casino/CasinoImage.png"));
                } catch (IOException g) {
                    g.getMessage();
                }
            } else if(button==home) {
                isOutside=false;
                bakeryTrue=false;
                bakeryButton.setVisible(false);
                goToCasino.setVisible(false);
                atBeach.setVisible(false);
                home.setVisible(false);
                try {
                    background = ImageIO.read(new File("src/assets/Simeon.png"));
                } catch (IOException h) {
                    h.getMessage();
                }

            }

        }
    }
}
