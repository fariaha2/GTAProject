import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private JTextField textField;
    private JButton phone;
    private JButton bakeryButton;
    private JButton atBeach;
    private JButton goToCasino;
    private JButton outside;
    private JButton menu;
    private JButton home;
    private JButton slots;
    private JButton blackjack;
    private JButton back;
    private JButton buy;
    private JButton hit;
    private JButton stand;
    private JButton pay;
    private JButton submit;
    private BufferedImage background;
    private BufferedImage food;
    private BufferedImage img1;
    private BufferedImage cardOneEnemy;
    private BufferedImage cardTwoEnemy;
    private BufferedImage cardOnePlayer;
    private BufferedImage cardTwoPlayer;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle internetButton;
    private Rectangle callLamar;
    private Rectangle callSimeon;
    private Rectangle purchases;
    private Rectangle contactsButton;
    private boolean internet=false;
    private boolean phoneActive = false;
    private boolean isOutside = false;
    private boolean bakeryTrue=false;
    private boolean buying=false;
    private boolean atCasino=false;
    private boolean playingblackjack=false;
    private boolean dealed=false;
    private boolean bet =false;
    private boolean draw=false;
    private boolean contacts=false;
    private BufferedImage dialogueBox;
    private BufferedImage phoneImage;
    private BufferedImage internetPage;
    private BufferedImage contactsPage;
    private BufferedImage farm;
    private int count=-1;
    private int chill;
    int turn=1;
    int playerScore;
    int enemyScore;
    private int betAmount;
    private int cardTurnPlayer=11;
    private int enemyTurnCard=21;
    int playerCards;
    int enemyCards;
    private ArrayList<Rectangle> menuItems;
    private ArrayList<String> fileNames;
    private ArrayList<Property> properties;
    private ArrayList<Rectangle> propertyRects;


    public GraphicsPanel(String n) {
        try {
            dialogueBox = ImageIO.read(new File("src/assets/DialogueBox.png"));
            phoneImage = ImageIO.read(new File("src/assets/iFruit.png"));
            background = ImageIO.read(new File("src/assets/Simeon.png"));
            internetPage = ImageIO.read(new File("src/assets/IMG_1571.png"));
            contactsPage = ImageIO.read(new File("src/Assets/ContactsPhone.png"));
        } catch (IOException g) {
            System.out.println(g.getMessage());
        }
        textField = new JTextField(20);
        fileNames = new ArrayList<>();
        properties = new ArrayList<>();
        propertyRects = new ArrayList<>();
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
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        pay = new JButton("Pay");
        submit = new JButton("Submit");
        buy = new JButton("Buy");
        back = new JButton("Go Back");
        slots.setFocusable(false);
        blackjack.setFocusable(false);
        hit.setFocusable(false);
        stand.setFocusable(false);
        pay.setFocusable(false);
        submit.setFocusable(false);
        buy.setFocusable(false);
        back.setFocusable(false);
        home.setFocusable(false);
        atBeach.setFocusable(false);
        menu.setFocusable(false);
        outside.setFocusable(false);
        bakeryButton.setFocusable(false);
        goToCasino.setFocusable(false);
        phone.setFocusable(false);
        add(textField);
        add(phone);
        add(pay);
        add(submit);
        add(outside);
        add(bakeryButton);
        add(goToCasino);
        add(menu);
        add(atBeach);
        add(home);
        add(slots);
        add(blackjack);
        add(hit);
        add(stand);
        add(back);
        add(buy);
        hit.addActionListener(this);
        stand.addActionListener(this);
        phone.addActionListener(this);
        bakeryButton.addActionListener(this);
        goToCasino.addActionListener(this);
        outside.addActionListener(this);
        menu.addActionListener(this);
        atBeach.addActionListener(this);
        home.addActionListener(this);
        slots.addActionListener(this);
        blackjack.addActionListener(this);
        back.addActionListener(this);
        buy.addActionListener(this);
        menu.setVisible(false);
        atBeach.setVisible(false);
        bakeryButton.setVisible(false);
        goToCasino.setVisible(false);
        home.setVisible(false);
        slots.setVisible(false);
        blackjack.setVisible(false);
        back.setVisible(false);
        buy.setVisible(false);
        hit.setVisible(false);
        stand.setVisible(false);
        pay.setVisible(false);
        submit.setVisible(false);
        textField.setVisible(false);
        internetButton = new Rectangle(350, 250, 40, 40);
        contactsButton = new Rectangle(350, 175, 40, 40);
        callSimeon = new Rectangle(280, 100, 200, 40);
        callLamar = new Rectangle(280, 140, 200, 40);
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
       // if(count<0) {
        g.drawImage(background, 0, 0, null);
        //}
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        if(phoneActive) {
            if(internet) {
                if(buying) {
                    if(count==-1) {
                        phone.setLocation(485, 30);
                        back.setVisible(false);
                        try {
                            background = ImageIO.read(new File("src/assets/USMAP.png"));
                        } catch (IOException f) {
                            f.getMessage();
                        }
                        g.setFont(new Font("Arial", Font.BOLD, 22));
                        g.drawString("Welcome to the property map! Click on the red dots to view info", 5, 460);
                        g.setColor(Color.red);
                        g.fillOval(200, 200, 10, 10); // colorado
                        g.fillOval(530, 350, 10, 10); // florida
                        g.fillOval(300, 170, 10, 10); // nebraska
                        g.fillOval(580, 120, 10, 10); // new york
                        g.fillOval(320, 300, 10, 10); // texas
                        g.fillOval(50, 220, 10, 10); // cali
                        g.fillOval(120, 100, 10, 10); // idaho
                        g.fillOval(530, 240, 10, 10); // north c
                        g.fillOval(350, 70, 10, 10); // minn
                        g.fillOval(410, 170, 10, 10); // illinois
                    } else if(count>=0){
                        phone.setLocation(485, 30);
                        try {
                            background = ImageIO.read(new File("src/assets/Properties/WhiteBackground.png"));
                        } catch (IOException f) {
                            f.getMessage();
                        }
                        g.drawImage(properties.get(count).getImage(), 10, 10, null);
                        g.drawString("Price: $" + properties.get(count).getPrice(), 10,240);
                        g.drawString("Money per minute: $" + properties.get(count).getRate(), 10, 280);
                        g.drawString("Type: " + properties.get(count).getType(), 10, 320);
                        g.setFont(new Font("Arial", Font.BOLD, 15));
                        g.drawString(properties.get(count).getDescription(), 10, 360);
                        back.setVisible(true);
                        buy.setVisible(true);
                        back.setLocation(550, 400);
                        buy.setLocation(450, 400);

                    } else if(count==-3){
                        g.setFont(new Font("Arial", Font.BOLD, 25));
                        g.drawString("CONGRATS!", 275, 200);
                        g.drawString("You just bought some property!", 170, 225);
                        buy.setVisible(false);
                        back.setLocation(550, 400);
                        phone.setLocation(485, 30);
                    }
                } else {
                    g.drawImage(internetPage, 250, 0, this);
                }
            } else if(contacts) {
                g.drawImage(contactsPage, 250, 0, null);
            } else {
                g.drawImage(phoneImage, 250, 0, this);
            }
        } else if(bakeryTrue) {
            g.drawImage(background, 0, 0, null);
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
                for(int i=0; i<menuItems.size(); i++) {
                    double x =  menuItems.get(i).getX();
                    double y =  menuItems.get(i).getY();
                    double w= menuItems.get(i).getWidth();
                    double h = menuItems.get(i).getHeight();
                    g.drawRect((int) x,(int) y,(int) w,(int) h);
                }
            } else if(count<=-2){
                //g.drawImage(background, 20, 0, null);
                g.setColor(Color.black);
                g.drawString("Click to order", 480, 450);

            } else {
                if(chill==4) {
                    g.drawImage(player.getSprite(), 350, 250, null);
                    try {
                        background = ImageIO.read(new File("src/assets/Simeon.png"));
                    } catch (IOException qw) {
                        qw.getMessage();
                    }
                    isOutside=false;
                    bakeryTrue=false;
                    bakeryButton.setVisible(false);
                    goToCasino.setVisible(false);
                    atBeach.setVisible(false);
                    home.setVisible(false);
                }
                try {
                    background = ImageIO.read(new File("src/Assets/Booth.png"));
                    food = ImageIO.read(new File("src/Assets/Food/" + fileNames.get(count) + ".png"));
                } catch (IOException gjhfj) {
                    gjhfj.getMessage();
                }
                g.drawImage(food, 350, 250, this);
                g.setColor(Color.WHITE);
                g.drawString("Click on it to eat!", 250, 450);

            }
        } else if(atCasino) {
            if(playingblackjack) {
                try {
                    background = ImageIO.read(new File("src/assets/Casino/BlackjackTable.png"));
                } catch (IOException a) {
                    System.out.println(a.getMessage());
                }
                if(!bet) {
                    g.drawString("How much are you betting?", 300, 250);
                    textField.setLocation(320, 350);
                    submit.setLocation(340, 370);
                } else {
                    if(!dealed) {
                        drawCards(0);
                        dealed=true;
                    }
                    if(playerScore>=21) {
                        g.drawString("YOU LOST! Pay up!", 260, 245);
                        pay.setLocation(280, 300);
                    } else if(enemyScore>=21) {
                        g.drawString("YOU WON!", 280, 245);
                        player.changeMoney(betAmount*-1);
                        playingblackjack=false;
                        dealed=false;
                        bet=false;
                    } else {
                        g.drawImage(cardOneEnemy, 265, 100, null);
                        g.drawImage(cardTwoEnemy, 345, 100, null);
                        g.drawImage(cardOnePlayer, 265, 280, null);
                        g.drawImage(cardTwoPlayer, 345, 280, null);
                        g.drawString("Dealer: " + enemyScore, 280, 230);
                        g.drawString("You: " + playerScore, 280, 260);
                        if(turn==1) {
                            g.drawString("Hit or Stand?",480, 255);
                            hit.setVisible(true);
                            stand.setVisible(true);
                            hit.setLocation(490, 275);
                            stand.setLocation(540, 275);
                        } else {
                            if(enemyScore>=18) {
                                turn=1;
                            } else {

                            }
                        }
                    }
                }
            } else {
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Welcome! What are you trying to do?", 80, 150);
                slots.setVisible(true);
                blackjack.setVisible(true);
                slots.setLocation(135, 175);
                blackjack.setLocation(435, 175);
            }
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
            if(!bakeryTrue) {
                count=-1;
            }
            if (player.getxCoord() <= 375 && player.getxCoord() >= 300 && player.getyCoord() >= 400 && player.getyCoord() <= 450) {
                outside.setVisible(true);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Would you like to leave the house?", 100, 250);
            }
        }
    }
    public void playEating() {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/Assets/NumNumNum.wav").getAbsoluteFile());
            Clip eating = AudioSystem.getClip();
            eating.open(audioInputStream);
            eating.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void drawCards(int n) {
        if(!dealed) {
            for (int i = 0; i < 4; i++) {
                int rand1 = (int) (Math.random() * 13) + 1;
                int rand3 = (int) (Math.random() * 8) + 1;
                String card = "src/assets/Casino/Cards/";
                if (rand1 == 13) {
                    card = card + "K" + rand3;
                } else if (rand1 == 12) {
                    card = card + "Q" + rand3;
                } else if (rand1 == 11) {
                    card = card + "J" + rand3;
                } else if (rand1 == 1) {
                    card = card + "A." + rand3;
                } else {
                    card = card + rand1 + "." + rand3;
                }
                try {
                    if (i == 1) {
                        cardOneEnemy = ImageIO.read(new File(card + ".png"));
                        enemyScore = enemyScore + rand1;
                    } else if (i == 2) {
                        cardTwoEnemy = ImageIO.read(new File(card + ".png"));
                        enemyScore = enemyScore + rand1;
                    } else if (i == 3) {
                        cardOnePlayer = ImageIO.read(new File(card + ".png"));
                        playerScore = playerScore + rand1;
                    } else {
                        cardTwoPlayer = ImageIO.read(new File(card + ".png"));
                        playerScore = playerScore + rand1;
                    }
                } catch (IOException fe) {
                    System.out.println(fe.getMessage());
                }
            }
        } else {
            int rand1 = (int) (Math.random() * 13) + 1;
            int rand3 = (int) (Math.random() * 8) + 1;
            String card = "src/assets/Casino/Cards/";
            if (rand1 == 13) {
                card = card + "K" + rand3;
            } else if (rand1 == 12) {
                card = card + "Q" + rand3;
            } else if (rand1 == 11) {
                card = card + "J" + rand3;
            } else if (rand1 == 1) {
                card = card + "A." + rand3;
            } else {
                card = card + rand1 + "." + rand3;
            }
            try {
                if(n==11) {
                    cardOnePlayer = ImageIO.read(new File(card + ".png"));
                    cardTurnPlayer=12;
                    playerScore=playerScore+rand1;
                } else if(n==12) {
                    cardTwoPlayer = ImageIO.read(new File(card + ".png"));
                    cardTurnPlayer=11;
                    playerScore=playerScore+rand1;
                } else if(n==21) {
                    cardOneEnemy = ImageIO.read(new File(card + ".png"));
                    cardTurnPlayer=22;
                    enemyScore=enemyScore+rand1;
                } else {
                    cardTurnPlayer=21;
                    enemyScore=enemyScore+rand1;
                    cardTwoEnemy = ImageIO.read(new File(card + ".png"));
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
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
        Property one = new Property(100000, 7500, 120, 100, "Idaho", "BestFarm",
                "The largest potato farm in Idaho.", "Farm");
        Property two = new Property(75000, 5000, 300, 170, "Nebraska", "GoodFarm",
                "This is where a quarter of the nation's flour comes from.", "Farm");
        Property three = new Property(50000, 3500, 350, 70, "Minnesota", "AverageFarm",
                "A locally owned farm. They get some business.", "Farm");
        Property four = new Property(25000, 2000, 410, 170, "Illinois", "MidLevelFarm",
                "Some woman is offering to let us take a cut of her produce sales.", "Farm");
        Property five = new Property(10000, 1000, 320, 300, "Texas" , "PoorFarm",
                "Nobody knows what happened to this farm, but it makes money.", "Farm");
        Property six = new Property(150000, 10000, 580, 120, "New York", "BestStore",
                "The biggest Walmart in the country.", "Store");
        Property seven = new Property(100000, 7500, 50, 220, "California", "GoodStore",
                "It's just target.", "Store");
        Property eight = new Property(50000, 5000, 530, 240, "North Carolina", "AverageStore",
                "Best Buy. Nobody goes here often.", "Store");
        Property nine = new Property(25000, 3000, 350, 70, "Minnesota", "MidLevelStore",
                "A really fancy Walgreens.", "Store");
        Property ten = new Property(7500, 400,200, 200, "Colorado", "PoorStore",
                "The owner is just trying to get rid of it. It doesn't make much money.", "Store");
        Rectangle on = new Rectangle(120, 100, 10, 10);
        Rectangle tw = new Rectangle(300, 170, 10, 10);
        Rectangle thre = new Rectangle(350, 70, 10, 10);
        Rectangle fou = new Rectangle(410, 170, 10 ,10);
        Rectangle fiv = new Rectangle(320, 300, 10, 10);
        Rectangle si = new Rectangle(580, 120, 10, 10);
        Rectangle seve = new Rectangle(50, 220, 10, 10);
        Rectangle eigh = new Rectangle(530, 240, 10, 10);
        Rectangle nin = new Rectangle(350, 70, 10, 10);
        Rectangle te = new Rectangle(200, 200, 10, 10);
        properties.add(one);
        properties.add(two);
        properties.add(three);
        properties.add(four);
        properties.add(five);
        properties.add(six);
        properties.add(seven);
        properties.add(eight);
        properties.add(nine);
        properties.add(ten);
        propertyRects.add(on);
        propertyRects.add(tw);
        propertyRects.add(thre);
        propertyRects.add(fou);
        propertyRects.add(fiv);
        propertyRects.add(si);
        propertyRects.add(seve);
        propertyRects.add(eigh);
        propertyRects.add(nin);
        propertyRects.add(te);

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
            if(count<0) {
                count--;
            }
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if (phoneActive) {
            if(contacts) {
                if(callSimeon.contains(e.getPoint())) {
                    System.out.println("calling simeon");
                } else if(callLamar.contains(e.getPoint())) {
                    System.out.println("calling lamar");
                }
            }
            if(contactsButton.contains(e.getPoint())) {
                contacts=true;
            }
            if (internetButton.contains(e.getPoint())) {
                internet=true;
            }
            if(purchases.contains(e.getPoint())) {
                buying=true;
            }
            if(buying) {
                for(int i=0; i<propertyRects.size(); i++) {
                    if(propertyRects.get(i).contains(e.getPoint())) {
                        count=i;
                    }
                }
            }
        }
        if(bakeryTrue) {
            if(count<=-2) {
                for (int i = 0; i < menuItems.size(); i++) {
                    if (menuItems.get(i).contains(e.getPoint())) {
                        count = i;
                    }
                }
            } else {
                Rectangle rect = new Rectangle(350, 250, 200, 200);
                if(rect.contains(e.getPoint())) {
                    playEating();
                }
                chill++;
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
                    contacts=false;
                    buy.setVisible(false);
                    back.setVisible(false);
                    count=-1;
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
                count--;
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
                if(playingblackjack) {
                    try {
                        background = ImageIO.read(new File("src/Assets/Casino/BlackjackTable.png"));
                    } catch (IOException eft) {
                        eft.getMessage();
                    }
                } else {
                    try {
                        background = ImageIO.read(new File("src/assets/Casino/CasinoImage.png"));
                    } catch (IOException g) {
                        g.getMessage();
                    }
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

            } else if(button==back) {
                if(phoneActive) {
                    count = -1;
                }
            } else if(button==buy) {
                if(player.getMoney()>=properties.get(count).getPrice()) {
                    player.changeMoney(-1*properties.get(count).getPrice());
                    properties.get(count).setPurchased();
                    count = -3;
                }
            } else if(button==blackjack) {
                playingblackjack=true;
                blackjack.setVisible(false);
                slots.setVisible(false);
            } else if(button==hit) {
                drawCards(cardTurnPlayer);
            } else if(button==stand) {
                turn=2;
            } else if(button==pay) {
                player.changeMoney(-1*betAmount);
                playingblackjack=false;
                dealed=false;
                bet=false;
            } else if(button==submit) {
                betAmount = Integer.parseInt(textField.getText());
                bet=true;
            }

        }
    }
}
