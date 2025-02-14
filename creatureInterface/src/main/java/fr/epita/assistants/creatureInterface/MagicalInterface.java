package fr.epita.assistants.creatureInterface;

import java.util.Collection;

/**
 * This interface provides methods for creatures that are Magical!
 * Creatures that implement this interface have magical mana and spells.
 */
public interface MagicalInterface {
    /**
     * Get the mana of the creature.
     *
     * @return The mana of the creature
     */
    int getMana();

    /**
     * Get the spells of the creature.
     *
     * @return The spells of the creature
     */
    Collection<Spell> getSpells();

    /**
     * Add a spell to the creature.
     * If the spell is already present, it will not be added.
     * Be sure to check that the creature <strong>can</strong> learn the spell before adding it.
     * Prints a message if the creature cannot learn the spell.
     *
     * @param spell The spell to add
     */
    void addSpell(Spell spell);

    /**
     * Cast a spell.
     * If the creature knows the spell and has enough mana, the spell is cast.
     * Otherwise, prints a message indicating the reason.
     *
     * @param spell The spell to cast
     */
    void castSpell(Spell spell);

    /**
     * Regenerate an amount of mana.
     *
     * @param mana The amount of mana to regenerate
     */
    void regenMana(int mana);

    /**
     * Do some sparkles ✨✨✨
     */
    default void doSomeSparkles() {
        System.out.println("*sparkling effects*");
    }
}
