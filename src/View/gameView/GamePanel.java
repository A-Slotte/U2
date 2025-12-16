package View.gameView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GridPanel gridPanel;
    private PlayerPanel panel;
    private P1Panel p1Panel;
    private P2Panel p2Panel;

    public GamePanel(int x, int y){
        setBackground(Color.BLACK);
        setOpaque(true);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setPanelSize();

        gridPanel = new GridPanel(x, y, panel, this);
        //panel = new PlayerPanel();

        setUp();
    }
    public void setPanelSize(){
        Dimension size = new Dimension(650,605 );
        setPreferredSize(size);
    }
    public void setUp(){
        this.add(gridPanel, BorderLayout.CENTER);
        //this.add(panel, BorderLayout.WEST);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}