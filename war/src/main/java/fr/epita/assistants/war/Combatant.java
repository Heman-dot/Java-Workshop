package fr.epita.assistants.war;

public abstract class Combatant{
    void printState(){
        System.err.println("Error 404. Class not found.");
    };
    public abstract void attack(Soldier s);
    public abstract void attack(Vehicle v);
    public abstract void scream();
}
