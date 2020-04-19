public class Card extends GameObject{

    int cardValue;
    String side;
    boolean canFlip;
    public Card(int cardVal, boolean flip){
        cardValue = cardVal;
        side = "Back Side";
        canFlip = flip;
        image = "Card with value of: ";
        strategy = new Draw();
    }

    @Override
    public void Render() {
        strategy.execute(image + cardValue + " Displaying: " + side,xPos,yPos);
        strategy = new Draw();
    }

    @Override
    public Card clone() {
        return this;
    }

    @Override
    public void update(String e, int x, int y) {

    }

    public void flip(){
        if(canFlip){
            System.out.println("You can flip this card!");
            strategy = new Flip();
            side = "Front Side";
        }else{
            System.out.println("You can't flip this card!");
        }
    }


}
