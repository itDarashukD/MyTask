package HorsesRunning;


public class Horse {


    String point = ".";
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public   double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }



    public void move() {
        distance += getSpeed() * (Math.random() * 1);

    }

    public String summuryString(int i, String point) {
        String result = "";
        for (int u = 0; u < i; u++) {
            result = result + point;
        }
        return result;
    }

    public void print() {

        System.out.println(summuryString((int) Math.floor(distance), point) + this.getName());

    }

    ;

}
