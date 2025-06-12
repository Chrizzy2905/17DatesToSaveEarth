import greenfoot.*;
import java.util.ArrayList;


public class Decision extends Actor
{
    private String Prefix = "assets/";
    private Dialog _dialog;
    private Option _option;
    private ArrayList<Decision> _decisions;
    public Decision(Dialog dialog, Option option,ArrayList<Decision> decisions){
        _option = option;
        _dialog = dialog;
        _decisions = decisions;
        GreenfootImage image = new GreenfootImage(Prefix + "Menu.png");
        GreenfootImage buttonText = new GreenfootImage(_option.text, 20, Color.WHITE, new Color(0,0,0,0));
        image.scale(Enviroment.RES_X / 2, Enviroment.RES_Y / 10);
        image.drawImage(buttonText, (image.getWidth() - buttonText.getWidth()) / 2, 
        (image.getHeight() - buttonText.getHeight())/2);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("Decision made: " + _option.text);
            _dialog.push(_option.next);
            for(Decision d: _decisions){
                getWorld().removeObject(d);
            }
        }
    }
}
