import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Player");
        System.out.println(new Player());
        System.out.println(new Player("Sir Leroy", PlayerRaces.HALF_ELF, 50, 18, 20, 11, 15) + "\n");

        System.out.println("Enemy's");
        System.out.println(new Kobold());
        System.out.println(new Mimic());
        System.out.println(new Acolyte());
    }
}