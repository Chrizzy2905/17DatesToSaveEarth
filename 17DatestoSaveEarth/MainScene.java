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
    private boolean _isDecision = false;
    private ArrayList<Decision> _decisions = new ArrayList<Decision>();
    private ArrayList<SceneData> _scenes = new ArrayList<SceneData>() {
        {
            add(new SceneData("prologe.png", "Cafe.mp3", "dialogs/Cafe.json"));
            add(new SceneData("restaurant.png", "FirstDate.mp3", "dialogs/FirstDate.json"));
            add(new SceneData("restaurant.png", "SecondDate.mp3", "dialogs/SecondDate.json"));
            add(new SceneData("ending.png", "MainMenu.mp3", ""));
        }
    };

    private SceneData _currentScene = _scenes.get(0);

    public MainScene() {
        super(Enviroment.RES_X, Enviroment.RES_Y, 1);
        prepare();
    }

    private void prepare() {
        fetchDialogs(_currentScene._dialogPath);
        GreenfootImage background = new GreenfootImage(Prefix + _currentScene._backgroundImagePath);
        background.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setBackground(background);
        Audio.play();
        NPCs.add(new NPC("Richard"));
        NPCs.add(new NPC("Sarah"));
        addObject(NPCs.get(0), Enviroment.RES_X / 100 * 50, Enviroment.RES_Y - Enviroment.RES_Y / 2);
        addObject(NPCs.get(1), Enviroment.RES_X / 100 * 50, Enviroment.RES_Y - Enviroment.RES_Y / 2);
        NPCs.forEach(npc -> npc.setVisible(false));
        _dialog = new Dialog(chatter);
        addObject(_dialog, Enviroment.RES_X / 2, Enviroment.RES_Y - Enviroment.RES_Y / 2);
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
        if (Greenfoot.mouseClicked(null) && !_isDecision) {
            if (!_dialog.next()) {
                nextScene();
            } else {
                switch (_dialog._currentTalker.name) {
                    case "Richard":
                    case "Richard und Spieler":
                        NPCs.get(0).setVisible(true);
                        break;
                    case "Sarah":
                        NPCs.get(1).setVisible(true);
                        break;
                    case "Player":
                    case "Narrator":
                    case "Kellner":
                    case "Manager":
                        break;
                    default:
                        System.out.println("Unknown character is talking");
                }

                if (_dialog._currentNode.options != null) {
                    _isDecision = true;
                    int offsetY = -80;
                    for (Option o : _dialog._currentNode.options) {
                        Decision temp = new Decision(_dialog,o, _decisions);
                        addObject(temp,Enviroment.RES_X / 2, Enviroment.RES_Y / 2 + offsetY);
                        offsetY += 80;
                        _decisions.add(temp);
                    }
                }
            }
        }
    }

    private void nextScene() {
        _currentScene = _scenes.get((_scenes.indexOf(_currentScene) + 1) % _scenes.size());
        changeScenario(_currentScene._backgroundImagePath, _currentScene._audioPath, _currentScene._dialogPath);
    }

    private void changeScenario(String backgroundPath, String audioPath, String dialogPath) {
        NPCs.forEach(npc -> npc.setVisible(false));
        fetchDialogs(dialogPath);
        _dialog.reset(chatter);
        GreenfootImage background = new GreenfootImage(Prefix + backgroundPath);
        background.scale(Enviroment.RES_X, Enviroment.RES_Y);
        setBackground(background);
        Audio.stop();
        Audio = new GreenfootSound(audioPath);
        Audio.play();
    }
}
