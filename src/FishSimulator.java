
import java.util.List;
import java.util.Random;
public class FishSimulator {
    private List<Fish> fishList;
    private int numFishCaught;
    private int numfishCaught;
    private int score;
    private long timeInMilliseconds;

    public FishSimulator( List<Fish>fishList,long timeInMilliseconds){
        this.fishList = fishList;
        this.numFishCaught = 0;
        this.score = 0;
        this.timeInMilliseconds = timeInMilliseconds;
    }
    public int getScore() {
        return score;
    }
    public int getNumFishCaught() {
        return numFishCaught;
    }
    public String startFishing(){
        return "You have " + (timeInMilliseconds/1000) + " seconds to fish !";
    }
    public String castLine() {
        long startTime = System.currentTimeMillis();
        if (System.currentTimeMillis() - startTime > timeInMilliseconds) {
            return "Get ready!";
        }
        if (Math.random() > 0.5 && numfishCaught < 50) {
            Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
            return "A" + caughtFish.getName() + " has been found! Press e to fish it.";
        }
        return "no fish have been found";
    }



    }
