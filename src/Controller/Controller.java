package Controller;

import Model.GridHandler;
import Model.GridUpdate;
import View.MainFrame;
import java.util.List;

public class Controller implements State {
    private MainFrame mainFrame;
    private GridHandler gridHandler;
    private int nbrOfSpaces;
    private int nbrOfMysteries;
    private GameState state;

    public Controller(){

        startGame();
    }
    public void startGame(){
        gridHandler = new GridHandler(8, 8, 10);
        mainFrame = new MainFrame( this);
        List<GridUpdate> mysteryPos= gridHandler.getGrid().getMysteryPos();
        mainFrame.getGamePanel().getGridPanel().updateGridPanel(mysteryPos);
        state = GameState.PLAYER1;
        mainFrame.getGamePanel().updatePlayerPanel(0, 0, state);
    }
    public void buttonPressed(int y, int x){
        switchState();
        gridHandler.placePiece(x, y, state);
        update();
    }

    @Override
    public void checkState() {

    }
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
    }
}