package View.gameView;

import Controller.GameState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerPanel extends JPanel {
    private int nbrOfPieces;
    private String topLabel;
    private JLabel playerLabel;
    private JLabel turnLabel;
    private JLabel scoreLabel;
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

        turnLabel = new JLabel("Your Turn");
        turnLabel.setFont(new Font("Dungeon Mode", Font.BOLD, 19));
        turnLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        turnLabel.setForeground(new Color(181, 59, 89));
        turnLabel.setVisible(false);

        scoreLabel = new JLabel("0");
        scoreLabel.setFont(new Font("Dungeon Mode", Font.BOLD, 30));
        scoreLabel.setForeground(new Color(181, 59, 89));
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreLabel.setVisible(true);

    }
    public void setUp(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(200, 605));
        this.add(Box.createRigidArea(new Dimension(200, 50)));
        this.add(playerLabel);
        this.add(Box.createRigidArea(new Dimension(200, 65)));
        this.add(scoreLabel);
        this.add(Box.createRigidArea(new Dimension(200, 50)));
        this.add(turnLabel);
        this.setVisible(true);

    }
    public void turnOffTurnLabel(){
        turnLabel.setVisible(false);
    }
    public void updateTurnLabel(GameState state){
        turnLabel.setVisible(true);
    }
    public void updateScore(int score){
        scoreLabel.setText(score+"");
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(background, 0, 0, 200, 605,  null);
    }



}