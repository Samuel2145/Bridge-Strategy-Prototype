public abstract class GameObject implements IRenderable{

    GameObjectStrategy strategy;
    GameObjectStrategy render = new Draw();
    int xPos, yPos;
    int GUID; //global identifier for object
    String image;
    boolean renderable, moveable;
    public abstract void Render();
    public abstract GameObject clone();
    public abstract void update(String e, int x, int y);
    GameObject Save(){
        return clone();
    }
    public void Restore(GameObject memento){
        xPos = memento.xPos;
        yPos = memento.yPos;
    }

}
