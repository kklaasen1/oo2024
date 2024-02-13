import java.util.Random;

public class Draakon {
    int XCoord;
    int YCoord;
    char Symbol;

    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord = saaKoordinaat(random, kaardiLaius);
        YCoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'D';
    }
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
