import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.awt.List;
import java.util.ArrayList;
/**
 * Write a description of class Dialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dialog extends Actor
{
    private Boolean _isVisible = true;
    private List _dialogs = new List();
    private String Prefix = "assets/";
    private ArrayList<Talker> _talker;
    private GreenfootImage image = new GreenfootImage(Prefix + "Textbox.png");
    private Talker _currentTalker;
    public Dialog(ArrayList<Talker> talker){
        _talker = talker;
        _currentTalker = new Talker();
        
    }
    public void push(Node node){
        for(Talker t : _talker){
            if(t.id == (node.talker)){
                _currentTalker = t;
                break;
            }
        }
        GreenfootImage characterName = new GreenfootImage(_currentTalker.name, 100, Color.BLACK, new Color(0,0,0,0));
        GreenfootImage text = new GreenfootImage(node.text, 50, Color.WHITE, new Color(0,0,0,0));
        image.drawImage(text, (image.getWidth() - characterName.getWidth()) / 15, 
        1150);
        image.drawImage(characterName, 300, 950);
        image.scale(720, 405);
        setImage(image);
    }
}
