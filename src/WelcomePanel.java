import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WelcomePanel extends JPanel implements ActionListener {

    private JTextField textField;
    private JButton submitButton;
    private JButton clearButton;
    private JFrame enclosingFrame;
    private BufferedImage background;

    public WelcomePanel(JFrame frame) {
        // image will be added later
        enclosingFrame = frame;
      //  try {
            //background = ImageIO.read(new File("src/goomba.png"));
      //  } catch (IOException e) {
         //   System.out.println(e.getMessage());
      //  }
        textField = new JTextField(10);
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        add(textField);
        add(submitButton);
        add(clearButton);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);
        g.drawString("Please enter your name:", 250, 100);
        textField.setLocation(280, 120);
        submitButton.setLocation(280, 140);
        clearButton.setLocation(350, 140);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                String playerName = textField.getText();
                MainFrame f = new MainFrame(playerName);
                enclosingFrame.setVisible(false);
            } else {
                textField.setText("");
            }
        }
    }
}
