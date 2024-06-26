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
    private Cop one;
    private Cop two;
    private Cop three;
    private static String newLine = "\n";
    private JTextArea textArea;
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private Timer timer;
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
    private JButton propertyButton;
    private JButton homeButton;
    private JButton window;
    private JButton accept;
    private JButton deny;
    private BufferedImage background;
    private BufferedImage food;
    private BufferedImage homeImage;
    private BufferedImage cardOneEnemy;
    private BufferedImage cardTwoEnemy;
    private BufferedImage cardOnePlayer;
    private BufferedImage cardTwoPlayer;
    private BufferedImage textBox;
    private String name;
    private Player player;
    private boolean[] pressedKeys;
    private Rectangle internetButton;
    private Rectangle callLamar;
    private Rectangle callSimeon;
    private Rectangle purchases;
    private Rectangle contactsButton;
    private Rectangle tierTwo;
    private Rectangle tierThree;
    private Rectangle homeRect;
    private Rectangle leverRect;
    private Rectangle windowRect;
    private Rectangle onee;
    private Rectangle twoo;
    private boolean missionone=false;
    private boolean missiontwo=false;
    private boolean internet=false;
    private boolean phoneActive = false;
    private boolean isOutside = false;
    private boolean bakeryTrue=false;
    private boolean buying=false;
    private boolean atCasino=false;
    private boolean playingblackjack=false;
    private boolean dealed=false;
    private boolean bet;
    private boolean draw=false;
    private boolean contacts=false;
    private boolean house;
    private boolean lookingWindow;
    private boolean property;
    private boolean tier2;
    private boolean tier3;
    private boolean playingSlots;
    private boolean animationSlots;
    private BufferedImage dialogueBox;
    private BufferedImage phoneImage;
    private BufferedImage internetPage;
    private BufferedImage contactsPage;
    private BufferedImage farm;
    private int count=-1;
    private int missionCount=0;
    private int chill;
    private int turn=1;
    private int playerScore;
    private int enemyScore;
    private int betAmount;
    private int cardTurnPlayer=11;
    private int enemyTurnCard=21;
    private int playerCards;
    private int enemyCards;
    private int room;
    private int tier=1;
    private int time;
    private ArrayList<Rectangle> menuItems;
    private ArrayList<String> fileNames;
    private ArrayList<Property> properties;
    private ArrayList<Rectangle> propertyRects;


    public GraphicsPanel(String n) {
        try {
            dialogueBox = ImageIO.read(new File("src/assets/DialogueBox.png"));
            phoneImage = ImageIO.read(new File("src/assets/iFruit.png"));
            background = ImageIO.read(new File("src/assets/PropertiesHomes/TierOneHouse.png"));
            internetPage = ImageIO.read(new File("src/assets/IMG_1571.png"));
            contactsPage = ImageIO.read(new File("src/Assets/ContactsPhone.png"));
            textBox = ImageIO.read(new File("src/Assets/TextBox.png"));
        } catch (IOException g) {
            System.out.println(g.getMessage());
        }
        textArea = new JTextArea(5, 20);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setVisible(false);
        betAmount=-1;
        time = 0;
        timer = new Timer(1000, this); // this Timer will call the actionPerformed interface method every 500ms = 0.5 second
        timer.start();
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
        propertyButton = new JButton("Property");
        homeButton = new JButton("Homes");
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
        window = new JButton("Look out Window");
        accept = new JButton("Yes");
        deny = new JButton("No");
        slots.setFocusable(false);
        blackjack.setFocusable(false);
        hit.setFocusable(false);
        stand.setFocusable(false);
        pay.setFocusable(false);
        submit.setFocusable(false);
        buy.setFocusable(false);
        back.setFocusable(false);
        window.setFocusable(false);
        accept.setFocusable(false);
        deny.setFocusable(false);
        home.setFocusable(false);
        atBeach.setFocusable(false);
        menu.setFocusable(false);
        outside.setFocusable(false);
        bakeryButton.setFocusable(false);
        goToCasino.setFocusable(false);
        phone.setFocusable(false);
        propertyButton.setFocusable(false);
        homeButton.setFocusable(false);
        add(textField);
        add(phone);
        add(propertyButton);
        add(homeButton);
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
        add(window);
        add(accept);
        add(deny);
        add(buy);
        submit.addActionListener(this);
        hit.addActionListener(this);
        stand.addActionListener(this);
        phone.addActionListener(this);
        propertyButton.addActionListener(this);
        homeButton.addActionListener(this);
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
        window.addActionListener(this);
        accept.addActionListener(this);
        deny.addActionListener(this);
        pay.addActionListener(this);
        window.setVisible(false);
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
        propertyButton.setVisible(false);
        homeButton.setVisible(false);
        accept.setVisible(false);
        deny.setVisible(false);
        internetButton = new Rectangle(350, 250, 40, 40);
        contactsButton = new Rectangle(350, 175, 40, 40);
        callSimeon = new Rectangle(280, 100, 200, 40);
        callLamar = new Rectangle(280, 140, 200, 40);
        purchases = new Rectangle(280, 100, 200, 40);
        tierTwo = new Rectangle(135, 150, 100, 50);
        tierThree = new Rectangle(435, 155, 100, 50);
        homeRect = new Rectangle(10, 10, 400, 445);
        leverRect = new Rectangle(480, 150, 30, 180);
        one = new Cop(190, 50, "UD", "b", 1);
        two = new Cop(190, 350, "UD", "forward",2);
        three = new Cop(350, 200, "RL", "foward", 2);
        menuItems = new ArrayList<>();
        bet=false;
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
        accept.setVisible(false);
        deny.setVisible(false);
        blackjack.setVisible(false);
        slots.setVisible(false);
        home.setVisible(false);
        if(phoneActive || bakeryTrue || atCasino || isOutside) {
            g.drawImage(background, 0, 0, null);
        }
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.BLACK);
        g.drawString("$" + player.getMoney(), 485, 23);
        if(!phoneActive && !bakeryTrue && !atCasino && !isOutside) {
            try {
                if(tier==3) {
                    background = ImageIO.read(new File("src/assets/PropertiesHomes/TierThreeHouseOne.png"));
                } else if(tier==2) {
                    background = ImageIO.read(new File("src/assets/PropertiesHomes/TierTwoHouse.png"));
                } else {
                    background = ImageIO.read(new File("src/assets/PropertiesHomes/TierOneHouse.png"));
                }
            } catch (IOException jk) {
                jk.getMessage();
            }
            phone.setLocation(485, 30);
            phone.setVisible(true);
            outside.setVisible(false);
            outside.setLocation(125, 275);
            if(tier==1) {
                g.drawImage(background, 0, 0, null);
                windowRect = new Rectangle(60, 22, 145, 140);
            } else if(tier==2) {
                g.drawImage(background, 50, 0, null);
                windowRect = new Rectangle(260, 22, 125, 120);
            } else {
                windowRect = new Rectangle(60, 22, 145, 140);
            }
            g.drawImage(player.getSprite(), player.getxCoord(), player.getyCoord(), null);
            if(lookingWindow) {
                if(tier==1) {
                    g.drawImage(textBox, 250, 150, null);
                    g.setFont(new Font("Arial", Font.BOLD, 12));
                    g.drawString("The window is boarded up.", 270, 235);
                } else if(tier==2) {
                    try {
                        background = ImageIO.read(new File("src/assets/TierTwoBG.png"));
                    } catch (IOException ez) {
                        ez.getMessage();
                    }
                    g.drawImage(background, 0, 10, null);
                    back.setVisible(true);
                    back.setLocation(600, 400);
                } else {

                }
            }
            if(player.playerRect().intersects(windowRect)) {
                window.setVisible(true);
                window.setLocation(100, 22);
            } else {
                lookingWindow=false;
                window.setVisible(false);
            }
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
            if (player.getxCoord() <= 375 && player.getxCoord() >= 250 && player.getyCoord() >= 350 && player.getyCoord() <= 400) {
                outside.setVisible(true);
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Would you like to leave the house?", 100, 250);
            }
        } else if(phoneActive) {
            if(internet) {
                if(buying) {
                    background=null;
                    g.drawString("Are you buying a property or a home?", 125, 150);
                    phone.setLocation(485, 30);
                    propertyButton.setVisible(true);
                    homeButton.setVisible(true);
                    propertyButton.setLocation(135, 200);
                    homeButton.setLocation(475, 200);
                } else if(property) {
                    propertyButton.setVisible(false);
                    homeButton.setVisible(false);
                    if(count==-1) {
                        phone.setLocation(485, 30);
                        back.setVisible(false);
                        buy.setVisible(false);
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
                            background = ImageIO.read(new File("src/assets/PropertiesHomes/WhiteBackground.png"));
                        } catch (IOException f) {
                            f.getMessage();
                        }
                        g.drawImage(background, 0, 0, null);
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
                } else if(house){
                    phone.setLocation(485, 30);
                    propertyButton.setVisible(false);
                    homeButton.setVisible(false);
                    try {
                        background = ImageIO.read(new File("src/assets/PropertiesHomes/WhiteBackground.png"));
                    } catch (IOException e)  {
                        e.getMessage();
                    }
                    if(tier2) {
                        buy.setVisible(true);
                        buy.setLocation(10, 360);
                        try {
                            homeImage = ImageIO.read(new File("src/assets/PropertiesHomes/TierTwoResize.png"));
                        } catch (IOException e)  {
                            e.getMessage();
                        }
                        g.drawImage(homeImage, 10, 10, null);
                        g.drawString("Cost: $60,000", 10, 320);
                        g.drawString("Want to buy it?", 10, 340);

                    } else if(tier3) {
                        buy.setVisible(true);
                        buy.setLocation(470, 230);
                        try {
                            homeImage = ImageIO.read(new File("src/assets/PropertiesHomes/TierThreeOResize.png"));
                        } catch (IOException e)  {
                            e.getMessage();
                        }
                        g.drawImage(homeImage, 10, 10, null);

                        g.drawString("Cost: $100,000", 450, 70);
                        g.drawString("Want to buy it?", 450, 110);
                    } else {
                        g.drawString("Click on the tier you would like to see", 125, 100);
                        g.drawString("You are currently tier " + tier, 175, 125);
                        g.drawString("Tier 2", 135, 175);
                        g.drawString("Tier 3", 435, 175);
                    }
                } else {
                    g.drawImage(internetPage, 250, 0, this);
                }
            } else if(contacts) {
                if(missionone) {
                    //simeon mission
                    if(missionCount-1==0 || missionCount-1==1 || missionCount-1==2) {
                        try {
                            background = ImageIO.read(new File("src/assets/Casino/BlackBackground.png"));
                        } catch (IOException e) {
                            e.getMessage();
                        }
                        g.drawImage(background, 0, 0, null);
                        g.setColor(Color.WHITE);
                        g.drawImage(dialogueBox, 165, 230, this);
                        g.setFont(new Font("Arial", Font.ITALIC, 25));
                        g.drawString("Click to continue", 480, 450);
                        g.setFont(new Font("ARIAL", Font.BOLD, 25));
                        g.setColor(Color.black);
                    }
                    if(missionCount-1==0) {
                        g.drawString("Simeon wants you to", 200, 300);
                        g.drawString("steal a car.", 200, 320);
                    } else if(missionCount-1==1){
                        g.drawString("The car will be at", 200, 300);
                        g.drawString("the alley.", 200, 320);
                    } else if(missionCount-1==2) {
                        g.drawString("Avoid the cops!", 200, 300);
                    } else {
                        room=1;
                        if(room==1) {
                            try {
                                background = ImageIO.read(new File("src/assets/Missions/MissionOne.png"));
                            } catch (IOException e) {
                                e.getMessage();
                            }
                            g.drawImage(background, 0, 0, null);
                            g.drawImage(player.getSprite(), player.getMissionx(), player.getMissiony(), null);
                            g.setColor(Color.white);
                            if(time==5) {
                                one.callMove();
                                two.callMove();
                                three.callMove();
                                time=0;
                            }
                            g.drawImage(one.getSprite(), one.getxCoord(), one.getyCoord(), null);
                            g.drawImage(two.getSprite(), two.getxCoord(), two.getyCoord(), null);
                            g.drawImage(three.getSprite(), three.getxCoord(), three.getyCoord(), null);
                            g.drawRect(one.getxCoord()-10, one.getyCoord(), 100, 100);
                            g.drawRect(two.getxCoord()-10, two.getyCoord(), 100, 100);
                        }
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
                        if(player.playerRect().intersects(one.CopRect()) || player.playerRect().intersects(two.CopRect())) {
                            room=-1;
                            try {
                                background = ImageIO.read(new File("src/assets/Casino/BlackBackground.png"));
                            } catch (IOException e) {
                                e.getMessage();
                            }
                            g.drawString("GAME OVER", 350, 250);
                            home.setVisible(true);
                            home.setLocation(375, 275);
                        }
                    }

                } else if(missiontwo) {
                    //lamar mission

                } else {
                    g.drawImage(contactsPage, 250, 0, null);
                }
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
            } else if(count<=-2){
                //g.drawImage(background, 20, 0, null);
                g.setColor(Color.black);
                g.drawString("Click to order", 480, 450);

            } else {
                if(chill==4) {

                    g.drawImage(player.getSprite(), 350, 250, null);
                    try {
                        background = ImageIO.read(new File("src/assets/PropertiesHome/TierOneHouse.png"));
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
                home.setVisible(false);
                try {
                    background = ImageIO.read(new File("src/assets/Casino/BlackjackTable.png"));
                } catch (IOException a) {
                    System.out.println(a.getMessage());
                }
                if(betAmount==-1) {
                    accept.setVisible(false);
                    deny.setVisible(false);
                    g.drawString("How much are you betting?", 200, 200);
                    textField.setLocation(250, 225);
                    textField.setVisible(true);
                    submit.setLocation(270, 275);
                    submit.setVisible(true);
                } else {
                    submit.setVisible(false);
                    textField.setVisible(false);
                    if(!dealed) {
                        drawCards(0);
                        dealed=true;
                    }
                    if(playerScore>21) {
                        g.drawString("YOU LOST! Pay up!", 260, 245);
                        hit.setVisible(false);
                        stand.setVisible(false);
                        pay.setVisible(true);
                        pay.setLocation(280, 300);
                    } else if(enemyScore>21) {
                        hit.setVisible(false);
                        stand.setVisible(false);
                        g.drawString("YOU WON!", 250, 245);
                        g.drawString("Want to play again?", 230, 275);
                        accept.setVisible(true);
                        deny.setVisible(true);
                        accept.setLocation(325, 295);
                        deny.setLocation(395, 295);
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
                                drawCards(enemyTurnCard);
                            }
                        }
                    }
                }
            } else if(playingSlots) {
                try {
                    background = ImageIO.read(new File("src/assets/Casino/SlotMachine.png"));
                } catch (IOException efg) {
                    efg.getMessage();
                }
                g.setColor(Color.white);
                if(!bet) {
                    g.drawString("How much are you betting?", 190, 150);
                    textField.setLocation(230, 165);
                    textField.setVisible(true);
                    submit.setLocation(290, 190);
                    submit.setVisible(true);
                } else if(animationSlots) {
                    try {
                        background = ImageIO.read(new File("src/assets/Casino/BlackBackground.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    SlotMachine machine;
                    int win = (int) (Math.random()*100)+1;
                    if(win>=0 && win<=24) {
                        machine = new SlotMachine(true);
                    } else {
                        machine = new SlotMachine(false);
                    }
                    g.drawImage(machine.getSlotImage(), 25, 10, null);
                } else {
                    submit.setVisible(false);
                    textField.setVisible(false);
                    g.drawString("Click the lever to play", 350, 150);
                }
            } else {
                g.setFont(new Font("Arial", Font.BOLD, 30));
                g.drawString("Welcome! What are you trying to do?", 80, 150);
                slots.setVisible(true);
                blackjack.setVisible(true);
                slots.setLocation(135, 175);
                blackjack.setLocation(435, 175);
                home.setVisible(true);
                home.setLocation(285, 230);
                pay.setVisible(false);
                accept.setVisible(false);
                deny.setVisible(false);
            }
        } else if(isOutside) {
            try {
                background = ImageIO.read(new File("src/assets/Outside.png"));
            } catch (IOException a) {
                System.out.println(a.getMessage());
            }
            phone.setVisible(false);
            bakeryButton.setVisible(true);
            goToCasino.setVisible(true);
            home.setVisible(true);
            outside.setVisible(false);
            menu.setVisible(false);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Where would you like to go?", 125, 150);
            bakeryButton.setLocation(125, 200);
            home.setLocation(425, 200);
            goToCasino.setLocation(275, 200);
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
                    enemyTurnCard=22;
                    enemyScore=enemyScore+rand1;
                } else {
                    enemyTurnCard=21;
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
        Property nine = new Property(25000, 3000, 530, 350, "Florida", "MidLevelStore",
                "A really fancy Walgreens.", "Store");
        Property ten = new Property(7500, 400,200, 200, "Colorado", "PoorStore",
                "The owner is just trying to get rid of it. It doesn't make much money.", "Store");
        Rectangle on = new Rectangle(120, 100, 15, 15);
        Rectangle tw = new Rectangle(300, 170, 15, 15);
        Rectangle thre = new Rectangle(350, 70, 15, 15);
        Rectangle fou = new Rectangle(410, 170, 15 ,15);
        Rectangle fiv = new Rectangle(320, 300, 15, 15);
        Rectangle si = new Rectangle(580, 120, 15, 15);
        Rectangle seve = new Rectangle(50, 220, 15, 15);
        Rectangle eigh = new Rectangle(530, 240, 15, 15);
        Rectangle nin = new Rectangle(530, 350, 15, 15);
        Rectangle te = new Rectangle(200, 200, 15, 15);
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
        if(missionone || missiontwo) {
            missionCount++;
        }
    }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if (phoneActive) {
                if(property) {
                    for (int i = 0; i < propertyRects.size(); i++) {
                        if (propertyRects.get(i).contains(e.getPoint())) {
                            count = i;
                        }
                    }
                }
            if(contacts) {
                if(callSimeon.contains(e.getPoint())) {
                    missionone=true;
                } else if(callLamar.contains(e.getPoint())) {
                    missiontwo=true;
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
            if(house) {
                if(tier3) {
                    if(homeRect.contains(e.getPoint())) {
                        try {
                            homeImage = ImageIO.read(new File("src/assets/PropertiesHomes/TierThreeOResize.png"));
                        } catch (IOException eh) {
                            eh.getMessage();
                        }
                    }
                } else if(tierTwo.contains(e.getPoint())) {
                    tier2=true;
                } else if(tierThree.contains(e.getPoint())) {
                    tier3=true;
                }
            }
        }
        if(atCasino) {
            if(playingSlots) {
                if(bet) {
                    if(leverRect.contains(e.getPoint())) {
                        animationSlots=true;
                    }
                }
            }
        }
        if(bakeryTrue) {
            if(count==-3 && count<0) {
                for (int i = 0; i < menuItems.size(); i++) {
                    if (menuItems.get(i).contains(e.getPoint())) {
                        count = i;
                    }
                }
            } else {
                System.out.println(count);
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
        if(e.getSource() instanceof Timer) {
            if(missionone) {
                if (room == 1) {
                    time++;
                }
            }
        } else if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == phone) {
                if(!phoneActive) {
                    phoneActive=true;
                } else {
                    phoneActive=false;
                    internet=false;
                    buying=false;
                    contacts=false;
                    property=false;
                    house=false;
                    tier3=false;
                    tier2=false;
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
                } else if(playingSlots) {

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
                atCasino=false;
                bakeryButton.setVisible(false);
                goToCasino.setVisible(false);
                atBeach.setVisible(false);
                home.setVisible(false);
                try {
                    if(tier==1) {
                        background = ImageIO.read(new File("src/assets/PropertiesHomes/TierOneHouse.png"));
                    } else if(tier==2) {
                        background = ImageIO.read(new File("src/assets/PropertiesHomes/TierTwoHouse.png"));
                    } else {
                        background = ImageIO.read(new File("src/assets/PropertiesHomes/TierThreeHouseOne.png"));
                    }
                } catch (IOException h) {
                    h.getMessage();
                }

            } else if(button==back) {
                if(phoneActive) {
                    count = -1;
                } else {
                    lookingWindow=false;
                    window.setVisible(false);
                    back.setVisible(false);
                }
            } else if(button==buy) {
                if(house) {
                    if(tier2) {
                        if (player.getMoney() >= 60000) {
                            player.changeBalance(-60000);
                        }
                        tier=2;
                    } else {
                        if (player.getMoney() >= 100000) {
                            player.changeBalance(-100000);
                        }
                        tier=3;
                    }
                } else {
                    if (player.getMoney() >= properties.get(count).getPrice()) {
                        player.changeBalance(-1 * properties.get(count).getPrice());
                        properties.get(count).setPurchased();
                        count = -3;
                    }
                }
            } else if(button==blackjack) {
                playingblackjack=true;
                blackjack.setVisible(false);
                slots.setVisible(false);
                try {
                    background = ImageIO.read(new File("src/Assets/Casino/BlackjackTable.png"));
                } catch (IOException eft) {
                    eft.getMessage();
                }
            } else if(button==hit) {
                drawCards(cardTurnPlayer);
                turn=2;
            } else if(button==stand) {
                if(enemyScore>=18) {
                    if(playerScore>enemyScore) {
                        enemyScore=22;
                    } else {
                        playerScore=22;
                    }
                } else {
                    turn = 2;
                }
            } else if(button==slots) {
                playingSlots=true;
                blackjack.setVisible(false);
                slots.setVisible(false);
                try {
                    background = ImageIO.read(new File("src/Assets/Casino/SlotMachine.png"));
                } catch (IOException eft) {
                    eft.getMessage();
                }
            } else if(button==pay) {
                try {
                    background = ImageIO.read(new File("src/assets/Casino/CasinoImage.png"));
                } catch (IOException efg) {
                    efg.getMessage();
                }
                player.changeBalance(-1 * betAmount);playingblackjack = false;dealed = false;bet = false;
                enemyScore=0;
                playerScore=0;
            } else if(button==submit) {
                betAmount = Integer.parseInt(textField.getText());
                bet=true;
            } else if(button==propertyButton) {
                property=true;
                buying=false;
            } else if(button==window) {
                lookingWindow=true;
            } else if(button==accept) {
                player.changeBalance(betAmount);
                dealed=false;
                bet=false;
                playerScore=0;
                enemyScore=0;
                betAmount=-1;
            } else if(button==deny) {
                player.changeBalance(betAmount);
                playingblackjack=false;
                dealed=false;
                bet=false;
                playerScore=0;
                enemyScore=0;
            } else {
                buying=false;
                house=true;
            }

        }
    }
}
