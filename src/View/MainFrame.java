package View;

import Controller.Controller;
import View.gameView.GamePanel;
import View.menuView.BackgroundPanel;
import View.menuView.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private Controller controller;
    private JFrame frame;
    private MenuPanel menuPanel;
    private UIManager uiManager;
    private BackgroundPanel background;
    private GamePanel gamePanel;

    public MainFrame(Controller controller){
        this.controller = controller;
        //createMenuFrame();
        createGameFrame();
    }
    public void createMenuPanels(){
        menuPanel = new MenuPanel(800, 600, frame);
        background = new BackgroundPanel();
        background.setLayout(new BorderLayout());
        background.add(menuPanel.getMPanel());
        background.setPreferredSize(background.getBackgroundDimension());
    }
    public void createMenuFrame(){
        createMenuPanels();
        frame = new JFrame("Omvälvare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(background);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public void createGameFrame(){
        gamePanel = new GamePanel(8, 8);
        frame = new JFrame("Omvälvare");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(gamePanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }
    /*public void setGlobalFont(){
        uiManager.put("Label.font", new Font("Dungeon Mode", Font.PLAIN, 14));
        uiManager.put("Button.font", new Font("Dungeon Mode", Font.PLAIN, 14));
        uiManager.put("ComboBox.font", new Font("Dungeon Mode", Font.PLAIN, 14));
    }
     */
}