package View;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private Controller controller;
    private JFrame frame;
    private MenuPanel menuPanel;
    private UIManager uiManager;
    private BackgroundPanel background;

    public MainFrame(Controller controller){
        this.controller = controller;
        menuFrame();

    }
    public void menuFrame(){
        frame = new JFrame("Omvälvare");
        background = new BackgroundPanel();
        background.setLayout(new BorderLayout());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuPanel = new MenuPanel(800, 600, frame);
        background.add(menuPanel.getMPanel());
        background.setPreferredSize(background.getBackgroundDimension());

        frame.setContentPane(background);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void gameFrame(){

    }
    /*public void setGlobalFont(){
        uiManager.put("Label.font", new Font("Dungeon Mode", Font.PLAIN, 14));
        uiManager.put("Button.font", new Font("Dungeon Mode", Font.PLAIN, 14));
        uiManager.put("ComboBox.font", new Font("Dungeon Mode", Font.PLAIN, 14));
    }

     */
}