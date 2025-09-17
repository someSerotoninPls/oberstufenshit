package Zahlen_raten;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public int makeGuess(int min, int max) {
        System.out.println(name + ", gib eine Zahl zwischen " + min + " und " + max + " ein:");
        return new java.util.Scanner(System.in).nextInt();
    }

    @Override
    public void receiveFeedback(int zahl, boolean zuHoch) {
        if (zuHoch) {
            System.out.println("Die Zahl " + zahl + " ist zu hoch.");
        } else {
            System.out.println("Die Zahl " + zahl + " ist zu niedrig.");
        }
        versuche++;
    }

    @Override
    public Boolean validateAnswer(int answer) {
        Boolean zuHoch = null;
        while (true) {
            System.out.println("Ist die Zahl " + answer + " korrekt oder zu hoch/zu niedrig? (k/h/n)");
            String feedback = scanner.nextLine().toLowerCase();
            if (feedback.equals("h")) {
                zuHoch = true;
            } else if (feedback.equals("n")) {
                zuHoch = false;
            } else if (feedback.equals("k")) {
            } else {
                System.out.println("Ungültige Eingabe. Bitte gib 'k', 'h' oder 'n' ein.");
                continue;
            }

            return zuHoch;
        }
    }
}
