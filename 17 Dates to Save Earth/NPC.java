
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC extends Actor {

    public NPC(String name, int affection) {
        _name = name;
        _affection = affection;
    }
    
    private int _affection = 0;

    public int getaffection() {
        return _affection;
    }

    public void setaffection(int value) {
        _affection = value;
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
