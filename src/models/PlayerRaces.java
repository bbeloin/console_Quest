package models;

public enum PlayerRaces {
    HUMAN("human"),
    ELF("elf"),
    HALF_ELF("half-Elf"),
    HALF_ORC("half-Orc"),
    HALFLING("halfling"),
    DWARF("dwarf"),
    GNOME("gnome"),
    TIEFLING("tiefling"),
    GITHYANKI("githyanki"),
    DRAGONBORN("dragonborn");

    private final String friendlyName;

    PlayerRaces(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }

}
