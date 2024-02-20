import java.util.Random;

public class Draakon extends Tegelane {
    public Draakon(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord = saaKoordinaat(random, kaardiLaius);
        YCoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'D';
    }
    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
