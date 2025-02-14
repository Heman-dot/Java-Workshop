package fr.epita.assistants;

import fr.epita.assistants.creatureInterface.*;

public class Main {
    public static void main(String[] args) {
        Dragon bob = new Dragon("Bob", 200);
        Mage mage = new Mage("Icien", 100);

        bob.greet(mage);
        mage.greet(bob);
        bob.addSpell(Spell.FIREBALL);
        bob.addSpell(Spell.TIDAL_WAVE);
        bob.fly();
        System.out.println(bob.getMana());
        bob.castSpell(Spell.FIREBALL);
        bob.castSpell(Spell.HEAL);
        bob.regenMana(17);
        System.out.println(bob.getMana());
        bob.castSpell(Spell.FIREBALL);
        System.out.println(bob.getMana());
        bob.hello();

        Spell.HEAL.what();
    }
}