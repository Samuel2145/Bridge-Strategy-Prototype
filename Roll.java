public class Roll implements GameObjectStrategy {

    @Override
    public void execute(String image, int x, int y) {
        System.out.println("Rolling " + image + " at X-Coordinate: " + x + " and Y-Coordinate: " + y);
    }
}
