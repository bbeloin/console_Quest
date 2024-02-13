package views;

import java.util.Random;

public class FinalQuestUI {
    static Random random = new Random();

    public int displayMainMenu() {
        int selectedOption;

        do {
            Console.writeLn("Select a menu option: ", Console.TextColor.BLUE);

            Console.writeLn("""
                    1. Accept Quest
                    2. Decline Quest
                    3. Exit
                    """);

            selectedOption = Console.getIntInput("Your selection: ", Console.TextColor.CYAN);

            if (selectedOption < 1 || selectedOption > 4) {
                Console.writeLn("Invalid option, choose 1-4 only!", Console.TextColor.RED);
                selectedOption = -1; // invalid input, repeat
            }

        } while (selectedOption == -1);

        return selectedOption;

    }

    public int getActionChoice(String question, String choice1, String choice2){
        boolean keepGoing = true;
        int choice;

        do {
            Console.writeLn(question + "\n" + "1. " + choice1 + "\n" + "2. " + choice2);

            choice = Console.getIntInput("Your choice: ", Console.TextColor.BLUE);

            if (choice == 1 || choice == 2){
                keepGoing = false;
            }else {
                System.out.println("invailid choice");
            }
        }while (keepGoing);

        return choice;
    }

    public String getCharacterName(){
        return Console.getStringInput("Sire what's tho name? ");
    }

    public String getRace(){
        return Console.getStringInput("Sire what's tho Race? ");
    }

}
