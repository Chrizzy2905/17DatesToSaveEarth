import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.lang.Object;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.awt.List;
import com.google.gson.Gson;
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
    private GreenfootSound Audio = new GreenfootSound("Cafe.mp3");
    
    public MainScene()
    {    
        super(720, 405, 1); 
        prepare();
    }
    
    private void prepare()
    {
        GreenfootImage background = new GreenfootImage(Prefix + "Cafe.png");
        background.scale(720,405);
        setBackground (background);
        Audio.play();
        NPCs.add(new NPC("Richard"));
        NPCs.add(new NPC("Sarah"));
        NPCs.forEach(npc -> addObject(npc, 550, 200));
        addObject(new Dialog(), 350,200 );
    }
    
    private void fetchDialogs()
    {
         InputStream input = getClass().getClassLoader().getResourceAsStream("dialogs/Cafe.json");
         Gson gson = new Gson();
         
        /*try(BufferedReader reader = new BufferedReader(new FileReader("dialogs/Cafe.json"))){
            while(reader.ready()) {
                 _dialogs.add(reader.readLine());
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }*/
    }
}
