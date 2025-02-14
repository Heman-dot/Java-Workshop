package fr.epita.assistants.creatureInterface;

/**
 * This enum represents a spell that some creature can cast.
 * Refer to the subject for more information about enum with behavior.
 */
public enum Spell {
    FIREBALL(40, SpellType.FIRE, "Launches a sphere of fire that explodes upon impact."),
    HEAL(30, SpellType.NEUTRAL, "Channels divine energy to restore health."),
    MAGIC_SHIELD(15, SpellType.NEUTRAL, "Summons an arcane shield that reflects attacks."),
    TIDAL_WAVE(30, SpellType.WATER, "Summons a huge wave of water that crashes down dealing damage.");

    /**
     * The cost of the spell in mana.
     */
    private final int manaCost;

    /**
     * The type of the spell.
     */
    private final SpellType spellType;

    /**
     * The description of the spell.
     */
    private final String description;

    Spell(int manaCost, SpellType spellType, String description) {
        this.manaCost = manaCost;
        this.spellType = spellType;
        this.description = description;
    }

    public int getManaCost() {
        return manaCost;
    }

    public SpellType getSpellType() {
        return spellType;
    }

    /**
     * This method prints a description of the spell and its mana cost.
     */
    public void what() {
        // FIXME
        System.out.println(description+ "\tUses "+manaCost+" mana.");
    }
}
