package models;

public enum PlayerRaces {
    HUMAN("Human"),
    ELF("Elf"),
    HALF_ELF("Half_Elf"),
    HALF_ORC("Half_Orc"),
    HALFLING("Halfling"),
    DWARF("Dwarf"),
    GNOME("Gnome"),
    TIEFLING("Tiefling"),
    GITHYANKI("Githyanki"),
    DRAGONBORN("Dragonborn");

    private final String friendlyName;

    PlayerRaces(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString() {
        return friendlyName;
    }

}
