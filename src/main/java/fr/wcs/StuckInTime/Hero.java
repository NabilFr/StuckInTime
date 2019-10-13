package fr.wcs.StuckInTime;

public class Hero {
    private String name;
    private String hero;
    private int heroIndex;
    private int arme;
    private int attack;
    private int score;
    private String[] heroes = {"JCVD", "Bob l'éponge", "MacroJoke", "The Mask", "Nicky Larson", "Shrek"};

    public Hero() {
        this.score = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHero(int hero) {
        this.hero = heroes[hero];
    }

    public String getHero() {
        return hero;
    }

    public void setHeroIndex(int heroIndex) {
        this.heroIndex = heroIndex;
    }

    public int getHeroIndexIndex() {
        return heroIndex;
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
