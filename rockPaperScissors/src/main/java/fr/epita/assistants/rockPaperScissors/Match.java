package fr.epita.assistants.rockPaperScissors;

final class Match {
    private static int matchCount = 0;
    private final int currentMatchNumber;
    private final String player1Name;
    private final String player2Name;
    private final HandShape player1Hand;
    private final HandShape player2Hand;

    public Match(String player1Name, String player2Name, HandShape player1Hand, HandShape player2Hand) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Hand = player1Hand;
        this.player2Hand = player2Hand;
        this.currentMatchNumber = ++matchCount;
    }

    public static int getMatchCount() {
        return matchCount;
    }

    public static void resetMatchCount() {
        matchCount = 0;
    }

    public int getCurrentMatchNumber() {
        return currentMatchNumber;
    }

    public void runMatch() {
        System.out.println("Let's start match number " + currentMatchNumber + "!");
        System.out.println("Rock, Paper, Scissors!");
        System.out.println(player1Name + " is playing: " + player1Hand.getName());
        System.out.println(player2Name + " is playing: " + player2Hand.getName());

        int result = (player1Hand.getIndex() - player2Hand.getIndex() + 3) % 3;
        if (result == 0) {
            System.out.println("DRAW!");
        } else if (result == 1) {
            System.out.println("The winner is " + player1Name + "!");
        } else {
            System.out.println("The winner is " + player2Name + "!");
        }
    }
}