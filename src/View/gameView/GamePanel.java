package View.gameView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GridPanel gridPanel;
    private PlayerPanel p1Panel;
    private PlayerPanel p2Panel;


    public GamePanel(int x, int y){
        setBackground(Color.BLACK);
        setOpaque(true);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setPanelSize();

        gridPanel = new GridPanel();
        p1Panel = new PlayerPanel("Player 1");
        p2Panel = new PlayerPanel("Player 2");


        setUp();
    }
    // GridPanel, x = 605, y = 605, P1Panel
    public void setPanelSize(){
        Dimension size = new Dimension(1005,605 );
        setPreferredSize(size);
    }
    public void setUp(){
        this.add(gridPanel, BorderLayout.CENTER);
        this.add(p1Panel, BorderLayout.WEST);
        this.add(p2Panel, BorderLayout.EAST);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}