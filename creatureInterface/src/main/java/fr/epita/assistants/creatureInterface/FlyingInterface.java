package fr.epita.assistants.creatureInterface;

/**
 * This interface provides methods for flying.
 * Creatures that fly implement this interface.
 */
public interface FlyingInterface {
    /**
     * Prints "I'm a {CreatureClassName} and I'm flying."
     */
    default void fly(){
        System.out.println("I'm a "+this.getClass().getSimpleName()+ " and I'm flying.");
    };
}
