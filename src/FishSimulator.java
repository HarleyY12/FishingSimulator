

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
    private char fishingCommand;
    private final char[] commands = {'e','a','m','p','z','t'};

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
    public int getNumFishingAttempts(){
        return numFishingAttempts;
    }
    public char getFishingCommand(){
        return fishingCommand;
    }
    public String startFishing() {
        return "You have " + (timeLimit / 1000) + " seconds to get ready to fish !";
    }
    public String castLine() {
        passedTime = System.currentTimeMillis() - startTime;
        if (Math.random() > 0.3 && numFishingAttempts < 21) {
            fishFound = true;
            startTime = System.currentTimeMillis();
            numFishingAttempts = numFishingAttempts + 1;
            fishingCommand = commands[new Random().nextInt(commands.length)];
            return "A fish has been found! Press " + fishingCommand + " to fish it.";
        } else {
            fishFound = false;
            numFishingAttempts = numFishingAttempts + 1;
            return "No fish has been found.";
        }
    }
    public String catchFish(String userInput) {
        passedTime = System.currentTimeMillis() - startTime;
        if (passedTime > timeLimit){
            return "You missed the fish.Time is up.";
        }
        if (!fishFound) {
            return "No fish found.";
        }
        if (userInput.equals(String.valueOf(fishingCommand)) && passedTime <= timeLimit) {
            Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
            numFishCaught = numFishCaught + 1;
            score = score + caughtFish.getPoints();
            return "You have caught a " + caughtFish.getName() + " with " + caughtFish.getWeight() + " lbs, "
                    + caughtFish.getLength() + " inches. You earned " + caughtFish.getPoints() + " points. "
                    + "Total points: " + getScore() + " Total fish caught: " + getNumFishCaught() ;
        } else{
            score = score - 2;
            return "You have missed the fish. Try again next time.Your score is now " + getScore();
        }
    }
    public boolean gameOver() {
        return score >= 50 || numFishingAttempts >= 20;
    }
}
