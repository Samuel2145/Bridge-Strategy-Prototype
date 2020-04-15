//import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        //Dice d = new Dice(new DiceStrategy(6));
        Dice d2 = new Dice(new DiceStrategy(20));
        //Dice d3 = new Dice(new DiceStrategy(30));
        //Card c = new Card(new CardStrategy());

        System.out.println("Dice Example");
        d2.draw(); //
        d2.roll(); /// random
        Dice d4 = d2.clone();
        d2.draw();
        d4.draw();

        /*System.out.println("\n");
        d.roll();
        d2.roll();
        d3.roll();
        d.draw(); ///Expected some random number
        d2.draw();
        d3.draw();

        System.out.println("\nCard Example");
        c.draw(); ///Expected Back Side
        c.flip();
        c.draw(); ///Expected Front Side
        c.flip();
        c.draw();///Back Side again

        System.out.println("\nError Examples");
        d.flip();
        c.roll();*/


    }

}
