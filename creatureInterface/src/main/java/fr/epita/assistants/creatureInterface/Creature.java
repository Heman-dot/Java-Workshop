package fr.epita.assistants.creatureInterface;

/**
 * This abstract class provides a blueprint for creating creatures.
 * All creatures extend this class.
 */
public abstract class Creature {
    // The name of the creature
    protected String name;

    /**
     * Constructor for the Creature class.
     *
     * @param name The name of the creature
     */
    Creature(String name) {
        this.name = name;
    }

    /**
     * Get the name of the creature.
     *
     * @return The name of the creature
     */
    public String getName() {
        return name;
    }
}
