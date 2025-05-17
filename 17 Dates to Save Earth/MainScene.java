import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScene extends World
{
    private String Prefix = "background/";
    private ArrayList<NPC> NPCs = new ArrayList<NPC>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 405, 1); 
        NPCs.add(new NPC("Richard", 0));
        NPCs.add(new NPC("Sarah", 0));
        addObject(new Dialog(), 350,200 );
        prepare();
        GreenfootImage background = new GreenfootImage(Prefix + "Cafe.png");
        background.scale(720,405);
        setBackground (background);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        NPCs.forEach(npc -> addObject(npc, 550, 200));
    }
}
