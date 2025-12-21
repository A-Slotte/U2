package Controller;

public interface State {
    public GameState checkState();
    public void switchState();
}