package View.gameView;

import javax.swing.*;

public class PlayerPanel extends JPanel {
    public PlayerPanel(){

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setUp();
    }
    public void setUp(){
        JLabel test = new JLabel("PLayer 1");
        this.add(test);
    }

}