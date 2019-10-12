package fr.wcs.StuckInTime;

public class Hero {
    private String name;
    private int nameIndex;
    private int arme;
    private int attack;
    private String[] heroes = {"JCVD", "Bob l'éponge", "MacroJoke"};

    public Hero(int name, int arme, int attack ) {
        this.name = heroes[name];
        this.nameIndex = name;
        this.arme = arme;
        this.attack = attack;
    }

    public void setName(int name) {
        this.name = heroes[name];
    }
    public String getName() {
        return this.name;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setArme(int arme) {
        this.arme = arme;
    }
    public int getArme() {
        return this.arme;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getAttack() {
        return this.attack;
    }


}
