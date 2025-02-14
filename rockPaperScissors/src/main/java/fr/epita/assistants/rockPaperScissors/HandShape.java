package fr.epita.assistants.rockPaperScissors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HandShape {
    final static private List<String> shapesValues = Arrays.asList("ROCK", "PAPER", "SCISSORS");
    final private int index;

    public HandShape(final int index) {
        this.index = index;
    }

    public String getName() {
        return shapesValues.get(index);
    }

    int getIndex() {
        return index;
    }
}
