package controller;

import models.*;
import views.*;

import java.util.ArrayList;
import java.util.Random;

import models.Quest.*;

import static models.Quest.*;

public class FinalQuestController {
    private int currentPlayer = 0;
    private static ArrayList<EnemyModel> enemy = new ArrayList<>();
    private static FinalQuestUI ui = new FinalQuestUI();
    private static Random random = new Random();
    private Player tempPlayer = new Player();
    public Player player;

    public void run(){

        boolean usingProgram = true;

        if (tempPlayer.getInstanceCount() == 1){
            this.player = createCharacter();
            StringBuilder a = getQuest();
            System.out.println(a);
            addEnemies();
            Player.instanceCount++;
        }

        while (usingProgram) {

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

    private void acceptQuest() {

        String question = "What do you do? ";
        String q1Attack = " Attack: ";
        String q2RunAway = " Run Away: ";

        ui.displayFighters(this.player, enemy.getFirst());

        int choice = ui.getActionChoice(question, q1Attack, q2RunAway);

        if (enemy.isEmpty()){
            addEnemies();
        }

        switch (choice){
            case 1:
                attack();
                break;
            case 2:
                runAway();
                break;
        }
    }

    private Player createCharacter() {

        String name = ui.getCharacterName();

        System.out.println("What is your race: ");
        getPlayerRace();

        String sRace = ui.getRace();
        PlayerRaces races = getEnumIgnoreCase(sRace);

        int hp = (random.nextInt(10) + 8) + Player.calculateConModifier();
        int con = random.nextInt(10) + 8;
        int str = random.nextInt(10) + 8;
        int dex = random.nextInt(10) + 8;
        int ac = random.nextInt(10) + 8;

        Player player = new Player(name, races, hp, con, str, dex, ac);

        return player;
    }

    public static PlayerRaces getEnumIgnoreCase(String value) {
        for (PlayerRaces races : PlayerRaces.values()) {
            System.out.println(races);
            if (races.name().equalsIgnoreCase(value)) {
                return races;
            }
        }
        return null;
    }

    private void getPlayerRace(){
        for (PlayerRaces race : PlayerRaces.values()){
            System.out.println(race);
        }
    }

    private void denyQuest() {
        System.out.println(getQuest());
        run();
    }

    private void attack(){
        for (EnemyModel i : enemy){
            if (playerTurn()){
                enemy.getFirst().setHp(i.getHp() - this.player.attack(Die.d20(1)));
                detectTurn();
            }else {
                this.player.setHp(this.player.getHp() - i.attack(Die.d20(1)));
                detectTurn();
            }
        }
    }

    private void runAway(){
        for (EnemyModel i : enemy){
            if (playerTurn() && player.getSpeed() > i.getSpeed()){
                i.setAlive(false);
                System.out.printf("You ran away from %s", i.getMonsterRaces());
            }

        }
    }

    private static void addEnemies(){
        switch (questSelector){
            case 1:
            case 2:
                Kobold kobold = new Kobold();
                enemy.add(kobold);
                break;
            case 3:
            case 4:
                Acolyte acolyte = new Acolyte();
                enemy.add(acolyte);
                break;
            case 5:
                Mimic mimic = new Mimic();
                enemy.add(mimic);
                break;

        }
    }

    private boolean detectTurn(){
        boolean isPlayerTurn = true;

        if (currentPlayer == 0 && isPlayerTurn) {
            currentPlayer++;
        } else if (currentPlayer == 1) {
            currentPlayer = 0;
        }

        return isPlayerTurn;

    }

    private boolean playerTurn() {

        if (this.player.isAlive()) {
            return true;
        }
        detectTurn();
        return false;
    }

    private boolean enemyTurn() {

        if (detectTurn()) {
            return true;
        }

        return false;
    }

    private String checkForWin(Player player) {
        String message = null;

        if (player.isAlive() && (!enemy.getFirst().isAlive())) {
            System.out.println("You slew the beast");
            player.setNeededXP(enemy.getFirst().enemyDied());
            System.out.println(getQuest());
        } else {
            System.out.println("YOU DIED");;
        }
        return message;
    }
}
