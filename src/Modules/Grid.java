package Modules;

public class Grid {

    private GridHandler gridHandler;
    private Item[][] itemGrid;
    private int nbrOfMysteries;
    public Grid(){
        generateGrid();
    }

    private void generateGrid() {
        itemGrid = new Item[8][8];
        for (var row : itemGrid){
            for(var item : row){

            }
        }
    }


    public GridHandler getGridHandler() {
        return gridHandler;
    }

}