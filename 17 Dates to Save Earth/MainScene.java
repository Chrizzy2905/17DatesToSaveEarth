import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScene extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        NPC Richard = new NPC("Richard", 0);
        NPC Bulma = new NPC("Bulma", 10);
        addObject(Richard,500,200);
        addObject(Bulma,100,200);
        addObject(new Dialog(), 300, 200);
        setBackground("TestBG.jpg");
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
