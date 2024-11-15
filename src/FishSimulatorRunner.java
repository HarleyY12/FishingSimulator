
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
        System.out.println("You will have a time limit to press 'e' to 'fish'.");
        System.out.println("You need 100 points to win.");
        System.out.println();
        


    }



}
