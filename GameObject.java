public abstract class GameObject implements IRenderable{

    int xPos, yPos;
    int GUID; //global identifier for object
    Sprite sprite;
    boolean belongsToPlayer;
    public abstract GameObject clone();
    public abstract void Update(String e, int x, int y);
    GameObject Save(){
        return clone();
    }
    public void Restore(GameObject memento){
        xPos = memento.xPos;
        yPos = memento.yPos;
    }

}
