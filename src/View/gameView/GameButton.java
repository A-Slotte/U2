package View.gameView;

import javax.swing.*;

/**
 * GameButton extends JButton för att den ska känna till sin position i en grid.
 */
public class GameButton extends JButton {
    private int x;
    private int y;

    /**
     * Konsstruktorn
     * @param x Tar en int för sin postition i rad.
     * @param y Tar en int för sin position i kolumn
     * @param icon Tar en ImageIcon.
     */
    public GameButton(Icon icon, int x, int y){
        super(icon);
        this.x = x;
        this.y = y;
    }
    public int getMyX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getMyY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

}