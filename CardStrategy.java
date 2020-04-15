public class CardStrategy implements Render {

    String card;
    int x;
    int y;

    public CardStrategy(){
        card = "Back Side";
        x = 0;
        y = 0;
    }

    @Override
    public void draw() {
        System.out.println("Side showing is: " + card);
    }

    @Override
    public void roll() {
        System.out.print("You can't roll a card!");
    }

    public void flip(){
        if(card.compareTo("Back Side") == 0){
            card = "Front Side";
        }else{
            card = "Back Side";
        }
    }

    @Override
    public Render clone() {
        return this;
    }

}
