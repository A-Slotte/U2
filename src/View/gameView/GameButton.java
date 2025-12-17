package View.gameView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameButton extends JButton {
    private ArrayList<ImageIcon> iconList;

    public GameButton(ArrayList<ImageIcon> iconList){
        this.iconList = iconList;
    }
}