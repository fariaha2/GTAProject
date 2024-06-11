import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
public class Cop {
    private final double MOVE_AMT = .75;
    private double xCoord;
    private double yCoord;
    private Timer timer;
    private BufferedImage spriteForward;
    private BufferedImage spriteBackward;
    private BufferedImage current;
    private String type;
    private int turn;
    public Cop(double x, double y, String t, String beg, int th) {
        try {
            spriteForward = ImageIO.read(new File("src/assets/Missions/copforward.png"));
            spriteBackward = ImageIO.read(new File("src/assets/Missions/copbackward.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        type = t;
        if(beg.equals("forward")) {
            current=spriteForward;
        } else {
            current = spriteBackward;
        }
        turn=th;
        xCoord=x;
        yCoord=y;
    }
    public void callMove() {
        if(turn==1) {
            moveUp();
            turn=2;
        } else {
            moveDown();
            turn=1;
        }
    }

    public void moveRight() {
        current=spriteBackward;
    }

    public void moveLeft() {
        current=spriteBackward;
    }

    public void moveUp() {
        current=spriteForward;
        for(int i=0; i<66; i++) {
            yCoord+= MOVE_AMT;
        }
    }

    public void moveDown() {
        current=spriteBackward;
        for(int i=0; i<66; i++) {
            yCoord-= MOVE_AMT;
        }
    }

    public int getxCoord() {
        return (int) xCoord;
    }

    public int getyCoord() {
        return (int) yCoord;
    }
    public BufferedImage getSprite() {
        return current;
    }
    public Rectangle CopRect() {
        int imageHeight = 100;
        int imageWidth = 100;
        Rectangle rect = new Rectangle((int) xCoord-10, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }
}
