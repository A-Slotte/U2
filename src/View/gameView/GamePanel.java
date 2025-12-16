package View;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GridPanel gridPanel;
    private P1Panel p1Panel;
    private P2Panel p2Panel;

    public GamePanel(int x, int y){
        gridPanel = new GridPanel(x, y);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setUp();
    }
    public void setUp(){
        this.add(gridPanel, BorderLayout.CENTER);
    }
}