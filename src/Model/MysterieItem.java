package Model;
import java.util.Random;

public class MysterieItem extends Item{
    private Mysteries mysterie;

    public MysterieItem(int x, int y) {
        super(x, y);
        pickMysterie();
    }
    public void pickMysterie(){
        Random r = new Random();
        int r1 = r.nextInt(7);
        switch (r1){
            case 1:
                mysterie = Mysteries.ADDITIVA;
                break;
            case 2:
                mysterie = Mysteries.MULLTIPLICITET;
                break;
            case 3:
                mysterie = Mysteries.DEMAGOG;
                break;
            case 4:
                mysterie = Mysteries.AVGRUNDSVRÅL;
                break;
            case 5:
                mysterie = Mysteries.NARCISSUS;
                break;
            case 6:
                mysterie = Mysteries.TIDSHOPP;
                break;
        }
    }

    public Mysteries getMysterie() {
        return mysterie;
    }
}