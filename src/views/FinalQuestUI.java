package views;

import models.EnemyModel;
import models.Player;

public class FinalQuestUI {

    public int displayMainMenu() {
        int selectedOption;

        do {

            Console.writeLn("""
                    1. Accept the Quest
                    2. Decline the Quest
                    """);

            selectedOption = Console.getIntInput("Your selection: ", Console.TextColor.CYAN);

            if (selectedOption < 1 || selectedOption > 3) {
                Console.writeLn("Invalid option, choose 1-3 only!", Console.TextColor.RED);
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
                System.out.println("invalid choice");
            }
        }while (keepGoing);

        return choice;
    }

    public void displayFighters(Player player, EnemyModel enemy){
        Console.writeLn(player.toString());
        Console.writeLn(enemy.toString());
    }

    public void skipRunOut(){
        Console.writeLn("\nYou ran out of skips\n", Console.TextColor.RED);
    }

    public String getCharacterName(){
        return Console.getStringInput("Sire what's tho name? ");
    }

    public String getRace(){
        return Console.getStringInput("Sire what's tho Race? ");
    }

}
