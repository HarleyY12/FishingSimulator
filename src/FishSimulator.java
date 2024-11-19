
import java.util.List;
import java.util.Random;
public class FishSimulator {
    private List<Fish> fishList;
    private int numFishCaught = 0;
    private int score = 0;
    private int numFishingAttempts = 0;
    private long timeLimit;
    private long startTime;
    private long passedTime;
    private boolean fishFound = false;

    public FishSimulator(List<Fish> fishList, long timeInMilliseconds) {
        this.fishList = fishList;
        timeLimit = timeInMilliseconds;
    }

    public int getScore() {
        return score;
    }

    public int getNumFishCaught() {
        return numFishCaught;
    }

    public String startFishing() {
        startTime = System.currentTimeMillis();
        return "You have " + (timeLimit / 1000) + " seconds to get ready to fish !";
    }

    public String castLine() {
        passedTime = System.currentTimeMillis() - startTime;
       
        if (Math.random() > 0.5 && numFishingAttempts < 21) {
            fishFound = true;
            startTime = System.currentTimeMillis();
            return "A fish has been found! Press e to fish it.";
        } else {
            fishFound = false;
            return "No fish has been found.Recasting line...";
        }
    }
    public String catchFish(String userInput) {
        passedTime = System.currentTimeMillis() - startTime;
        if (passedTime > timeLimit){
            return "You missed the fish.Time is up.";
        }

        if (!fishFound) {
            return "No fish found. Recasting line...";
        }
        
        if (userInput.equals("e") && passedTime <= timeLimit) {

            Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
            numFishCaught = numFishCaught + 1;
            numFishingAttempts = numFishingAttempts + 1;
            score = score + caughtFish.getPoints();
            return "You have caught a " + caughtFish.getName() + " with " + caughtFish.getWeight() + " lbs, " + caughtFish.getLength() + " inches. You earned " + caughtFish.getPoints() + " points. " + "Total points: " + getScore() + " Total fish caught: " + getNumFishCaught() ;

        } else{
            return "You have missed the fish. Try again next time.";
        }
    }

    public boolean gameOver() {
        return score >= 50 || numFishingAttempts >= 20;
    }
}

