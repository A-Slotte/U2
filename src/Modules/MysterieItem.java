package Modules;
import java.util.Random;

public class MysterieItem extends Item{
    private Mysteries mysterie;
    public MysterieItem(int x, int y) {
        super(x, y);
        pickMysterie();
    }
    public void pickMysterie(){
        Random r = new Random();
        int r1 = r.nextInt(6);

    }

}