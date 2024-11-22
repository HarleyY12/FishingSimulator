
//Fish Class represents a fish with different properties
public class Fish {
    private final String name;   //Name of fish
    private final double weight;  //Weight of fish in pounds
    private final double length;  //Length of fish in inches
    private final int points;  //Number of points a fish is worth

    //Constructor to initialize fish object
    public Fish (String name , double weight, double length, int points){
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.points = points;
    }
    //Get methods to access separate fish properties
    public String getName(){
        return name;
    }
    public double getWeight(){
        return weight;
    }
    public double getLength(){
        return length;
    }
    public int getPoints(){
        return points;
    }
}
