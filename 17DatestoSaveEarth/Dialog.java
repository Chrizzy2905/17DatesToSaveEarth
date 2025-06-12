import greenfoot.*;

public class Dialog extends Actor {
    private String Prefix = "assets/";
    private GreenfootImage image = new GreenfootImage(Prefix + "Textbox.png");
    public Talker _currentTalker;
    private Chatter _chatter;
    public Node _currentNode;

    public Dialog(Chatter chatter) {
        _chatter = chatter;
        _currentTalker = new Talker();
    }

   public void setVisible(boolean visible) {
        if (visible) {
            getImage().setTransparency(255);
        } else {
            getImage().setTransparency(0);
        }
    }

    public void push(Node node) {
        for (Talker t : _chatter.actors) {
            if (t.id == (node.talker)) {
                _currentTalker = t;
                break;
            }
        }
        image = new GreenfootImage(Prefix + "Textbox.png");
        if(_currentTalker.name.equals("Player")) {
            _currentTalker.name = Enviroment.PLAYER_NAME;
        }
        GreenfootImage characterName = new GreenfootImage(_currentTalker.name, 100, Color.BLACK, new Color(0, 0, 0, 0));
        GreenfootImage text = new GreenfootImage(node.text, 50, Color.WHITE, new Color(0, 0, 0, 0));
        image.drawImage(text, (image.getWidth() - characterName.getWidth()) / 15, 1150);
        image.drawImage(characterName, 200, 950);
        image.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setImage(image);
    }

    public boolean next() {
        if (_currentNode == null) {
            _currentNode = _chatter.nodes.get(0);
            push(_currentNode);
        } 
        else {
             if (null == _currentNode.next) {
                System.out.println("setVisible(false)");
                setVisible(false);
                return false; // No next node, end of dialog
             }
             else {
                 _currentNode = _currentNode.next;
                 push(_currentNode);
             }
         }
        return true; // Successfully moved to the next dialog node
    }

    public void reset(Chatter nextChatter) {
        _chatter = nextChatter;
        _currentNode = null;
        _currentTalker = new Talker();
    }
}
