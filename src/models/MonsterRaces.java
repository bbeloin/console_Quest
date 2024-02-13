package models;

public enum MonsterRaces{
    KOBOLD("Kobold"),
    MIMIC("Mimic"),
    ACOLYTE("Acolyte");


    private final String friendlyName;

    MonsterRaces(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }
}
