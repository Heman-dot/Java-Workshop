package fr.epita.assistants;

import fr.epita.assistants.drawing.Entity;
import fr.epita.assistants.drawing.Sharp;

public class Circle extends Entity {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        for (int y = -radius; y <= radius; y++) {
            for (int x = -radius; x <= radius; x++) {
                int sqDist = Math.abs(radius * radius - (x * x + y * y));
                if (sqDist < radius) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
