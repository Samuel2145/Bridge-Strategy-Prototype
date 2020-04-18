public class Draw implements GameObjectStrategy {

    @Override
    public void execute(String image, int x, int y) {
        System.out.println("Drawing " + image + " at X-Coordinate: " + x + " and Y-Coordinate: " + y);
    }
}
