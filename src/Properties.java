import java.awt.*;
import java.awt.image.BufferedImage;
public class Properties {
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
    public Properties (BufferedImage img, int p, int r, int x, int y, String l, String d, String t, boolean purchase){
        xCoord=x;
        yCoord=y;
        price=p;
        image=img;
        rate=r;
        description=d;
        type=d;
        location=l;
        purchased=purchase;
    }
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
    public int rate() {
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
