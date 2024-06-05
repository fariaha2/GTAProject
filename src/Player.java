import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Player {
    private final double MOVE_AMT = 0.5;
    private double xCoord;
    private double yCoord;
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
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 700) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
        }
    }

    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 500) {
            yCoord += MOVE_AMT;
        }
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
    public void reduceMoney(int m) {
        money=money-m;
    }
    public int getMoney() {
        return money;
    }
}
