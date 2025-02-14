package fr.epita.assistants.creatureInterface;

import java.util.HashSet;
import java.util.Set;

public class Mermaid extends Creature implements SpeakableInterface, SwimmingInterface, MagicalInterface {
    private boolean swimmingState;
    private int mana = 0;
    private final Set<Spell> spells = new HashSet<>();

    public Mermaid(BaseHuman baseHuman, Fish fish) {
        super(capitalizeFirstLetter(baseHuman.getName()) + fish.getName().toLowerCase());
        this.swimmingState = baseHuman.getSwimmingState();

        if (baseHuman instanceof Mage mage) {
            for (Spell spell : mage.getSpells()) {
                if (spell.getSpellType() == SpellType.FIRE) {
                    System.out.println(name + " forgot the spell " + spell+".");
                } else {
                    spells.add(spell);
                }
            }
        }
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public Set<Spell> getSpells() {
        return spells;
    }

    @Override
    public void addSpell(Spell spell) {
        if (spell.getSpellType() == SpellType.FIRE) {
            System.out.println("Mermaid cannot learn FIRE spells.");
            return;
        }
        spells.add(spell);
    }

    @Override
    public void castSpell(Spell spell) {
        if (spell.getSpellType() == SpellType.FIRE) {
            System.out.println("Mermaid cannot learn FIRE spells.");
            return;
        }
        else if (!spells.contains(spell)) {
            System.out.println(name + " does not know " + spell+".");
            return;
        }
        int manaCost = spell.getManaCost();
        if (spell.getSpellType() == SpellType.WATER && swimmingState) {
            manaCost *= 0.6;
        }
        if (mana < manaCost) {
            System.out.println(name + " does not have enough mana.");
            return;
        }
        mana -= manaCost;
        System.out.println(name + " casted " + spell+".");
    }

    @Override
    public void regenMana(int mana) {
        this.mana += mana;
    }

    @Override
    public void swim() {
        swimmingState = true;
        System.out.println("I'm a Mermaid and I'm swimming.");
    }

    @Override
    public boolean getSwimmingState() {
        return swimmingState;
    }

    @Override
    public void emerge() {
        swimmingState = false;
    }

    @Override
    public void hello() {
        System.out.println("Hello, my name is " + name + " and I'm a Mermaid.");
    }

    private static String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
