package fr.epita.assistants.creatureInterface;

public abstract class BaseHuman extends Creature implements SpeakableInterface, SwimmingInterface{
    private boolean swimmingState;

    public BaseHuman(String name){
        super(name);
        this.swimmingState=false;
    }

    @Override
    public void swim(){
        swimmingState=true;
        System.out.println("I'm a "+ this.getClass().getSimpleName()+" and I'm swimming.");

    }
    public boolean getSwimmingState(){
        return swimmingState;
    }

    @Override
    public void emerge(){
        swimmingState=false;
    }

    @Override
    public void hello(){
        System.out.println("Hello, my name is "+name+" and I'm a "+this.getClass().getSimpleName()+".");
    }
}