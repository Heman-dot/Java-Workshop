package fr.epita.assistants.rockPaperScissors;

import java.util.Random;


final class Bot {
    private final String name;
    private final Random random = new Random();

    public Bot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public final HandShape getBotHandShape() {
        return new HandShape(random.nextInt(3));
    }
}
