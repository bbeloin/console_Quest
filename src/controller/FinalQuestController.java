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


        while (usingProgram) {
            int menuItem = ui.displayMainMenu();

            switch (menuItem) {
                case 1:
//                    displayAllZombies();
                    break;
                case 2:
//                    int randomZombie = random.nextInt(10) + 1;
//
//                    for (int i = 0; i < randomZombie; i++) {
//                        zombieCalls();
//                    }
//
//                    for (int i = 0; i < randomZombie; i++) {
//                        displayAllZombies();
//                    }

                    break;
                case 3:
//                    int num = ui.numberOfZombies();

//                    for (int i = 0; i < num && num <= 2147483647; i++) {
////                        if (num <= 2147483647){
////
////                        }
////                        zombieCalls();
//                    }
//
//                    for (int i = 0; i < num; i++) {
////                        displayAllZombies();
//                    }

                    break;
                case 4:
                    usingProgram = false;
                    break;
            }
        }
    }

}
