import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SlotMachine {
    private double xCoord;
    private double yCoord;
    private Animation run;

    public SlotMachine(boolean win) {
        xCoord = 25;
        yCoord = 10;
        ArrayList<BufferedImage> run_animation = new ArrayList<>();
        if(win) {
            for (int i = 0; i <= 42; i++) {
                String filename="";
                if(i<10) {
                    if(i==8) {
                        filename = "src/Assets/Casino/Slots/frame_0" + i + "_delay-0.13s.png";
                    } else {
                        filename = "src/Assets/Casino/Slots/frame_0" + i + "_delay-0.06s.png";
                    }
                } else {
                    if(i==16 || i==33) {
                        filename = "src/Assets/Casino/Slots/frame_" + i + "_delay-0.13s.png";
                    } else {
                        filename = "src/Assets/Casino/Slots/frame_" + i + "_delay-0.06s.png";
                    }
                }
                try {
                    run_animation.add(ImageIO.read(new File(filename)));
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            for (int i = 0; i <= 45; i++) {
                String filename="";
                if(i<10) {
                    if(i==8) {
                        filename = "src/Assets/Casino/Slots/frame_0" + i + "_delay-0.13s.png";
                    } else {
                        filename = "src/Assets/Casino/Slots/frame_0" + i + "_delay-0.06s.png";
                    }
                } else {
                    if(i==16 || i==33) {
                        filename = "src/Assets/Casino/Slots/frame_" + i + "_delay-0.13s.png";
                    } else {
                        filename = "src/Assets/Casino/Slots/frame_" + i + "_delay-0.06s.png";
                    }
                }
                try {
                    run_animation.add(ImageIO.read(new File(filename)));
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        run = new Animation(run_animation,600);

    }

    public BufferedImage getSlotImage() {
        return run.getActiveFrame();
    }

}
