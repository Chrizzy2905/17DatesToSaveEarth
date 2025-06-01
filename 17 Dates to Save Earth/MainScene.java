import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.lang.Object;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.awt.List;
import com.google.gson.Gson;
import java.util.stream.Collectors;
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
    private Chatter chatter;
    private Dialog _dialog;
    public MainScene()
    {    
        super(720, 405, 1); 
        prepare();
    }
    
    private void prepare()
    {
        fetchDialogs();
        GreenfootImage background = new GreenfootImage(Prefix + "Cafe.png");
        background.scale(720,405);
        setBackground (background);
        Audio.play();
        NPCs.add(new NPC("Richard"));
        NPCs.add(new NPC("Sarah"));
        NPCs.forEach(npc -> addObject(npc, 550, 200));
        _dialog = new Dialog(chatter.actors);
        addObject(_dialog, 350,200 );
        _dialog.push(chatter.nodes.get(0));
    }
    
    private void fetchDialogs()
    {
         InputStream input = getClass().getClassLoader().getResourceAsStream("dialogs/Cafe.json");
         String json = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));
         Gson gson = new Gson();
         chatter = gson.fromJson(json, Chatter.class);
    }
}
