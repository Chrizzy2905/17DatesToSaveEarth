import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{

    /**
     * Constructor for objects of class Dialog.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 405, 1);
        GreenfootImage bg = new GreenfootImage("SplashScreen.jpg");
        bg.scale(720, 405);
        setBackground(bg);
        
        // Create Menu
        MenuButton newGame = new MenuButton("New Game", Action.NEWGAME);
        addObject(newGame, 100, 200);
        MenuButton loadGame = new MenuButton("Load Game", Action.LOAD);
        addObject(loadGame, 100, 240);
        MenuButton exitGame = new MenuButton("Exit", Action.EXIT);
        addObject(exitGame, 100, 280);
    }
}
