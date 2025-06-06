
import greenfoot.*;

public class NPC extends Actor {

    private GreenfootImage _image;
    private String Prefix = "characters/";

    public NPC(String name) {
        super();
        _image = new GreenfootImage(Prefix + name + ".png");
        _image.scale(Enviroment.RES_X / 100 * 50, Enviroment.RES_Y);
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
