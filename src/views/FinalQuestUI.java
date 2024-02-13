package views;

import java.util.Random;

public class FinalQuestUI {
    static Random random = new Random();

    public int displayMainMenu() {
        int selectedOption;

        do {
            Console.writeLn("Select a menu option: ", Console.TextColor.BLUE);

            Console.writeLn("""
                    1. Generate 1 zombie
                    2. Generate some zombies
                    3. Generate n zombies
                    4. Exit
                    """);

            selectedOption = Console.getIntInput("Your selection", Console.TextColor.CYAN);

            if (selectedOption < 1 || selectedOption > 4) {
                Console.writeLn("Invalid option, choose 1-4 only!", Console.TextColor.RED);
                selectedOption = -1; // invalid input, repeat
            }

        } while (selectedOption == -1);

        return selectedOption;

    }

}
