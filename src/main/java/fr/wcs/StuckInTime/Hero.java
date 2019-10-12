package fr.wcs.StuckInTime;

public class Hero {
    private String name;
    private String arme;
    private String attack;

    public Hero(String name, String arme, String attack ) {
        this.name = name;
        this.arme = arme;
        this.attack = attack;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setArme(String arme) {
        this.arme = arme;
    }
    public String getArme() {
        return this.arme;
    }
    public void setAttack(String attack) {
        this.attack = attack;
    }
    public String getAttack() {
        return this.attack;
    }


}
