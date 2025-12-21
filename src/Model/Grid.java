package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Grid {



    private int boundsY;
    private int boundsX;

    private Item[][] itemGrid;
    private List<GridUpdate> mysteryPos;
    public Grid(int width, int height, int nbrOfMysteries){
        this.boundsY = height - 1;
        this.boundsX = width - 1;
        generateGrid(nbrOfMysteries, height, width);
    }

    public Item[][] getItemGrid(){
        return itemGrid;
    }

    public List<GridUpdate> getMysteryPos(){
        return mysteryPos;
    }
    public Item getItem(int y, int x){
        return itemGrid[y][x];
    }

    public void generateGrid(int nbrOfMysteries, int height, int width) {
        itemGrid = new Item[height][width];
        mysteryPos = new ArrayList<>();

        Random r = new Random();
        int nbr = 0;
        while (nbr <= nbrOfMysteries){
            var rY = r.nextInt(0,8);
            var rX = r.nextInt(0, 8);
            if (rX == 0 && rY == 0 || rX == boundsX && rY == 0 || rY == boundsY && rX == 0 || rY == boundsX && rX == boundsY){
            }
            else if(itemGrid[rY][rX] == null){
                itemGrid[rY][rX] = new MysterieItem(rX, rY);
                mysteryPos.add(new GridUpdate(rY, rX, ItemType.MYSTERY));
                nbr++;
            }
        }
    }
}