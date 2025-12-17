package View.gameView;

import View.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Klass: GridPanel skapar en GridPanelLayout fylld med GameButtons.
 * <p>
 * GridPanel extends JPanel och implementerar ActionListener. GridPanel hanterar allt gällande GameButtons
 * som att ändra icons och Action events genom ActionListener.
 */
public class GridPanel extends JPanel implements ActionListener, ItemListener {
    private ArrayList<GameButton> buttons;
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
    /**
     * Läser in Iconer från en spritesheet.
     */
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
    /**
     * Fyller gridLayout med GameButtons, och lägger till dem i en ArrayList för att senare kunna hämta via index.
     * <p>
     *     int x = i / 8 beräknar vilken rad i en 2dArray och int y = i % 8 beräknar vilken column.
     * </p>
     */
    public void fillGrid(){
        buttons = new ArrayList<>();
        for (int i = 0; i < 64; i++){
            int x = i / 8;
            int y = i % 8;
            GameButton button = createButton(x, y);
            buttons.add(button);
            this.add(button);
        }
    }

    /**
     * Hämtar GameButton från listan buttons.
     * @param x row
     * @param y column
     * @return GameButton från Buttons
     */
    public GameButton getGameButton(int x, int y){
        int index = x * 8 + y;
        return buttons.get(index);
    }
    /**
     * Skapar GameButton
     */
    public GameButton createButton(int x, int y){
        GameButton button = new GameButton(iconList.get(0), x, y);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setRolloverEnabled(true);
        button.setRolloverIcon(iconList.get(1));
        button.setPressedIcon(iconList.get(2));
        button.setBackground(Color.BLACK);
        button.setMargin(new Insets(0,0,0,0));
        button.addActionListener(this);
        return button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("pressed");
        GameButton g = (GameButton) e.getSource();
        var x = g.getMyX();
        var y = g.getMyY();
        System.out.println(g.getMyX()+" "+g.getMyY());
        getGameButton(x, y);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }


}