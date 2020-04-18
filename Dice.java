import java.util.Random;
public class Dice extends GameObject{

    int numSides;
    int numDisplaying;
    boolean canRoll;

    public Dice(int numSides, boolean roll){
        this.numSides = numSides;
        numDisplaying = 1;
        canRoll = roll;
        image = "Dice displaying number: ";
        strategy = new Draw();
    }

    @Override
    public void render() {
        strategy.execute(image + numDisplaying, xPos, yPos);
        strategy = new Draw();
    }

    @Override
    public Dice clone() {
        return this;
    }

    public void roll(){
        if(canRoll){
            System.out.println("You can roll this dice!");
            strategy = new Roll();
            Random rand = new Random();
            numDisplaying = rand.nextInt(numSides)+1;
        }else{
            System.out.println("You can't roll this dice!");
        }

    }


}
