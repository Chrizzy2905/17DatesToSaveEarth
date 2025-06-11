import greenfoot.*;

enum Action {
    NEWGAME,
    LOAD,
    EXIT
}

public class MenuButton extends Actor
{
    private String Prefix = "assets/";
    private Action _action = Action.NEWGAME;
 
    public MenuButton(String text, Action action){
        _action = action;
        GreenfootImage image = new GreenfootImage(Prefix + "Menu.png");
        GreenfootImage buttonText = new GreenfootImage(text, 40, Color.WHITE, new Color(0,0,0,0));
        image.scale(Enviroment.RES_X / 100 * 25, 60);
        image.drawImage(buttonText, (image.getWidth() - buttonText.getWidth()) / 2, 
        (image.getHeight() - buttonText.getHeight())/2);
        
        setImage(image);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            switch(_action){
                case NEWGAME:
                    Greenfoot.setWorld(new MainScene());
                    break;
                case LOAD:
                    System.out.println("Load pressed");
                    break;
                case EXIT:
                    System.out.println("Exit pressed");
                    break;
                default:
                    System.out.println("Exit pressed");
            }
        }
    }
}
