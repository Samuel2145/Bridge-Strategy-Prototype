public class Dice extends GameObject {

    public Dice(Render x){
        this.r = x;
    }

    public Dice(Dice d2){
        this.r = d2.r;
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

    public Dice clone(){
        return new Dice(r.clone());
    }


}
