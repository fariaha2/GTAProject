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
    private JButton tutorialButton;
    private JButton backButton;
    private JFrame enclosingFrame;
    private BufferedImage background;

    public WelcomePanel(JFrame frame) {
        enclosingFrame = frame;
        try {
            background = ImageIO.read(new File("src/GTALoadingScreen.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        textField = new JTextField(20);
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");
        tutorialButton = new JButton("Tutorial");
        backButton = new JButton("Back");
        add(textField);
        add(submitButton);
        add(clearButton);
        add(tutorialButton);
        submitButton.addActionListener(this);
        clearButton.addActionListener(this);
        tutorialButton.addActionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.setColor(Color.WHITE);
        g.drawString("Welcome to Discount GTA V!", 175, 35);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.BLACK);
        g.drawString("Please enter your name:", 250, 100);
        textField.setLocation(240, 110);
        submitButton.setLocation(260, 140);
        clearButton.setLocation(360, 140);
        tutorialButton.setLocation(300, 300);
    }
    public void tutorialGraphics(Graphics g) {
        super.paintComponent(g);
        submitButton.setVisible(false);
        clearButton.setVisible(false);
        tutorialButton.setVisible(false);
        textField.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == submitButton) {
                String playerName = textField.getText();
                MainFrame f = new MainFrame(playerName);
                enclosingFrame.setVisible(false);
            } else if (button == clearButton) {
                textField.setText("");
            } else if (button == tutorialButton) {
                submitButton.setVisible(false);
                clearButton.setVisible(false);
                tutorialButton.setVisible(false);
                textField.setVisible(false);
            } else {

            }
        }
    }
}
