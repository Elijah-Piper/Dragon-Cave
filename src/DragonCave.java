import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class DragonCave {
    public static void main(String[] args) {

        // Determination of which cave will contain the hungry dragon and which cave will contain the friendly dragon.
        // Gives a random integer in range 1 to (non-inclusive) 3 (meaning options are either 1 or 2.
        int hungryCave = ThreadLocalRandom.current().nextInt(1, 3);

        // The dialogue strings are the console printouts for the game story and player guidance.
        String dialogueInitial =
                "You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n";
        String dialogueHungry =
                "\nYou approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                "Gobbles you down in one bite!";
        String dialogeFriendly =
                "\nYou approach the cave...\n" +
                "The sun peers through a skylight...\n" +
                "You see a large dragon sleeping,\n" +
                "having gorged himself the local shepherd's goats!\n" +
                "Your eyes catch a pile of treasure in the opposite corner...\n" +
                "You collect all you can carry and escape without disturbing the beast!";

        // Scanner for console detected user input
        Scanner scan = new Scanner(System.in);

        System.out.println(dialogueInitial);

        int choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            choice = scan.nextInt();
        }

        // Player choice determination based on the random integer created in hungryCave variable
        //
        if (choice == hungryCave) {
            System.out.println(dialogueHungry);
        } else {
            System.out.println(dialogeFriendly);
        }
    }
}