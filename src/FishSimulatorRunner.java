
import java.util.Arrays;
import java.util.Scanner;


public class FishSimulatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Fish fish1 = new Fish("goldfish",0.1,0.5,1);
        Fish fish2 = new Fish("bass",30,60,5);
        Fish fish3 = new Fish("salmon",50,80,8);
        FishSimulator simulator = new FishSimulator(Arrays.asList(fish1,fish2,fish3),5000);

        System.out.println("Welcome to fishing simulator.");
        System.out.println("You will have a time limit for each fishing attempt.");
        System.out.println("You need 50 points to win.You will have a maximum of 20 fishing attempts.");
        System.out.println(simulator.startFishing());


        while (!simulator.gameOver()){
            String castResults = simulator.castLine();
            System.out.println(castResults);
            if (!castResults.contains("No fish")){
                System.out.println("Press e to fish");
                String userInput = s.next();
                String catchResults = simulator.catchFish(userInput);
                System.out.println(catchResults);
            }else{
                System.out.println();

            }
        }
        

        if (simulator.getScore() >= 50 && simulator.getNumFishCaught() < 20){
            System.out.println("You win!");
        }else if ( simulator.getScore()<50 || simulator.getNumFishCaught() > 20){
            System.out.println("You lost. Try again next time.");
        }


    }



}
