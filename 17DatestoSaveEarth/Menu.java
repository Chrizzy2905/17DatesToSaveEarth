import greenfoot.*;

public class Menu extends World
{
    public Menu()
    {    
        super(Enviroment.RES_X, Enviroment.RES_Y, 1);
        GreenfootImage bg = new GreenfootImage("SplashScreen.jpg");
        bg.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setBackground(bg);

        MenuButton newGame = new MenuButton("New Game", Action.NEWGAME);
        addObject(newGame, Enviroment.RES_X / 100 * 20, Enviroment.RES_Y / 100 * 50);
        // MenuButton loadGame = new MenuButton("Load Game", Action.LOAD);
        // addObject(loadGame, 100, 240);
        MenuButton exitGame = new MenuButton("Exit", Action.EXIT);
        addObject(exitGame, Enviroment.RES_X / 100 * 20, Enviroment.RES_Y / 100 * 65);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
