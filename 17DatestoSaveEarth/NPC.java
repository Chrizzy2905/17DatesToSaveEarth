
import greenfoot.*;

public class NPC extends Actor {

    private GreenfootImage _image;
    private String Prefix = "characters/";

    public NPC(String name) {
        super();
        _image = new GreenfootImage(Prefix + name + ".png");
        System.out.println(_image.getWidth() + "x" + _image.getHeight());
        scaleToHeight(_image, Enviroment.RES_Y);
        setImage(_image);
        _name = name;
    }

    private String _name = "";

    public String getName() {
        return _name;
    }

    public static void scaleToHeight(GreenfootImage img, int height) {
        img.scale((int)(img.getWidth() * height / (double)img.getHeight()), height);
    }

    public void setVisible(boolean visible) {
        if (visible) {
            getImage().setTransparency(255);
        } else {
            getImage().setTransparency(0);
        }
    }
}
