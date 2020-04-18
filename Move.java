public class Move implements GameObjectStrategy {

    @Override
    public void execute(String image, int x, int y) {
        System.out.println("Moving " + image + " to X-Coordinate: " + x + " and Y-Coordinate: " + y);
    }
}
