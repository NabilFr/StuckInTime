package fr.wcs.StuckInTime;

public class Hero {
    private String name;
    private String hero;
    private int heroIndex;
    private int lives;
    private int[] heroState;
    private int arme;
    private int attack;
    private int score;

    private String[] heroes = {"JCVD", "Bob l'éponge", "MacroJoke", "The Mask", "Nicky Larson", "Shreïk"};
    private String[][] attacks = {{"Coup de pied retourné", "Réfléchir", "Lancer dans la tronche", "Gagner le combat", "Super mouvements stylés", "Un discours"},
            {"", ""},
            {"", ""},
            {"Attaque de lumière", "Frapper le monstre", "Lancer", "Viser l'orteil", "Foncer dans le tas", "Pose héroïque"},
            {"", ""},
            {"", ""}};

    public Hero() {
        this.name = "Mushu";
        this.hero = "personne";
        this.score = 0;
        this.lives = 9;
        this.heroState = new int[] {0, 0, 0, 0, 0, 0};
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setHero() {
        this.hero = heroes[heroIndex];
    }

    public String getHero() {
        return hero;
    }

    public void setHeroIndex(int heroIndex) {
        this.heroIndex = heroIndex;
        this.setHero();
    }

    public int getHeroIndex() {
        return heroIndex;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }

    public void setHeroState(int heroState) {
        this.heroState[this.heroIndex] = heroState;
    }

    public int getHeroState(int index) {
        return this.heroState[index];
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

    public String getAttack(int indice) {
        return attacks[heroIndex][indice];
    }
}
