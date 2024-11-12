public class Fish {
    private final String name;
    private final int weight;
    private final int length;

    public Fish (String name , int weight, int length){
        this.name = name;
        this.weight = weight;
        this.length = length;
    }
    public String getName(){
      return name;
    }
    public int getWeight(){
        return weight;
    }
    public int getLength(){
        return length;
    }
}
