import java.util.ArrayList;

public class GameObjectCollection extends GameObject {

    ArrayList<GameObject> objectsInCollection = new ArrayList<>();


    @Override
    public GameObject clone() {

        GameObjectCollection result = new GameObjectCollection();
        for(GameObject obj : objectsInCollection){
            result.objectsInCollection.add(obj.clone());
        }

        result.sprite = sprite;
        result.xPos = xPos;
        result.yPos = yPos;
        return this;
    }

    @Override
    public void Update(String e, int x, int y) {

        if(e.equals("Drag")){
            //either random or from end of list?
        }


    }

    @Override
    public void Render(Renderer r) {
        r.Draw(sprite, xPos, yPos);
    }
}
