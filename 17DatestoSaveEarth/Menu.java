import greenfoot.*;

public class Menu extends World
{
    public Menu()
    {    
        super(720, 405, 1);
        GreenfootImage bg = new GreenfootImage("SplashScreen.jpg");
        bg.scale(720, 405);
        setBackground(bg);
        
        MenuButton newGame = new MenuButton("New Game", Action.NEWGAME);
        addObject(newGame, 100, 200);
        MenuButton loadGame = new MenuButton("Load Game", Action.LOAD);
        addObject(loadGame, 100, 240);
        MenuButton exitGame = new MenuButton("Exit", Action.EXIT);
        addObject(exitGame, 100, 280);
    }
}
