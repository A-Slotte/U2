package Model;

import Controller.GameState;
import Controller.State;

import java.util.ArrayList;
import java.util.List;

public class GridHandler implements State {
    private Grid grid;
    private int remainingMysteries;
    private int nbrSpaces;
    private int p1Score = 0;
    private int p2Score = 0;
    private List<GridUpdate> gridUpdates = new ArrayList<>();

    public GridHandler(int height, int width, int nbrOfMysteries){
        remainingMysteries = nbrOfMysteries;
        nbrSpaces = height * width - nbrOfMysteries;
        grid = new Grid(width, height, nbrOfMysteries);

    }
    public int getP1Score(){
        return p1Score;
    }
    public int getP2Score(){
        return p2Score;
    }
    public int getNbrSpaces(){
        return nbrSpaces;
    }
    public int getRemainingMysteries(){
        return remainingMysteries;
    }

    public List<GridUpdate> getGridUpdates(){
        return gridUpdates;
    }

    public void placePiece(int x, int y, GameState state){
        switch (state){
            case PLAYER1:
                grid.getItemGrid()[y][x] = new PlayerItem(x, y, true);
                gridUpdates.add(new GridUpdate(y, x, ItemType.P1));
                p1Score++;
                nbrSpaces--;
                checkAdjacent(x, y, ItemType.MYSTERY);
                break;
            case PLAYER2:
                grid.getItemGrid()[y][x] = new PlayerItem(x, y, false);
                gridUpdates.add(new GridUpdate(y, x, ItemType.P2));
                nbrSpaces--;
                checkAdjacent(x, y, ItemType.MYSTERY);
                p2Score++;
                break;
        }
    }

    public boolean checkBounds(int y, int x){
        int height = grid.getItemGrid().length;
        int width = grid.getItemGrid()[0].length;
        if (y >= 0 && y < height && x >= 0 && x < width){
            return true;
        }
        return false;
    }

    public void checkAdjacent(int x, int y, ItemType type) {
        for(int i = -1; i < 2; i++){
            for(int j = - 1; j < 2; j++){
                if(checkBounds(y+i,x+j) && grid.getItemGrid()[y+i][x+j] != null){
                    if(grid.getItemGrid()[y+i][x+j].getClass() == MysterieItem.class && type == ItemType.MYSTERY){
                        checkIfMysterieUncovered(y, x, y+i, x+j, type);
                    }
                }
            }
        }
    }

    private void searchForSurprises() {
    }

    public void checkIfMysterieUncovered(int playerY, int playerX, int y, int x, ItemType type) {
        var diffY = playerY - y; //diffY ger motsatta y
        var diffX = playerX - x; //diffX get motsatta x

        var myst = (MysterieItem) grid.getItem(y, x);
        var piece = (PlayerItem) grid.getItem(playerY, playerX);

        if(checkBounds(y - diffY, x - diffX)){
            var posCheck = grid.getItemGrid()[y - diffY][x - diffX];
            if (posCheck != null && posCheck.getClass() == PlayerItem.class){
                var temp = (PlayerItem) posCheck;
                if(temp.getPlayer() == piece.getPlayer()){
                    mEvent(myst.getMysterie(), y, x);
                    System.out.println("uncovered");
                }
            }
        }
    }

    public Grid getGrid(){
        return grid;
    }




    public void mEvent(Mysteries m, int x, int y){
        switch (m){
            //case DEMAGOG -> demagogEvent(x, y);
            //case ADDITIVA -> additivtEvent(x, y);
            //case TIDSHOPP -> tidshoppEvent(x, y);
            //case AVGRUNDSVRÅL -> vrålEvent(x, y);
            //case NARCISSUS -> narcissusEvent(x, y);
            //case MULLTIPLICITET -> multiplicitetEvent(x, y);
        }
    }

    private void multiplicitetEvent(int x, int y) {
        for (int i = - 1; i < 2; i++){
            for (int j = - 1; j < 2; j++){
                if (j == 0 && i != 0 || i == 0 && j != 0){
                }
                else if(checkBounds(y + i, x + j) && grid.getItemGrid()[y +i][x + j].getClass() != MysterieItem.class){

                }
            }
        }
    }

    private void vrålEvent(int width, int height) {
    }

    private void additivtEvent(int width, int height) {
    }
    private void demagogEvent(int width, int height) {
    }
    private void tidshoppEvent(int width, int height) {
    }
    private void narcissusEvent(int width, int height) {
    }

    @Override
    public GameState checkState() {
        return null;
    }

    @Override
    public void switchState() {

    }
}