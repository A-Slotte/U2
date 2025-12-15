package Controller;

import View.MainFrame;

public class Controller {
    private MainFrame mainFrame;

    public Controller(){
        MainFrame mainFrame = new MainFrame( this);
    }
}