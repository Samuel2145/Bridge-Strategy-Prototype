public class Counter extends GameObject {

    int currentValue = 0;

    Counter(){}
    Counter(int val){
        currentValue = val;
    }


    @Override
    public GameObject clone() {
        return new Counter(currentValue);
    }


    @Override
    public void Update(String e, int x, int y) {

        if(e.equals("Right Click")){
            currentValue--;
        }

        if(e.equals("Left Click")){
            currentValue++;
        }

        if(e.equals("Drag")){
            xPos = x;
            yPos = y;
        }

        if(e.equals("Space")){
            currentValue += 10;
        }

        if(e.equals("Backspace")){
            currentValue = 0;
        }

    }


    @Override
    public void Render(Renderer r) {
        r.Draw(new Sprite(), xPos, yPos);
    }
}
