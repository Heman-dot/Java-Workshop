package fr.epita.assistants.creatureInterface;

/**
 * This interface provides methods for swimming.
 * Creatures that swim implement this interface.
 */
public interface SwimmingInterface {
    /**
     * Prints "I'm a {CreatureClassName} and I'm swimming."
     */
    void swim();

    /**
     * Returns true if the creature is swimming.
     * It is up to the implementing class to determine the conditions for swimming.
     *
     * @return True if the creature is swimming
     */
    boolean getSwimmingState();

    /**
     * Emerges from the water.
     */
    void emerge();
}
