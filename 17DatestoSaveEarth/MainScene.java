import greenfoot.*;
import java.util.ArrayList;
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
        super(Enviroment.RES_X, Enviroment.RES_Y, 1);
        prepare();
    }

    private void prepare() {
        fetchDialogs("dialogs/Cafe.json");
        GreenfootImage background = new GreenfootImage(Prefix + "prologe.png");
        background.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setBackground(background);
        Audio.play();
        NPCs.add(new NPC("Richard"));
        NPCs.add(new NPC("Sarah"));
        NPCs.forEach(npc -> addObject(npc, Enviroment.RES_X / 100 * 80, Enviroment.RES_Y - Enviroment.RES_Y / 2));
        _dialog = new Dialog(chatter);
        addObject(_dialog, Enviroment.RES_X/2, Enviroment.RES_Y - Enviroment.RES_Y / 2);
        _dialog.next();
    }

    private void fetchDialogs(String dialogFile) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(dialogFile);
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
            if (!_dialog.next()){
                nextScene();
            }
        }
    }

    private void nextScene() {
        changeScenario("restaurant", "FirstDate.mp3", "dialogs/FirstDate.json");
    }

    private void changeScenario(String backgroundPath, String audioPath, String dialogPath) {
        fetchDialogs(dialogPath);
        GreenfootImage background = new GreenfootImage(Prefix + backgroundPath);
        background.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setBackground(background);
        Audio.stop();
        Audio = new GreenfootSound(audioPath);
        Audio.play();
    }
}
