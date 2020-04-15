public class Card extends GameObject{

    //Render r;

    public Card(Render x){
        this.r = x;
    }

    public void draw(){
        r.draw();
    }

    public void roll(){
        r.roll();
    }

    public void flip(){
        r.flip();
    }

}
