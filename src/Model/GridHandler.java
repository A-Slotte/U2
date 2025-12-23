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
    private List<GridPos> gridUpdates = new ArrayList<>();
    private List<GridPos> suprisePos = new ArrayList<>();

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

    public List<GridPos> getGridUpdates(){
        return gridUpdates;
    }
    public Grid getGrid(){
        return grid;
    }

    public void placePiece(int y, int x, GameState state){
        switch (state){
            case PLAYER1:
                grid.getItemGrid()[y][x] = new PlayerItem(y, x, ItemType.P1);
                gridUpdates.add(new GridPos(y, x, ItemType.P1));
                p1Score++;
                nbrSpaces--;
                checkAdjacent(y, x, ItemType.MYSTERY, ItemType.P1);
                break;
            case PLAYER2:
                grid.getItemGrid()[y][x] = new PlayerItem(y, x, ItemType.P2);
                gridUpdates.add(new GridPos(y, x, ItemType.P2));
                nbrSpaces--;
                checkAdjacent(y, x, ItemType.MYSTERY, ItemType.P2);
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

    /**
     * Check för alla 8 grannar av en placerad pjäs.
     * @param x X värde.
     * @param y Y värde.
     * @param type Anger vilken typ av pjäs som kontrolleras.
     */
    public void checkAdjacent(int y, int x, ItemType type, ItemType player) {

        for(int i = -1; i < 2; i++){
            for(int j = - 1; j < 2; j++){
                if(checkBounds(y+i,x+j) && grid.getItemGrid()[y+i][x+j] != null){
                    var item = grid.getItemGrid()[y+i][x+j];
                    if(i == 0 && j == 0){
                        continue;
                    }
                    if(item.getType() == ItemType.MYSTERY){
                        checkIfMysterieUncovered(y, x, y+i, x+j);
                    }
                    if(item.getType() == player){
                        continue;
                    }
                    if (searchForSurprises(y, x, i, j, player)){
                        suprised(player);
                    }
                }
            }
        }
    }

    private void suprised(ItemType type) {
        for(var pos : suprisePos){

            var y = pos.y();
            var x = pos.x();
            gridUpdates.add(new GridPos(y, x, type));
            grid.getItemGrid()[y][x] = new PlayerItem(y, x, type);
        }
        suprisePos.clear();
    }

    private boolean searchForSurprises(int y, int x, int deltaY, int deltaX, ItemType baseType) {
        var nextY = y + deltaY;
        var nextX = x + deltaX;
        var bounds = checkBounds(nextY, nextX);
        if(bounds != true){
            return false;
        }
        var nextPos = grid.getItemGrid()[nextY][nextX];
        if (nextPos == null || nextPos.getType() == ItemType.MYSTERY) {
            return false;
        }
        if (nextPos.getType() == baseType){
            return true;
        }
        else {
            suprisePos.add(new GridPos(y, x, baseType));
            return searchForSurprises(nextY, nextX, deltaY, deltaX, baseType);
        }
    }


    /**
     * Check för att ett Mysterie har två motsatta(spegelvända) playerItems med samma Boolean player.
     * @param playerY Y värde för placerad pjäs
     * @param playerX X värde för placerad pjäs
     * @param y Y värdet för mysteriet som kontrolleras.
     * @param x X värdet för mysteriet som kontrolleras.
     */
    public void checkIfMysterieUncovered(int playerY, int playerX, int y, int x) {
        var diffY = playerY - y; //diffY ger motsatta y
        var diffX = playerX - x; //diffX get motsatta x

        var myst = (MysterieItem) grid.getItem(y, x);
        var piece = (PlayerItem) grid.getItem(playerY, playerX);

        if(checkBounds(y - diffY, x - diffX)){
            var posCheck = grid.getItemGrid()[y - diffY][x - diffX];
            if (posCheck != null && posCheck.getClass() == PlayerItem.class){
                var temp = (PlayerItem) posCheck;
                if(temp.getType() == piece.getType()){
                    mEvent(myst.getMysterie(), y, x);
                    System.out.println("uncovered");
                }
            }
        }
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