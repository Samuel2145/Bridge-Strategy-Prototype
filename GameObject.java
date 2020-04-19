public abstract class GameObject implements IRenderable{

    GameObjectStrategy strategy;
    GameObjectStrategy render;
    int xPos, yPos;
    String image;
    boolean renderable, moveable;
    public abstract void Render();
    public abstract GameObject clone();
    public abstract void update(String e, int x, int y);

}
