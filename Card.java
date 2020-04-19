public class Card extends GameObject{

    int cardValue;
    Sprite side1, side2;
    boolean currentSide;
    public Card(int cardVal){
        cardValue = cardVal;
        side2 = new Sprite();
    }

    @Override
    public void Render(Renderer r) {
        r.Draw((currentSide ? side1 : side2), xPos, yPos);
    }

    @Override
    public Card clone() {
        return this;
    }

    @Override
    public void Update(String e, int x, int y) {

        if(e.equals("F")){
            flip();
        }

    }

    public void flip(){
        currentSide = !currentSide;
    }

}
