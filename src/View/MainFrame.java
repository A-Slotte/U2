package View;

import Controller.Controller;

import javax.swing.*;

public class MainFrame {
    private Controller controller;
    private JFrame frame;
    private MenuPanel MPanel;

    public MainFrame(int x, int y, Controller controller){
        this.controller = controller;
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(x, y);
        MPanel = new MenuPanel(x, y, frame);

        frame.setVisible(true);

    }
}