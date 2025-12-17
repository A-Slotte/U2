package View.gameView;

import View.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;



public class GridPanel extends JPanel implements ActionListener, ItemListener {
    private ArrayList<JButton> buttons;
    private ArrayList<Icon> iconList = new ArrayList<>();
    private BufferedImage spriteSheet;

    public GridPanel(){
        readSpriteSheet();

        GridLayout gridLayout = new GridLayout(8, 8);
        this.setLayout(gridLayout);
        this.setBackground(new Color(0, 0, 0, 0));
        setPreferredSize(new Dimension(500, 500));
        fillGrid();
    }

    public void readSpriteSheet(){
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/spritesheet1.png"));
        }
        catch (IOException e){
            System.out.println("Sprite Failed to load");
            throw new RuntimeException();
        }
        iconList.add(new ImageIcon(spriteSheet.getSubimage(0,0,70,70)));
        iconList.add(new ImageIcon(spriteSheet.getSubimage(70,0,70,70)));
        iconList.add(new ImageIcon(spriteSheet.getSubimage(70 * 2,0,70,70)));
        iconList.add(new ImageIcon(spriteSheet.getSubimage(70 * 3,0,70,70)));
        iconList.add(new ImageIcon(spriteSheet.getSubimage(0,70,70,70)));
        iconList.add(new ImageIcon(spriteSheet.getSubimage(70,70,70,70)));
    }

    public void fillGrid(){
        buttons = new ArrayList<>();
        for (int i = 1; i <= 64; i++){
            JButton button = createButton();
            buttons.add(button);
            this.add(button);
        }
    }

    public JButton createButton(){
        JButton button = new JButton(iconList.get(0));

        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setRolloverEnabled(true);
        button.setRolloverIcon(iconList.get(1));
        button.setPressedIcon(iconList.get(2));
        button.setBackground(Color.BLACK);
        button.setMargin(new Insets(0,0,0,0));
        return button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pressed");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");
        JButton button = null;
        if (e.getSource().getClass() == JButton.class){
            button = (JButton) e.getSource();
            System.out.println("212");
        }
        else if(button != null){
            System.out.println("12");
        }
        button.setIcon(new ImageIcon(spriteSheet.getSubimage(0, 0, 70,70)));



    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }


}