public class Flip implements GameObjectStrategy {

    @Override
    public void execute(String image, int x, int y) {
        System.out.println("Flipping " + image + " at X-Coordinate: " + x + " and Y-Coordinate: " + y);
    }
}
