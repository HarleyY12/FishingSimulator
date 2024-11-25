import java.util.List;
import java.util.Random;

//FishSimulator class handles most of the logic for the game
public class FishSimulator {
    private List<Fish> fishList;  //List of available fish
    private int numFishCaught = 0;  //Number of fish caught
    private int score = 0;  //Player's score
    private int numFishingAttempts = 0; //Number of fishing attempts
    private long timeLimit;  //Time limit for catching fish in milliseconds
    private long startTime;  //Time when current fishing attempt starts
    private long passedTime;  //Time passed during current attempt
    private boolean fishFound = false;  //Displays whether a fish has been found
    private String fishingCues;  //Random string a user has to enter to catch fish
    private final String[] cues = {"hook","catch","ocean","fish","aquatic",
            "expedition","water","river","coding","apple","cactus",
            "blizzard"};  //List of possible strings a user enters to catch fish

    //Constructor to initialize the simulator with a list of fish and a time limit
    public FishSimulator(List<Fish> fishList, long timeInMilliseconds) {
        this.fishList = fishList;
        timeLimit = timeInMilliseconds;
    }

    //Getter methods for score,number of fish caught,number of fishing attempts,and current fishing cue
    public int getScore() {
        return score;
    }
    public int getNumFishCaught() {
        return numFishCaught;
    }
    public int getNumFishingAttempts(){
        return numFishingAttempts;
    }
    public String getFishingCues(){
        return fishingCues;
    }
    
    // Starts the fishing session and informs the player of the time limit to catch fish
    public String startFishing() {
        return "You have " + (timeLimit / 1000) + " seconds to fish each fish!";
    }

    // Simulates casting the fishing line to find a fish.A random fish is generated if a fish is found
    public String castLine() {
        if (Math.random() > 0.25 && numFishingAttempts < 21) {
            fishFound = true;
            startTime = System.currentTimeMillis();
            numFishingAttempts = numFishingAttempts + 1;
            fishingCues = cues[new Random().nextInt(cues.length)];
            return "A fish has been found!";
        } else {
            fishFound = false;
            numFishingAttempts = numFishingAttempts + 1;
            return "No fish has been found.";
        }
    }

    // Handles the logic for catching a fish based on user input
    public String catchFish(String userInput) {
        passedTime = System.currentTimeMillis() - startTime;
        if (passedTime > timeLimit){
            score = score - 2;
            return "You missed the fish.Time is up.Your score is now " + getScore();
        }
        if (!fishFound) {
            return "No fish found.";
        }
        if (userInput.equals(String.valueOf(fishingCues)) && passedTime <= timeLimit) {
            Fish caughtFish = fishList.get(new Random().nextInt(fishList.size()));
            numFishCaught = numFishCaught + 1;
            score = score + caughtFish.getPoints();
            return "You caught a " + caughtFish.getName() + " weighing " + caughtFish.getWeight() + " lbs, measuring "
                    + caughtFish.getLength() + " inches, worth " + caughtFish.getPoints() + " points. "
                    + "Total points: " + getScore() + " Total fish caught: " + getNumFishCaught()
                    + " Number of fishing attempts: " + getNumFishingAttempts();
        } else{
            score = score - 2;
            return "You have missed the fish. Try again next time.Your score is now " + getScore() + ".";
        }
    }

    // Determines if the game is over (either score threshold or max attempts reached)
    public boolean gameOver() {
        return score >= 40 || numFishingAttempts >= 20;
    }
}
