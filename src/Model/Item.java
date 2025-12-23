package Model;

public abstract class Item {
    protected int y;
    protected int x;

    protected ItemType type;
    public Item(int y, int x, ItemType type){
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public ItemType getType() {
        return type;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    






}