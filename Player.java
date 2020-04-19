import java.util.ArrayList;

public class Player {

    String name;
    int tablePosition;
    ArrayList<Integer> hand;

    public Player(String name, int tablePosition) {
        this.name = name;
        this.tablePosition = tablePosition;
    }

    public void putGameObjectInHand(int selectedGameObject){
        hand.add(selectedGameObject);
    }

    public void removeIDFromHand(int selectedGameObject){
        hand.remove((Integer) selectedGameObject);
    }


}