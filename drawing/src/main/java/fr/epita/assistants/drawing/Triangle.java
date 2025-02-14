package fr.epita.assistants.drawing;

public class Triangle extends Sharp {
    private final int length;

    public Triangle(int length) {
        this.length = length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == length - 1 || j == 0 || j == i)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}