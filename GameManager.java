import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GameManager {

    HashMap<Integer, GameObject> gameObjects = new HashMap<>();


    //caretaker for memento stuff here
    Stack<GameObject> objectHistories = new Stack<>();

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
            foundObject.update("Left Click", leftClickPosX, leftClickPosY);
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
            gameObject.Render();
        }
    }




}
