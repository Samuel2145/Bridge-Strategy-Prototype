public class Driver {

    public static void main(String[] args){
        System.out.println("Hello World!");

        GameObject[] objs = new GameObject[6];

        Dice d1 = new Dice(6,true);
        Dice d2 = new Dice(20, false);
        Card c1 = new Card(5, true);
        Card c2 = new Card(9, false);

        objs[0] = d1;
        objs[1] = d2;
        objs[2] = c1;
        objs[3] = c2;

        for(int i = 0; i < 4;i++){
            objs[i].render();
        }

        System.out.println("\n");
        d1.roll();
        d2.roll();
        c1.flip();
        c2.flip();

        System.out.println("\n");
        for(int i = 0; i < 4;i++){
            objs[i].render();
        }

        System.out.println("\n");
        for(int i = 0; i < 4;i++){
            objs[i].render();
        }

        Dice d3 = d1.clone();
        Card c3 = c1.clone();

        objs[4] = d3;
        objs[5] = c3;

        System.out.println("\n");
        for(int i = 0; i < 6;i++){
            objs[i].render();
        }





    }

}
