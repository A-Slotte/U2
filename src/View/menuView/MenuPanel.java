package View;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuPanel {
    private JPanel MPanel;
    private BackgroundPanel backgroundPanel;
    private JFrame frame;
    private JComboBox options;
    private JLabel Title;
    private JLabel label;
    private String s1[] = {"8x8", "10x10"};

    public MenuPanel(int x, int y, JFrame frame){
        this.frame = frame;
        createLabels();
        createMenuPanel();
    }
    private void createLabels(){
        label = new JLabel("Map size");
        Title = new JLabel("Omvälvare");
        Title.setFont(new Font("Dungeon Mode", Font.BOLD, 70));
        Title.setForeground(new Color(181, 59,89));
        label.setFont(new Font("Dungeon Mode", Font.BOLD, 35));
        label.setForeground(new Color(181, 59,89));
        label.setHorizontalAlignment(JLabel.CENTER);
    }
    private void createMenuPanel(){
        MPanel = new JPanel();
        options = new JComboBox(s1);
        MPanel.setLayout(new BoxLayout(MPanel, BoxLayout.Y_AXIS));
        createLabels();
        MPanel.setOpaque(false);
        MPanel.add(Box.createRigidArea(new Dimension(200, 100)));
        MPanel.add(Title);
        MPanel.add(Box.createRigidArea(new Dimension(200, 100)));
        MPanel.add(label);
        MPanel.setVisible(true);
    }
    public JPanel getMPanel(){
        return MPanel;
    }


}