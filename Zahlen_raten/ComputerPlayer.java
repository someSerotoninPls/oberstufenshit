package Zahlen_raten;

public class ComputerPlayer extends Player {
    private int aktuellesMin;
    private int aktuellesMax;
    private int geheimZahl;

    public ComputerPlayer(String name) {
        super(name);
        this.aktuellesMin = 1;
        this.aktuellesMax = 100;
        this.geheimZahl = (int) (Math.random() * 100) + 1;
    }

    @Override
    public int makeGuess(int min, int max) {
        int guess = (aktuellesMin + aktuellesMax) / 2;
        System.out.println(name + " rät die Zahl: " + guess);
        return guess;
    }

    @Override
    public void receiveFeedback(int zahl, boolean zuHoch) {
        if (zuHoch) {
            aktuellesMax = zahl - 1;
        } else {
            aktuellesMin = zahl + 1;
        }
        versuche++;
    }

    @Override
    public Boolean validateAnswer(int answer) {
        Boolean zuHoch = null;
        if (answer > geheimZahl) {
            zuHoch = true;
        } else if (answer < geheimZahl) {
            zuHoch = false;
        } else {
        }
        return zuHoch;
    }
    
}
