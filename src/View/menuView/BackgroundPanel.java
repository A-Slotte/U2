package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundPanel extends JPanel {

    private BufferedImage background;
    private int X;
    private int Y;
    public BackgroundPanel(){
        createBackground();
    }

    private void createBackground(){
        try {
            background = ImageIO.read(getClass().getResource("/assets/menuBackground.png"));

        } catch (IOException e) {
            System.out.println("Background failed to load");
            throw new RuntimeException(e);
        }
        X = background.getHeight();
        Y = background.getWidth();
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        X = background.getWidth();
        Y = background.getHeight();
        g.drawImage(background, 0, 0, X, Y, null );
    }
    public Dimension getBackgroundDimension(){
        return new Dimension(background.getWidth(), background.getHeight());
    }
}