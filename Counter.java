public class Counter extends GameObject {

    int currentValue = 0;

    Counter(){}
    Counter(int val){
        currentValue = val;
    }


    @Override
    public void render() {
        render.execute("Image of Counter", xPos, yPos);
    }

    @Override
    public GameObject clone() {
        return new Counter(currentValue);
    }

    @Override
    public void update(String e, int x, int y) {

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


}
