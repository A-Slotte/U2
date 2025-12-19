package View.gameView;

import Controller.GameState;
import View.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GridPanel gridPanel;
    private PlayerPanel p1Panel;
    private PlayerPanel p2Panel;
    private MainFrame mainFrame;

    public GamePanel(int x, int y, MainFrame mainframe){
        this.mainFrame = mainframe;
        setBackground(Color.BLACK);
        setOpaque(true);
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
        setPanelSize();

        gridPanel = new GridPanel(this);
        p1Panel = new PlayerPanel("Player 1");
        p2Panel = new PlayerPanel("Player 2");


        setUp();
    }
    public MainFrame getMainFrame(){
        return mainFrame;
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }
    // GridPanel, x = 605, y = 605, P1Panel
    private void setPanelSize(){
        Dimension size = new Dimension(1005,605 );
        setPreferredSize(size);
    }

    private void setUp(){
        this.add(gridPanel, BorderLayout.CENTER);
        this.add(p1Panel, BorderLayout.WEST);
        this.add(p2Panel, BorderLayout.EAST);
    }
    public void updatePlayerPanel(int scoreP1, int scoreP2, GameState state){
        switch (state){
            case PLAYER1:
                p2Panel.turnOffTurnLabel();
                p1Panel.updateTurnLabel(state);
                break;
            case PLAYER2:
                p2Panel.updateTurnLabel(state);
                p1Panel.turnOffTurnLabel();
                break;
        }
        p1Panel.updateScore(scoreP1);
        p2Panel.updateScore(scoreP2);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }

}