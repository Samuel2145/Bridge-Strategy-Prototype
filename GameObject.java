public abstract class GameObject {

    GameObjectStrategy strategy;
    GameObjectStrategy render;
    int xPos, yPos;
    String image;
    boolean renderable, moveable;
    public abstract void render();
    public abstract GameObject clone();
    public abstract void update(String e, int x, int y);

}
