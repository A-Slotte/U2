package Model;

import Controller.GameState;

import java.util.ArrayList;
import java.util.List;

public class GridHandler {
    private Grid grid;
    private int remainingMysteries;
    private int p1Score = 0;
    private int p2Score = 0;
    private List<GridUpdate> gridUpdates = new ArrayList<>();

    public GridHandler(int height, int width, int nbrOfMysteries){
        this.grid = new Grid(width, height, nbrOfMysteries);
        remainingMysteries = nbrOfMysteries;
    }
    public int getP1Score(){
        return p1Score;
    }
    public int getP2Score(){
        return p2Score;
    }

    public List<GridUpdate> getGridUpdates(){
        return gridUpdates;
    }

    public void placePiece(int x, int y, GameState state){
        switch (state){
            case PLAYER1:
                grid.getItemGrid()[y][x] = new PlayerItem(x, y);
                gridUpdates.add(new GridUpdate(y, x, ItemType.P1));
                p1Score++;
                break;
            case PLAYER2:
                grid.getItemGrid()[y][x] = new PlayerItem(x, y);
                gridUpdates.add(new GridUpdate(y, x, ItemType.P2));
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

    public void checkAdjacent(int x, int y, Boolean player) {
        for(int i = -1; i < 2; i++){
            for(int j = - 1; j < 2; j++){
                if(checkBounds(y+i,x+j)){
                    if(grid.getItemGrid()[y+i][x+j].getClass() == MysterieItem.class){
                        checkIfMysterieUncovered(y, x, y+i, x+j, player);
                    }
                }
            }
        }
    }

    public void checkIfMysterieUncovered(int playerY, int playerX, int y, int x, boolean player) {
        if(y > playerY && x > playerX && checkBounds(y+2,x+2)){
            if(grid.getItemGrid()[playerY][playerX].getClass() == grid.getItemGrid()[y+2][x+2].getClass()){

            }
        }

    }

    public Grid getGrid(){
        return grid;
    }




    public void mEvent(Mysteries m, int x, int y){
        switch (m){
            case DEMAGOG -> demagogEvent(x, y);
            case ADDITIVA -> additivtEvent(x, y);
            case TIDSHOPP -> tidshoppEvent(x, y);
            case AVGRUNDSVRÅL -> vrålEvent(x, y);
            case NARCISSUS -> narcissusEvent(x, y);
            case MULLTIPLICITET -> multiplicitetEvent(x, y);
        }
    }

    private void multiplicitetEvent(int x, int y) {
        for (int i = - 1; i < 2; i++){
            for (int j = - 1; j < 2; j++){
                if (j == 0 && i != 0 || i == 0 && j != 0){
                }
                else if(checkBounds(y + i, x + j) && grid.getItemGrid()[y +i][x + j].getClass() != MysterieItem.class){
                    grid.getItemGrid()[y + i][x + j] = new PlayerItem(x + j, y + i);
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
}