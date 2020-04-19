import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GameManager {

    //single instance of itself
    private static GameManager gameManager;

    HashMap<Integer, GameObject> gameObjects = new HashMap<>();

    //caretaker for memento stuff here
    Stack<GameObject> objectHistories = new Stack<>();

    Renderer renderer = new Renderer();

    ArrayList<Player> players = new ArrayList<>();

    boolean privateHands;


    private GameManager(){}

    public static GameManager GetInstance() {
        if (gameManager == null) {
            gameManager = new GameManager();
        }
        return gameManager;
    }

    public void Undo(){
        GameObject objectToChangeTo = objectHistories.pop();
        //objectToChange.GUID gets the Key for the object that has new data that we're replacing with old data
        GameObject objectToChangeFrom = gameObjects.get(objectToChangeTo.GUID);
        objectToChangeFrom.Restore(objectToChangeTo);
    }


    //some pseudocode for event handling
    public void DoSomething(){

        //lets say user left clicks on int 340, 400
        int leftClickPosX = 340;
        int leftClickPosY = 400;
        GameObject foundObject = SearchForBounds(leftClickPosX, leftClickPosY);
        if(foundObject != null) {
            objectHistories.push(foundObject.Save());
            foundObject.Update("Left Click", leftClickPosX, leftClickPosY);
            foundObject.xPos = leftClickPosX;
            foundObject.yPos = leftClickPosY;
        }

    }

    private GameObject SearchForBounds(int xPos, int yPos){

        for(GameObject gameObject : gameObjects.values()){
            //lets say all sprites are 32x32. here, we would check by bounds of sprite --> resolution
            if(Math.abs(xPos - gameObject.xPos) < 32 && Math.abs(yPos - gameObject.yPos) < 32){
                return gameObject;
            }
        }
        return null;
    }

    public void Add(GameObject objectToAdd){
        objectToAdd.GUID = gameObjects.size();
        gameObjects.put(objectToAdd.GUID, objectToAdd);
    }

    public void RenderObjects(){
        for(GameObject gameObject : gameObjects.values()){
            if(privateHands && gameObject.belongsToPlayer){
                //Render only to a certain player, somehow.
            }
            gameObject.Render(renderer);
        }
    }

    public void AddPlayer(Player p){
        players.add(p);
    }

    public void GiveObjectToPlayer(Player p, GameObject gameObject) throws Exception {
        if(!gameObjects.containsValue(gameObject)){
            throw new Exception("game object doesn't exist in list of game objects");
        }
        gameObject.belongsToPlayer = true;
        gameObjects.replace(gameObject.GUID, gameObject);
        p.putGameObjectInHand(gameObject.GUID);
    }

    public void GiveObjectToPlayer(Player p, int GUID) throws Exception {

        if(!gameObjects.containsKey(GUID)){
            throw new Exception("game object doesn't exist in list of game objects");
        }
        GameObject obj = gameObjects.get(GUID);
        obj.belongsToPlayer = true;
        gameObjects.replace(GUID, obj);
        p.putGameObjectInHand(gameObjects.get(GUID).GUID);
    }

    public void RemoveObjectFromPlayer(Player p, GameObject gameObject) throws Exception {
        if(!gameObjects.containsValue(gameObject)){
            throw new Exception("game object doesn't exist in list of game objects");
        }
        gameObject.belongsToPlayer = false;
        gameObjects.replace(gameObject.GUID, gameObject);
        p.removeIDFromHand(gameObject.GUID);
    }

    public void RemoveObjectFromPlayer (Player p, int GUID) throws Exception {

        if(!gameObjects.containsKey(GUID)){
            throw new Exception("game object doesn't exist in list of game objects");
        }
        p.removeIDFromHand(gameObjects.get(GUID).GUID);
        GameObject obj = gameObjects.get(GUID);
        obj.belongsToPlayer = false;
        gameObjects.replace(GUID, obj);
    }


}