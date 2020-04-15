import java.util.Random;

public class DiceStrategy implements  Render {

    int numDisplaying;
    int numSides;
    int x;
    int y;

    public DiceStrategy(int sides){
        numDisplaying = 1;
        x = 0;
        y = 0;
        numSides = sides;
    }

    @Override
    public void draw() {
        System.out.println("Number displaying is: " + numDisplaying);
    }

    @Override
    public void roll() {
        Random rand = new Random();
        int x = rand.nextInt(numSides) + 1;
        numDisplaying = x;
    }

    @Override
    public void flip(){
        System.out.println("You can't flip a dice");
    }

    public Render clone(){
        return new DiceStrategy(numSides);
    }

}
