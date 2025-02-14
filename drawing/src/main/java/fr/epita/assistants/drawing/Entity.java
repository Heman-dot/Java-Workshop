package fr.epita.assistants.drawing;

public class Entity implements IDrawable {
    private static long SEQUENCE = 0; // Changed to long to avoid reflection issues
    private final long id;

    public Entity() {
        this.id = SEQUENCE++;
    }

    public long getId() {
        return id;
    }

    @Override
    public void draw() {

    }
}