package Controller;

import Modules.Grid;
import View.MainFrame;

public class Controller {
    private MainFrame mainFrame;
    private Grid grid;

    public Controller(){
        MainFrame mainFrame = new MainFrame( this);
        //run();
    }
    public void run(){
        grid = new Grid();
    }
}