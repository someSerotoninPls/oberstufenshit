package Zahlen_raten;

public class ZahlenRaten {
    private int minNummer;
    private int maxNummer;
    private Player spieler;
    private Player numberMaster;

    public ZahlenRaten(int minNummer, int maxNummer, Player spieler, Player numberMaster) {
        this.minNummer = minNummer;
        this.maxNummer = maxNummer;
        this.spieler = spieler;
        this.numberMaster = numberMaster;
    }

    public void spielen() {
        boolean gefunden = false;
        int versuche = 0;

        System.out.println(
                spieler.name + " versucht eine Zahl zwischen " + minNummer + " und " + maxNummer + " zu erraten.");

        while (!gefunden) {
            int tipp = spieler.makeGuess(minNummer, maxNummer);
            versuche++;

            Boolean zuHoch = numberMaster.validateAnswer(tipp);
            if (zuHoch == null) {
                gefunden = true;
                System.out.println(spieler.name + " hat die Zahl " + tipp + " in " + versuche + " Versuchen erraten!");
            } else {
                spieler.receiveFeedback(tipp, zuHoch);
            }
        }
    }

    public static void main(String[] args) {
        Player mensch = new HumanPlayer("Mensch");
        Player computer = new ComputerPlayer("Computer");

        System.out.println("Willkommen zum Zahlenraten-Spiel!");
        while (true) {
            System.out.println("Wähle den Spielmodus: \n(1) Du rätst die Zahl des Computers, \n(2) Der Computer rät deine Zahl");
            int modus = new java.util.Scanner(System.in).nextInt();

            if (modus == 1) {
                ZahlenRaten spiel = new ZahlenRaten(1, 100, mensch, computer);
                spiel.spielen();
            } else if (modus == 2) {
                ZahlenRaten spiel = new ZahlenRaten(1, 100, computer, mensch);
                spiel.spielen();
            } else {
                System.out.println("Ungültige Eingabe.");
                continue;
            }
            

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Möchtest du nochmal spielen? (ja/nein)");
            String nochmal = new java.util.Scanner(System.in).next().toLowerCase();
            if (!nochmal.equals("ja")) {
                System.out.println("Danke fürs Spielen! Auf Wiedersehen.");
                break;
            }
        }
    }
}
