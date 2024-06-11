import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class Player {
    private final double MOVE_AMT = 1.25;
    private double xCoord;
    private double yCoord;
    private double missionx;
    private double missiony;

    private int tier;
    private int money;
    private BufferedImage sprite;
    public Player() {
        try {
            sprite = ImageIO.read(new File("src/assets/Adam_Stoped.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        tier=1;
        money=50000;
        xCoord=350;
        yCoord=250;
        missionx=50;
        missiony=250;
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 700) {
            missionx += MOVE_AMT;
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            missionx -= MOVE_AMT;
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            missiony -= MOVE_AMT;
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 500) {
            missiony += MOVE_AMT;
            yCoord += MOVE_AMT;
        }
    }
    public int getMissionx() {
        return (int) missionx;
    }
    public int getMissiony() {
        return (int) missiony;
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }
    public BufferedImage getSprite() {
        return sprite;
    }
    public String getTier() {
        return Integer.toString(tier);
    }
    public void changeBalance(int m) {
        money=money+m;
    }
    public int getMoney() {
        return money;
    }
    public Rectangle playerRect() {
        int imageHeight = sprite.getHeight();
        int imageWidth = sprite.getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
