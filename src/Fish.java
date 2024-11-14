public class Fish {
    private final String name;
    private final double weight;
    private final double length;
    private final int points;

    public Fish (String name , double weight, double length, int points){
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.points = points
    }
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
