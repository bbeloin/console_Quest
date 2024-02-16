package controller;

import models.*;
import views.*;

import java.util.ArrayList;
import java.util.Random;

import static models.Quest.getQuest;

public class FinalQuestController {
    private static ArrayList<EnemyModel> enemys = new ArrayList<>();
    private static FinalQuestUI ui = new FinalQuestUI();
    private static Random random = new Random();
    private static Enemy enemy = new Enemy();

    private static Player player = new Player();

    public void run(){

        boolean usingProgram = true;
        StringBuilder a = getQuest();

        if (Player.getInstanceCount() == 1){
            createCharacter();
            System.out.println(a);
            Player.instanceCount++;
        }

        while (usingProgram) {

            //TODO: Might delete if statement later if not necessary.
//            if (!enemy.isAlive()) {
//                System.out.println(Quest.getQuest());
//            }

            int menuItem = ui.displayMainMenu();

            switch (menuItem) {
                case 1:
                    acceptQuest();
                    break;
                case 2:
                    denyQuest();
                    break;
            }

        }

    }

    private Player createCharacter() {

        String name = ui.getCharacterName();

        String sRace = ui.getRace();
        PlayerRaces races = getEnumIgnoreCase(sRace);

        int hp = (random.nextInt(10) + 8) + player.calculateConModifier();
        int con = random.nextInt(10) + 8;
        int str = random.nextInt(10) + 8;
        int dex = random.nextInt(10) + 8;
        int ac = random.nextInt(10) + 8;

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

    private void acceptQuest() {

        String question = "What do you do? ";
        String q1Attack = " Attack: ";
        String q2RunAway = " Run Away ";

        int choice = ui.getActionChoice(question, q1Attack, q2RunAway);

        switch (choice){
            case 1:
                attack();
                break;
            case 2:
                if (player.getSpeed() > enemy.getSpeed()){
                    runAway();
                }
                break;
        }
    }

    private void denyQuest() {
        System.out.println(getQuest());
        run();
    }

    private void attack(){}

    private void runAway(){
        for (EnemyModel i : enemys){
            i.setAlive(false);
            System.out.printf("You ran away from %s", i.getMonsterRaces());
        }
    }


}
