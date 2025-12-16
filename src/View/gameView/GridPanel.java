package View.gameView;

import View.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;



public class GridPanel extends JPanel implements ActionListener, ItemListener, MouseListener {
    private MainFrame frame;
    private ArrayList<JButton> buttons;
    private ArrayList<Icon> iconList = new ArrayList<>();
    private BufferedImage spriteSheet;
    private JPanel gamePanel;
    private Icon emptIcon;
    private Icon pressedIcon;
    private Icon hoveredIcon;
    private JPanel panel;

    public GridPanel(int x, int y, JPanel panel, GamePanel gamePanel){
        this.panel = panel;
        this.gamePanel = gamePanel;
        readSprite();
        GridLayout gridLayout = new GridLayout(8, 8);
        this.setLayout(gridLayout);
        this.setBackground(new Color(0, 0, 0, 0));
        setPreferredSize(new Dimension(500, 500));
        fillGrid();
    }
    /*
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(slotImg, 30, 0, null);
    }
    */

    public void readSprite(){
        try {
            spriteSheet = ImageIO.read(getClass().getResource("/spritesheet1.png"));
        }
        catch (IOException e){
            System.out.println("Sprite Failed to load");
            throw new RuntimeException();
        }
    }
    public void fillGrid(){
        buttons = new ArrayList<>();
        for (int i = 1; i <= 64; i++){
            JButton button = createButton();
            buttons.add(button);
            this.add(button);
        }
        revalidate();
        repaint();
    }

    public JButton createButton(){

        JButton button = new JButton(new ImageIcon(spriteSheet.getSubimage(0, 0, 70, 70)));
        button.setPressedIcon(new ImageIcon(spriteSheet.getSubimage(0, 0, 70, 70)));
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setRolloverEnabled(false);
        //button.setBackground(new Color(0, 0, 0, 0));
        button.addActionListener(this);
        //button.addMouseListener(this);
        button.setMargin(new Insets(0,0,0,0));
        return button;
    }
    public void mouseEvents(GridActions event, ActionEvent e, MouseEvent m){
        switch (event){
            case GridActions.BUTTONETERED:




        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pressed");
        gamePanel.revalidate();
        this.revalidate();


    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
        JButton button = null;
        if (e.getSource().getClass() == JButton.class){
            button = (JButton) e.getSource();
            System.out.println("212");
        }
        else if(button != null){
            System.out.println("12");
        }
        button.setIcon(null);
        button.setIcon(iconList.get(1));
    }



    @Override

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
        button.setIcon(iconList.get(0));


    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }


}