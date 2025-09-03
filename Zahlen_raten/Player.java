package Zahlen_raten;

public abstract class Player {
    protected String name;
    protected int versuche;

    public Player(String name) {
        this.name = name;
        this.versuche = 0;
    }

    public abstract int makeGuess(int min, int max);
    public abstract void receiveFeedback(int zahl, boolean zuHoch);
    public abstract Boolean validateAnswer(int answer);
}
