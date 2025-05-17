import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;
import java.awt.List;

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
    
    public Dialog(){
        readFromInputStream();
        GreenfootImage image = new GreenfootImage("TextBox.png");
        GreenfootImage characterName = new GreenfootImage("Richard", 100, Color.WHITE, new Color(0,0,0,0));
        GreenfootImage text = new GreenfootImage(_dialogs.getItem(0), 50, Color.WHITE, new Color(0,0,0,0));
        
        image.drawImage(characterName, 150, 1050);
        
        image.drawImage(text, (image.getWidth() - characterName.getWidth()) / 15, 
        1150);
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
    
    private void readFromInputStream()
    {
        InputStream input = getClass().getClassLoader().getResourceAsStream("dialogs/Richard.json");
        try(BufferedReader reader = new BufferedReader(new FileReader("dialogs/Richard.json"))){
            while(reader.ready()) {
                 _dialogs.add(reader.readLine());
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
