package models;

import java.util.Random;

public class Quest {

    public static StringBuilder getQuest(){
        Random random = new Random();

        int questSelector = random.nextInt(6) + 1;

        StringBuilder q1 = new StringBuilder();
        q1.append("Old lady Greta needs help, a groups of kobolds are raiding her cellar.");

        StringBuilder q2 = new StringBuilder();
        q2.append("A hord of kobolds just stole from Mr.Perkins.");

        StringBuilder q3 = new StringBuilder();
        q3.append("Your have reason to believe that there's and acolyte of baahl terrorizing WaterDeep.");

        StringBuilder q4 = new StringBuilder();
        q4.append("An Acolyte of Myrkul has been disturbing the local crematory. ");

        StringBuilder q5 = new StringBuilder();
        q5.append("You hear legends of a mysterious house of wonderful tresours.");

        switch (questSelector){
            case 1:
                return q1;
            case 2:
                return q2;
            case 3:
                return q3;
            case 4:
                return q4;
            case 5:
                return q3;
        }

        return null;
    }

}
