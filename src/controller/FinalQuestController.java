package controller;

import models.*;
import views.*;

import java.util.ArrayList;
import java.util.Random;

import static models.Quest.*;

public class FinalQuestController {
    private int currentPlayer = 0;
    private int skipCount = 0;
    private static ArrayList<EnemyModel> enemy = new ArrayList<>();
    private static FinalQuestUI ui = new FinalQuestUI();
    private static Random random = new Random();
    private Player tempPlayer = new Player();
    private Quest quest = new Quest();
    public Player player;

    public void run(){

        boolean usingProgram = true;

        if (tempPlayer.getInstanceCount() == 1){
            this.player = createCharacter();
            System.out.println(this.quest.getQuest());
            addEnemies();
            Player.instanceCount++;
        }

        while (usingProgram) {

            if (enemy.isEmpty()){
                Quest quest1 = new Quest();
                System.out.println(quest1.getQuest());
                addEnemies();
            }

            int menuItem = ui.displayMainMenu();

                switch (menuItem) {
                    case 1:
                        acceptQuest();
                        break;
                    case 2:
                        if (this.skipCount == 0){
                            this.skipCount++;
                            denyQuest();
                        }else {
                            ui.skipRunOut();
                        }
                        break;
            }

        }

    }

    private void acceptQuest() {

        String question = "do you? ";
        String q1Attack = " Attack: ";
        String q2RunAway = " Run Away: ";

        ui.displayFighters(this.player, enemy.getFirst());

        if (currentPlayer == 0){
            System.out.printf("\n%s's Turn\n\n", this.player.getName());
        }

        int choice = ui.getActionChoice(question, q1Attack, q2RunAway);

        if (enemy.isEmpty()){
            addEnemies();
        }

        switch (choice){
            case 1:
                attack();
                break;
            case 2:
                if (this.skipCount == 0){
                    this.skipCount++;
                    runAway();
                }else {
                    ui.skipRunOut();
                }
                break;
        }
    }

    private Player createCharacter() {

        String name = ui.getCharacterName();

        System.out.println("What is your race: ");
        getPlayerRace();

        String sRace;
        PlayerRaces races;

        do {
            sRace = ui.getRace();
            races = getEnumIgnoreCase(sRace);
        }while (races == null);

        int hp = (random.nextInt(10) + 8) + Player.calculateConModifier();
        int con = random.nextInt(10) + 8;
        int str = random.nextInt(10) + 8;
        int dex = random.nextInt(10) + 8;
        int speed = Player.setSpeed(35);
        int ac = random.nextInt(10) + 8;

        Player player = new Player(name, races, hp, con, str, dex, speed, ac);

        return player;
    }

    public static PlayerRaces getEnumIgnoreCase(String value) {
        try {
            for (PlayerRaces races : PlayerRaces.values()) {
                if (races.name().equalsIgnoreCase(value)) {
                    return races;
                }
            }
            throw new IllegalArgumentException("Enter a valid race");
        }catch (IllegalArgumentException e){
            String message = e.getMessage();
            System.out.println("IllegalArgumentException message: " + message);
        }

        return null;
    }

    private void getPlayerRace(){
        for (PlayerRaces race : PlayerRaces.values()){
            System.out.println(race);
        }
    }

    private void denyQuest() {
        if ( !enemy.isEmpty()){
            for (EnemyModel i : enemy){
                enemy.remove(i);
                break;
            }
        }

        run();
    }

    private void attack(){

        for (EnemyModel i : enemy){
            if (playerTurn()){
                int playerDieRoll = Die.d20(1);
                i.setHp(i.getHp() - this.player.attack(playerDieRoll, i));
                System.out.printf("\nYour roll was a: %s \n", playerDieRoll);
                System.out.printf("Which was a: %s \n", player.attackType(playerDieRoll));
            }else {
                int enemyDieRoll = Die.d20(1);
                this.player.setHp(this.player.getHp() - i.attack(enemyDieRoll, player));
                System.out.printf("\nThe Enemies roll was a: %s \n", enemyDieRoll);
                System.out.printf("Which was a: %s \n\n", i.attackType(enemyDieRoll));
            }

            if (player.getHp() > 0 && currentPlayer == 0){
                acceptQuest();
            }else if (i.getHp() > 0 && currentPlayer == 1){
                attack();
            }
            else {
                checkForWin();
                run();
            }
        }
    }

    private void runAway(){
        for (EnemyModel i : enemy){
            if (currentPlayer == 0 && player.getSpeed() > i.getSpeed()){
                i.setHp(0);
                enemy.remove(i);
                System.out.printf("You ran away from %s\n", i.getMonsterRaces());
//                System.out.println(getQuest());
                addEnemies();
                run();
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

        if (currentPlayer == 0) {
            currentPlayer++;
            isPlayerTurn = true;
        } else if (currentPlayer == 1) {
            currentPlayer = 0;
            isPlayerTurn = false;
        }

        return isPlayerTurn;

    }

    private boolean playerTurn() {

        if (this.player.isAlive() && detectTurn()) {
            return true;
        }
        return false;
    }

    private void checkForWin() {

        for (EnemyModel i : enemy) {
            if (player.isAlive() && (!i.isAlive())) {
                System.out.printf("You slew the %s \n", i.getMonsterRaces());
                player.setNeededXP(i.enemyDied(player));
                enemy.remove(i);
                break;
//                System.out.println(getQuest());
            } else {
                System.out.println("YOU DIED");
                System.exit(0);
            }
        }
    }
}
