package fr.epita.assistants.war;

public class Vehicle extends Combatant{
    private String modelName;
    private int defencePoints;

    public Vehicle(String modelName , int defencePoints){
        this.modelName=modelName;
        this.defencePoints=defencePoints;
    }
    public void printState(){
        System.out.println("I have "+defencePoints+" defense points.");

    }
    public void attack(Soldier s){
        s.kill();
    }
    public void attack(Vehicle v){
        v.defencePoints /=2;
    }
    public void scream(){
        System.out.println("I'm " + modelName+"!");
    }
}