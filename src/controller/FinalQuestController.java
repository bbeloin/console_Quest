package controller;

import models.*;
import views.*;

import java.util.ArrayList;
import java.util.Random;

public class FinalQuestController {
    private static ArrayList<EnemyModel> enemys = new ArrayList<>();

    static FinalQuestUI ui = new FinalQuestUI();
    static Player player = new Player();
    static Enemy enemy = new Enemy();
    static Random random = new Random();

    public void run(){

        boolean usingProgram = true;

        createCharacter();

        while (usingProgram) {
            System.out.println(Quest.getQuest());

            int menuItem = ui.displayMainMenu();

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

            do {
                menuItem = ui.getActionChoice("\nWhat do you want to do? ", "Attack", "Run Away");

                switch (menuItem){
                    case 1:
                        attack();
                        break;
                    case 2:
                        runAway();
                        break;
                }

            }while (!usingProgram);

        }
    }

    private Player createCharacter(){
        String name = ui.getCharacterName();
        String sRace = ui.getRace();

//        PlayerRaces race = PlayerRaces.valueOf(sRace);
        PlayerRaces race = getEnumIgnoreCase(sRace);

        int hp = random.nextInt(10) + 1;
        int con = random.nextInt(10) + 1;
        int str = random.nextInt(10) + 1;
        int dex = random.nextInt(10) + 1;
        int ac = random.nextInt(10) + 1;

        Player player = new Player(name, race, hp, con, str, dex, ac);

        return player;

    }

    private static PlayerRaces getEnumIgnoreCase(String value) {
        for (PlayerRaces race : PlayerRaces.values()) {
            if (race.name().equalsIgnoreCase(value)) {
                return race;
            }
        }
        return null;
    }

    private void acceptQuest(){}

    private void denyQuest(){}

    private void attack(){

    }

    private void runAway(){

        if (player.getDexterity() > random.nextInt(player.getDexterity() + 5 - enemy.getLvl()) + 1){
            enemy.setHp(0);
        }
    }

}
