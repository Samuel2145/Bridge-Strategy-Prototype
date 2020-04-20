import java.util.ArrayList;
import java.util.Random;
public class Dice extends GameObject{


    int numSides;
    int numDisplaying;
    boolean canRoll;

    ArrayList<Sprite> spritesForSides = new ArrayList<>();

    public Dice(int numSides, boolean roll){
        this.numSides = numSides;
        numDisplaying = 1;
        canRoll = roll;
       // strategy = new Draw();
    }

    @Override
    public void Render(Renderer r) {
        r.Draw(sprite, xPos, yPos);
    }

    @Override
    public Dice clone() {

        //gotta do deep copy here
        Dice newDice = new Dice(numSides, canRoll);
        newDice.numDisplaying = numDisplaying;
        newDice.yPos = yPos;
        newDice.xPos = xPos;
        return newDice;
    }


    @Override
    public void Update(String e, int x, int y) {
        if(e.equals("click")){
            ///Roll
            roll();
            //strategy.execute(image,xPos,yPos);
        }
    }

    public void roll(){
        if(canRoll){
            System.out.println("You can roll this dice!");
            //strategy = new Roll();
            Random rand = new Random();
            numDisplaying = rand.nextInt(numSides)+1;
        }else{
            System.out.println("You can't roll this dice!");
        }

    }

    @Override
    public void Restore(GameObject memento) {
        super.Restore(memento);
        Dice diceMemento = (Dice)memento;
        numSides = diceMemento.numSides;
        numDisplaying = diceMemento.numDisplaying;
        canRoll = diceMemento.canRoll;
    }
}
