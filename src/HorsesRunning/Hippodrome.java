package HorsesRunning;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public List<Horse> getHorses() {
        return horses;
    }

    public void run(){
        for (int i = 1; i <=100 ; i++) {

            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {   e.printStackTrace();}

        }
    };
    public  void move(){
        for ( Horse var:horses
        ) {var.move();

        }

    };
    public void print(){
        for (Horse var:horses
        ) {var.print();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println();

        }
    };


    public  Horse getWinner(){
        Horse myHorses = horses.get(0);
        for (Horse var:horses
        ) {if(var.getDistance()> myHorses.getDistance()){
            myHorses=var;
        }

        }
        //return horses.stream().max(Comparator.comparingDouble(horse -> Horse.getDistance())).get();
// return horses.stream().max(Comparator.comparing(Horse::getDistance)).orElse(null);

        return myHorses; };
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    };



    public static void main(String[] args) {

        Hippodrome hippodrome = new Hippodrome(new ArrayList<>());
        Hippodrome.game = hippodrome;

        Horse horse1 = new Horse("Белка", 3.0, 0);
        Horse horse2 = new Horse("Стрелка", 3.0, 0);
        Horse horse3 = new Horse("Безымянная", 3.0, 0);

        hippodrome.getHorses().add(horse1);
        hippodrome.getHorses().add(horse2);
        hippodrome.getHorses().add(horse3);

        hippodrome.run();
        hippodrome.printWinner();

    }


}
