import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
enum Action {
    NEWGAME,
    LOAD,
    EXIT
}

public class MenuButton extends Actor
{
    private String Prefix = "assets/";
    /**
     * Act - do whatever the MenuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MenuButton(String text, Action action){
        _action = action;
        GreenfootImage image = new GreenfootImage(Prefix + "Menu.png");
        GreenfootImage buttonText = new GreenfootImage(text, 20, Color.WHITE, new Color(0,0,0,0));
        image.scale(150, 30);
        image.drawImage(buttonText, (image.getWidth() - buttonText.getWidth()) / 2, 
        (image.getHeight() - buttonText.getHeight())/2);
        
        setImage(image);
        
    }
    private Action _action = Action.NEWGAME;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            switch(_action){
                case Action.NEWGAME:
                    Greenfoot.setWorld(new MainScene());
                    break;
                case Action.LOAD:
                    System.out.println("Load pressed");
                    break;
                case Action.EXIT:
                    System.out.println("Exit pressed");
                    break;
                default:
                    System.out.println("Exit pressed");
            }
        }
        // Add your action code here.
    }
}
