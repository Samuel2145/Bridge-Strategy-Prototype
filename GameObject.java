public abstract class GameObject {

    GameObjectStrategy strategy;
    int xPos, yPos;
    String image;
    boolean renderable, moveable;
    public abstract void render();
    public abstract GameObject clone();

}
