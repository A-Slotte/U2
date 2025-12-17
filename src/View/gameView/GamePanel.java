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


        setUp();
    }
    // GridPanel, x = 605, y = 605, P1Panel
    public void setPanelSize(){
        Dimension size = new Dimension(605,605 );
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