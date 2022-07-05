import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class DragonCave {

    private static int randomIntOneOrTwo() {
        // Returns random integer, either 1 or 2
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    public static void main(String[] args) {

        // Determination of which cave will contain the hungry dragon and which cave will contain the friendly dragon.
        int hungryCave = randomIntOneOrTwo();

        // The dialogue strings are the console printouts for the game story and player guidance.
        final Map<String, String> dialogues = Map.ofEntries(
                Map.entry("initial", """
                You are in a land full of dragons. In front of you,
                you see two caves. In one cave, the dragon is friendly
                and will share his treasure with you. The other dragon
                is greedy and hungry and will eat you on sight.
                Which cave will you go into? (1 or 2)\n
                """),
                Map.entry("hungry", """
                \nYou approach the cave...
                It is dark and spooky...
                A large dragon jumps out in front of you! He opens his jaws and...
                Gobbles you down in one bite!
                """),
                Map.entry("friendly", """
                \nYou approach the cave...
                The sun peers through a skylight...
                You see a large dragon sleeping,
                having gorged himself the local shepherd's goats!
                Your eyes catch a pile of treasure in the opposite corner...
                You collect all you can carry and escape without disturbing the beast!
                """)
        );

        // Scanner for console detected user input
        Scanner scan = new Scanner(System.in);

        System.out.println(dialogues.get("initial"));

        int choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Please choose 1 or 2.");
            choice = scan.nextInt();
        }

        // Player choice determination based on the random integer created in hungryCave variable
        if (choice == hungryCave) {
            System.out.println(dialogues.get("hungry"));
        } else {
            System.out.println(dialogues.get("friendly"));
        }
    }
}
