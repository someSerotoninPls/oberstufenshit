package Zahlen_raten;

public class zahlen_raten {
    public static void main(String[] args) {
        new zahlen_raten().start();
    }

    public void start() {
        boolean playing = true;
        System.out.println("Willkommen zum Zahlenraten!");

        while (playing) {
            System.out.println("Möchtest du die Zahl erraten (1) oder soll der Computer die Zahl erraten (2)?");
            int wahl = new java.util.Scanner(System.in).nextInt();
            if (wahl == 1) {
                playGameWithUserAsGuesser();
            } else if (wahl == 2) {
                playGameWithComputerAsGuesser();
            } else {
                System.out.println("Ungültige Eingabe. Bitte starte das Programm neu und wähle 1 oder 2.");
            }

            System.out.println("Möchtest du nochmal spielen? (ja/nein)");
            String nochmal = new java.util.Scanner(System.in).nextLine().toLowerCase();
            if (!nochmal.equals("ja")) {
                playing = false;
                System.out.println("Danke fürs Spielen! Auf Wiedersehen.");
            }
        }
    }

    public void playGameWithUserAsGuesser() {
        boolean playing = true;
        int loesung = (int) (Math.random() * 100) + 1;
        int versuche = 0;

        System.out.println("Ich habe mir eine Zahl zwischen 1 und 100 ausgedacht. Kannst du sie erraten?");

        while (playing) {
            System.out.println("Gib deine Zahl ein:");
            int eingabe = new java.util.Scanner(System.in).nextInt();
            versuche++;

            if (eingabe < loesung) {
                System.out.println("Die gesuchte Zahl ist größer als " + eingabe);
                continue;
            } else if (eingabe > loesung) {
                System.out.println("Die gesuchte Zahl ist kleiner als " + eingabe);
                continue;
            }

            System.out.println(
                    "Herzlichen Glückwunsch! Du hast die Zahl " + loesung + " in " + versuche + " Versuchen erraten.");
            playing = false;
        }
    }

    public void playGameWithComputerAsGuesser() {
        boolean playing = true;
        int versuche = 0;
        int min = 1;
        int max = 100;

        System.out.println("Denke dir eine Zahl zwischen 1 und 100 aus. Ich werde versuchen, sie zu erraten.");
        while (true) {
            System.out.println("Bist du bereit? (ja/nein)");
            String bereit = new java.util.Scanner(System.in).nextLine().toLowerCase();
            if (bereit.equals("ja")) {
                break;
            } else {
                System.out.println("Okay, lass dir Zeit.");
            }
        }

        while (playing) {
            int computerGuess = (min + max) / 2;
            versuche++;
            System.out.println("Mein Tipp ist: " + computerGuess);
            System.out.println("Ist meine Zahl (1) zu niedrig, (2) zu hoch oder (3) richtig?");
            int feedback = new java.util.Scanner(System.in).nextInt();

            if (feedback == 1) {
                min = computerGuess + 1;
            } else if (feedback == 2) {
                max = computerGuess - 1;
            } else if (feedback == 3) {
                System.out.println("Juhu! Ich habe deine Zahl " + computerGuess + " in " + versuche + " Versuchen erraten.");
                playing = false;
            } else {
                System.out.println("Ungültige Eingabe. Bitte antworte mit 1, 2 oder 3.");
            }
        }
    }
}
