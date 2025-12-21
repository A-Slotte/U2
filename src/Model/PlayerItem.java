package Model;

public class PlayerItem extends Item{

    private Boolean player;
    public PlayerItem(int x, int y, Boolean player) {
        super(x, y);
        this.player = player;
    }
    public Boolean getPlayer() {
        return player;
    }

    public void setPlayer(Boolean player) {
        this.player = player;
    }


}