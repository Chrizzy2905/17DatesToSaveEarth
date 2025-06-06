import greenfoot.*;

public class Dialog extends Actor {
    private Boolean _isVisible = true;
    private String Prefix = "assets/";
    private GreenfootImage image = new GreenfootImage(Prefix + "Textbox.png");
    private Talker _currentTalker;
    private Chatter _chatter;
    private Node _currentNode;

    public Dialog(Chatter chatter) {
        _chatter = chatter;
        _currentTalker = new Talker();
    }

    public void push(Node node) {
        for (Talker t : _chatter.actors) {
            if (t.id == (node.talker)) {
                _currentTalker = t;
                break;
            }
        }
        image = new GreenfootImage(Prefix + "Textbox.png");
        GreenfootImage characterName = new GreenfootImage(_currentTalker.name, 100, Color.BLACK, new Color(0, 0, 0, 0));
        GreenfootImage text = new GreenfootImage(node.text, 50, Color.WHITE, new Color(0, 0, 0, 0));
        image.drawImage(text, (image.getWidth() - characterName.getWidth()) / 15, 1150);
        image.drawImage(characterName, 300, 950);
        image.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setImage(image);
    }

    public boolean next() {
        if (_currentNode == null) {
            _currentNode = _chatter.nodes.get(0);
            push(_currentNode);
        } else {
            if (null == _currentNode.next) {
                return false; // No next node, end of dialog
            }
            push(_currentNode.next);
            _currentNode = _currentNode.next;
        }
        return true; // Successfully moved to the next dialog node
    }
}
