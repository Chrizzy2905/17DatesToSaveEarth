import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialog extends Actor
{
    private Boolean _isVisible = true;
    
    public Dialog(){
        GreenfootImage image = new GreenfootImage("TextBox.png");
        GreenfootImage characterName = new GreenfootImage("Richard", 100, Color.WHITE, new Color(0,0,0,0));
        GreenfootImage text = new GreenfootImage("Hi Hübscher wie geht's? Meow.", 50, Color.WHITE, new Color(0,0,0,0));
        
        image.drawImage(characterName, 150, 500);
        
        image.drawImage(text, (image.getWidth() - characterName.getWidth()) / 2, 
        (image.getHeight() - characterName.getHeight())/2);
        image.scale(600, 400);
        setImage(image);
    }
    /**
     * Act - do whatever the Dialog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
