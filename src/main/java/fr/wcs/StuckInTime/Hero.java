package fr.wcs.StuckInTime;

public class Hero {
    private String name;
    private String hero;
    private int nameIndex;
    private int arme;
    private int attack;
    private int score;
    private String[] heroes = {"JCVD", "Bob l'éponge", "MacroJoke", "The Mask", "Nicky Larson", "Shrek"};

    public Hero() {
        this.score = 0;
    }

    public void setName(int name) {
        this.name = heroes[name];
    }

    public String getName() {
        return this.name;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getHero() {
        return hero;
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

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return this.score;
    }
}
