package models;

import java.util.Random;

public class Quest {
    static Random random = new Random();
    public static int questSelector;

    StringBuilder q1 = new StringBuilder();
    StringBuilder q2 = new StringBuilder();
    StringBuilder q3 = new StringBuilder();
    StringBuilder q4 = new StringBuilder();
    StringBuilder q5 = new StringBuilder();

    public StringBuilder getQuest(){

        q1.append("Old lady Greta needs help, a groups of kobolds are raiding her cellar. \n");
        q1.append("Do you: ");

        q2.append("A hord of kobolds just stole from Mr.Perkins. \n");
        q2.append("Do you: ");

        q3.append("Your have reason to believe that there's and acolyte of baahl terrorizing WaterDeep. \n");
        q3.append("Do you: ");

        q4.append("An Acolyte of Myrkul has been disturbing the local crematory. \n");
        q4.append("Do you: ");


        q5.append("You hear legends of a mysterious house of wonderful tresours. \n");
        q5.append("Do you: ");

        return setQuest();
    }

    public StringBuilder setQuest(){
        questSelector = random.nextInt(5) + 1;

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
                return q5;
        }
        return null;
    }

}
