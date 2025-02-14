package fr.epita.assistants.creatureInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Dragon extends Creature implements SpeakableInterface, FlyingInterface, MagicalInterface{
    private int mana;
    private Set<Spell> spells;

    public Dragon(String name,int mana){
        super(name);
        this.mana=mana;
        this.spells=new HashSet<>();
    }

    @Override
    public int getMana(){
        return mana;
    }

    @Override
    public Set<Spell> getSpells(){
        return spells;
    }

    @Override
    public void addSpell(Spell spell){
        if(spell.getSpellType() == SpellType.WATER){
            System.out.println("Dragon cannot learn WATER spells.");
            return;
        }else{
            spells.add(spell);
        }
    }
    @Override
    public void castSpell(Spell spell){
        if(spell.getSpellType() == SpellType.WATER){
            System.out.println("Dragon cannot learn WATER spells.");
            return;
        }else if(!spells.contains(spell)){
            System.out.println(name+" does not know "+spell +".");
            return;
        } else if(mana < spell.getManaCost()){
            System.out.println(getName()+" does not have enough mana.");
            return;
        } else {
            mana -= spell.getManaCost();
            System.out.println(name+ " casted "+spell+".");
        }
    }
    @Override
    public void regenMana(int mana){
        this.mana+=mana;
    }
}

