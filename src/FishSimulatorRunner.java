import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class FishSimulatorRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<String>fishList = new ArrayList<>();
        Fish fish1 = new Fish("goldfish",0.1,0.05);
        Fish fish2 = new Fish("catfish",90,5);
        Fish fish3 = new Fish("salmon",20,4);
        System.out.println("Welcome to fishing simulator.");
        System.out.println("You will have a time limit to press 'e' to 'fish'.");
        System.out.println("You need 100 points to win.");
        System.out.println();
        String enteredKey;
        enteredKey = s.next();
        if (enteredKey.toLowerCase() == "e"){
            System.out.println("you caught the fish!");
        }


    }



}