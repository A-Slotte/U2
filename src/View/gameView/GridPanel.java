package View;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    private MainFrame frame;
    public GridPanel(int x, int y){

        GridLayout gridLayout = new GridLayout(x, y);
        this.setLayout(gridLayout);
        fillGridPanel();
    }
    public void fillGridPanel(){
        for(int i = 0; i < 64; i++){
            this.add(new JButton("Button 1"));
        }
    }
}