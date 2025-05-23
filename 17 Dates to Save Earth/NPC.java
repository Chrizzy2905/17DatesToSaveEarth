
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC extends Actor {
    private GreenfootImage _image;
    private String Prefix = "characters/";
    public NPC(String name) {
        super();
        _image = new GreenfootImage(Prefix + name + ".png");
        _image.scale(360, 400);
        setImage(_image);
        _name = name;
        
        
        }
    
    private int _affection = 0;

    public int getAffection() {
        return _affection;
    }

    public void setAffection(int value) {
        _affection = value;
    }
    
    public void addAffection(int value){
        _affection += value;
    }
    
    private String _name = "";

    public String getName() {
        return _name;
    }
    
    /**
     * Act - do whatever the NPC wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {

    }
}
