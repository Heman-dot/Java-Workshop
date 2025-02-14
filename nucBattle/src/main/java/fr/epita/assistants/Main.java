package fr.epita.assistants;

import fr.epita.assistants.nucbattle.BattleManager;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        BattleManager battleManager = new BattleManager(Objects.requireNonNull(BattleManager.class.getClassLoader().getResource("exampleBattle1.json")).getPath());
        battleManager.computeBattle("output.json");
    }
}
