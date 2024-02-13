import java.util.Random;

public class Ork {
    int XCoord;
    int YCoord;
    char Symbol;

    public Ork(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord = saaKoordinaat(random, kaardiLaius);
        YCoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'O';
    }
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
