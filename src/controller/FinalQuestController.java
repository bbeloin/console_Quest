package controller;

import models.*;
import views.*;

import java.util.ArrayList;
import java.util.Random;

public class FinalQuestController {
    private static ArrayList<EnemyModel> enemys = new ArrayList<>();

    static FinalQuestUI ui = new FinalQuestUI();
    static Random random = new Random();

    public void run(){

        boolean usingProgram = true;
        Enemy enemy = new Enemy();

        createCharacter();

        while (usingProgram) {
            int menuItem = ui.displayMainMenu();

            if (!enemy.isAlive()){
                System.out.println(Quest.getQuest());
            }

            switch (menuItem) {
                case 1:
                    acceptQuest();
                    break;
                case 2:
                    denyQuest();
                    break;
                case 3:
                    usingProgram = false;
                    break;

            }

            String question = "What do you do? ";
            String q1Attack = " 1. Attack: ";
            String q2RunAway = " 2. Run Away ";

            int choice = ui.getActionChoice(question, q1Attack, q2RunAway);

            switch (choice){
                case 1:
                    attack();
                    break;
                case 2:
                    runAway();
                    break;
            }

        }

    }

    private Player createCharacter() {

        String name = ui.getCharacterName();

        String sRace = ui.getRace();
        PlayerRaces races = getEnumIgnoreCase(sRace);

        int hp = random.nextInt(10) + 1;
        int con = random.nextInt(10) + 1;
        int str = random.nextInt(10) + 1;
        int dex = random.nextInt(10) + 1;
        int ac = random.nextInt(10) + 1;

        Player player = new Player(name, races, hp, con, str, dex, ac);

        return player;
    }

    public static PlayerRaces getEnumIgnoreCase(String value) {
        for (PlayerRaces races : PlayerRaces.values()) {
            if (races.name().equalsIgnoreCase(value)) {
                return races;
            }
        }
        return null;
    }

    private void denyQuest() {}

    private void acceptQuest() {}

    private void attack(){}

    private void runAway(){}


}
