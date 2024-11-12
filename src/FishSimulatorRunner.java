import java.util.Scanner;
import java.util.Timer;

public class FishSimulatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome to fishing simulator.");
        System.out.println("You will have a time limit to press a key to 'fish'.");
        System.out.println("You need 100 points to win.");
        Fish fish1 = new Fish("fish",76,2);
        System.out.println(fish1.getLength());


    }
}