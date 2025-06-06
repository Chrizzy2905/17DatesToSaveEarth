
import greenfoot.*;

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

    private String _name = "";

    public String getName() {
        return _name;
    }

    public void act() {

    }
}
