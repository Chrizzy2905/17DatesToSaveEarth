import greenfoot.*;
import java.util.ArrayList;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.io.*;
import com.google.gson.*;
import java.util.stream.Collectors;

public class MainScene extends World {

    private String Prefix = "background/";
    private ArrayList<NPC> NPCs = new ArrayList<NPC>();
    private GreenfootSound Audio = new GreenfootSound("Cafe.mp3");
    private Chatter chatter;
    private Dialog _dialog;

    public MainScene() {
        super(720, 405, 1);
        prepare();
    }

    private void prepare() {
        fetchDialogs();
        GreenfootImage background = new GreenfootImage(Prefix + "Cafe.png");
        background.scale(720, 405);
        setBackground(background);
        Audio.play();
        NPCs.add(new NPC("Richard"));
        NPCs.add(new NPC("Sarah"));
        NPCs.forEach(npc -> addObject(npc, 550, 200));
        _dialog = new Dialog(chatter);
        addObject(_dialog, 350, 200);
        _dialog.next();
    }

    private void fetchDialogs() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("dialogs/Cafe.json");
                BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {
            String json = reader.lines().collect(Collectors.joining("\n"));
            Gson gson = new Gson();
            chatter = gson.fromJson(json, Chatter.class);
            for (Node n : chatter.nodes) {
                if (n.options != null) {
                    for (Option o : n.options) {
                        o.next = findNextNode(o.next_node, chatter.nodes);
                    }
                }
                n.next = findNextNode(n.next_node, chatter.nodes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Node findNextNode(String node, ArrayList<Node> nodes) {
        for (Node m : nodes) {
            if (m.node.equals(node)) {
                return m;
            }
        }
        return null;
    }

    public void act() {
        if (Greenfoot.mouseClicked(null)) {
            _dialog.next();
        }
    }
}
