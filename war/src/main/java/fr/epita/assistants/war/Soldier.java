package fr.epita.assistants.war;

public class Soldier extends Combatant {
    protected int healthPoints;
    protected int damagePoints;
    protected String scream;

    public Soldier(){
        this.healthPoints=15;
        this.damagePoints=3;
        this.scream="No pity for losers!";
    }
    public  void kill(){
        this.healthPoints=0;
    }
    public void printState(){
        System.out.println("I have "+ healthPoints+" health points.");
    }
    public void attack(Soldier s){
        s.healthPoints -= this.damagePoints;
    }
    public void attack(Vehicle v){
        System.out.println("I can't fight this.");
    }
    public void scream(){
        System.out.println(scream);
    }

}