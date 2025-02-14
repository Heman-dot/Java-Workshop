package fr.epita.assistants.drawing;

public class Square extends Rectangle {
    private final int length;

    public Square(int length) {
        super(length, length);
        this.length = length;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || i == length - 1 || j == 0 || j == length - 1)
                    System.out.print("# ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}