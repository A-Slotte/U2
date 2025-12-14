package View;

import javax.swing.*;

public class MenuPanel {
    private JPanel MPanel;
    private JFrame frame;
    public MenuPanel(int x, int y, JFrame frame){
        this.frame = frame;
        MPanel = new JPanel();
        MPanel.setLayout(new BoxLayout(MPanel, BoxLayout.PAGE_AXIS));
    }
    private void setUp(){
        JLabel label = new JLabel("TEST");
        MPanel.add(label);
        frame.add(MPanel);
        frame.repaint();
        frame.revalidate();
    }

}