import greenfoot.*;

public class Decision extends Actor
{
    private String Prefix = "assets/";
    public Decision(String text){
        GreenfootImage image = new GreenfootImage(Prefix + "Menu.png");
        GreenfootImage buttonText = new GreenfootImage(text, 20, Color.WHITE, new Color(0,0,0,0));
        image.scale(150, 30);
        image.drawImage(buttonText, (image.getWidth() - buttonText.getWidth()) / 2, 
        (image.getHeight() - buttonText.getHeight())/2);
        setImage(image);
    }

    public void act()
    {
        
    }
}
