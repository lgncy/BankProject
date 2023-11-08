package BankProjects;

import java.awt.Color;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {

    Container container;
    JPanel panel;

    Frame() {
        container = getContentPane();
        panel = new JPanel();

        try {
            BufferedImage img = ImageIO.read(new File("D:\\JAVA PROJECT\\BankProjects\\bin\\images\\qriss.png"));
            JLabel imageLabel = new JLabel(new ImageIcon(img));

            panel.add(imageLabel);
            container.add(panel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        container.setBackground(Color.BLACK);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame();
    }
}
