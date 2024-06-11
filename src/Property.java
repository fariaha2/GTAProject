import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Property {
    private BufferedImage image;
    private String description;
    private String type;
    private String location;
    private int xCoord;
    private int yCoord;
    private int price;
    private int totalMoneyGenerated=0;
    private int rate;
    private boolean purchased;
    public Property(int price, int rate, int x, int y, String locatin, String img, String desc, String typ){
        try {
            image = ImageIO.read(new File("src/Assets/PropertiesHomes/" + img + ".png"));
        } catch (IOException e) {
            e.getMessage();
        }
        xCoord=x;
        yCoord=y;
        this.price=price;
        this.rate=rate;
        description=desc;
        type=typ;
        location=locatin;
        purchased=false;
    }
    public void setPurchased() { purchased=true; }
    public BufferedImage getImage() { return image; }
    public boolean isPurchased() {
        return purchased;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public int getTotalMoneyGenerated() {
        return totalMoneyGenerated;
    }

    public int getPrice() {
        return price;
    }
    public int getRate() {
        return rate;
    }
    public void addProfit() {
        totalMoneyGenerated+=rate;
    }
    public Rectangle propertyRect() {
        int imageHeight = 10;
        int imageWidth = 10;
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

}
