
import java.util.List;
import java.util.Random;
public class FishSimulator {
    private List<Fish> fishList;
    private int numFishCaught = 0;
    private int score = 0;
    private int numFishingAttempts = 0;
    private long timeInMilliseconds;
    boolean fishFound = false;

    public FishSimulator(List<Fish> fishList, long timeInMilliseconds) {
        this.fishList = fishList;
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public int getScore() {
        return score;
    }

    public int getNumFishCaught() {
        return numFishCaught;
    }

    public String startFishing() {
        return "You have " + (timeInMilliseconds / 1000) + " seconds to get ready to fish !";
    }

    public String castLine() {

        if (System.currentTimeMillis() > timeInMilliseconds) {
            return "Get ready!";
        }
        if (Math.random() > 0.9 && numFishingAttempts < 21) {
            Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
            fishFound = true;
            return "A " + caughtFish.getName() + " has been found! Press e to fish it.";
        } else {
            fishFound = false;
            return "no fish have been found";
        }
    }

        public String catchFish() {
            while (numFishingAttempts != 21) {

                Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
                numFishCaught = numFishCaught + 1;
                numFishingAttempts = numFishingAttempts + 1;
                score = score + caughtFish.getPoints();
                return "you have caught a " + caughtFish.getName() + " with " + caughtFish.getWeight() + " lbs " + caughtFish.getLength() + " in";
                }
                return "you have fished the max amount of times";
            }
        }



