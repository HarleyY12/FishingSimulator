
import java.util.Arrays;
import java.util.Scanner;

//Runner class of the program
public class FishSimulatorRunner {
    public static void main(String[] args) {
        //Scanner for user input
        Scanner s = new Scanner(System.in);
        //Initialize fish objects
        Fish fish1 = new Fish("goldfish",0.1,0.5,1);
        Fish fish2 = new Fish("bass",30,60,3);
        Fish fish3 = new Fish("salmon",50,80,5);
        //Create new instance of FishSimulator
        FishSimulator simulator = new FishSimulator(Arrays.asList(fish1,fish2,fish3),3500);

        //Introduce user to program and how to begin
        System.out.println("Welcome to fishing simulator.");
        System.out.println("You will have a time limit for each fishing attempt.");
        System.out.println("You need 50 points to win.You will have a maximum of 20 fishing attempts.");
        System.out.println("Type 'start' to begin");
        String reply = "";
        while (!(reply.equalsIgnoreCase("start"))){
            System.out.println("Waiting to start.");
            reply = s.next();
        }

        //Start the fishing simulator
        System.out.println(simulator.startFishing());
        //Loop until game over
        while (!simulator.gameOver()){
            String castResults = simulator.castLine();
            System.out.println(castResults);
            if (!castResults.contains("No fish")){  //If a fish is found, ask user to enter command
                System.out.println("Enter '" + simulator.getFishingCommand() + "' to fish");
                String userInput = s.next();
                String catchResults = simulator.catchFish(userInput);
                System.out.println(catchResults);  //Print whether the fish was caught
            }else{
                System.out.println("Recasting line...");
            }
        }

        //Determine game outcome based on score and number of fishing attempts
        if (simulator.getScore() >= 40 && simulator.getNumFishingAttempts() <= 20){
            System.out.println("You win!");
        }else if (simulator.getScore() < 40  || simulator.getNumFishingAttempts() > 20) {
            System.out.println("You lost. Try again next time.");
        }
    }
}
