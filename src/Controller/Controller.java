package Controller;

import Model.GridHandler;
import Model.GridPos;
import View.MainFrame;
import java.util.List;

public class Controller implements State {
    private MainFrame mainFrame;
    private GridHandler gridHandler;
    private GameState state;

    public Controller(){
        startGame();
    }

    public void startGame(){
        gridHandler = new GridHandler(8, 8, 10);
        mainFrame = new MainFrame( this);
        List<GridPos> mysteryPos= gridHandler.getGrid().getMysteryPos();
        mainFrame.getGamePanel().getGridPanel().updateGridPanel(mysteryPos);
        state = GameState.PLAYER1;
        mainFrame.getGamePanel().updatePlayerPanel(0, 0, state);
    }

    public void buttonPressed(int y, int x){
        gridHandler.placePiece(y, x, state);
        switchState();
        update();
    }

    @Override
    public GameState checkState() {
        return state;
    }
    @Override
    public void switchState(){
        if (state == GameState.PLAYER1){
            state = GameState.PLAYER2;
        }
        else {
            state = GameState.PLAYER1;
        }
    }

    public void update(){
        int p1Score = gridHandler.getP1Score();
        int p2Score = gridHandler.getP2Score();
        mainFrame.getGamePanel().getGridPanel().updateGridPanel(gridHandler.getGridUpdates());
        mainFrame.getGamePanel().updatePlayerPanel(p1Score, p2Score, state);
        gridHandler.getGridUpdates().clear();
        checkEndConditions();
    }

    private void checkEndConditions() {
        if(gridHandler.getNbrSpaces() <= 0 || gridHandler.getRemainingMysteries() <= 0){
            gameEnded();
        }
    }
    // TODO - Sluta spelet, JOptionPane med score och knapp för main meny
    private void gameEnded() {
    }
}