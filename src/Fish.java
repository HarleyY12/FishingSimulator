public class Fish {
    private final String name;
    private final double weight;
    private final double length;

    public Fish (String name , double weight, double length){
        this.name = name;
        this.weight = weight;
        this.length = length;
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
}
