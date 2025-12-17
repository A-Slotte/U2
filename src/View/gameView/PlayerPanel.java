package View.gameView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerPanel extends JPanel {
    private int nbrOfPieces;
    private String topLabel;
    private JLabel playerLabel;
    private BufferedImage background;

    public PlayerPanel(String topLabel){
        this.topLabel = topLabel;
        contentSetUp();
        readImage();
        setUp();
    }
    public void readImage(){
        try {
            background = ImageIO.read(getClass().getResource("/PlayerPanel.png"));
        }
        catch (IOException e){
            System.out.println("Sprite Failed to load");
            throw new RuntimeException();
        }
    }
    public void contentSetUp(){
        playerLabel = new JLabel(topLabel);
        playerLabel.setFont(new Font("Dungeon Mode", Font.BOLD, 20));
        playerLabel.setForeground(new Color(181, 59, 89));
        playerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerLabel.setVisible(true);
    }
    public void setUp(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200, 605));
        this.add(Box.createRigidArea(new Dimension(200, 50)));
        this.add(playerLabel);
        this.setVisible(true);

    }
    public void nbrOfPieces(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(background, 0, 0, 200, 605,  null);
    }



}