import java.util.Random;

//igal klassil saab olla 1 ülemklass
public class Mangija extends Tegelane implements JuhuslikKoordinaat {
    Suund suund;
    Ese ese; // klassikomplekt
    Soiduk soiduk;

    public Mangija(Random random, int kaardiKorgus, int kaardiLaius) {
        XCoord = saaKoordinaat(random, kaardiLaius); // initsialiseerin
        YCoord = saaKoordinaat(random, kaardiKorgus);
        Symbol = 'x';
        suund = Suund.YLES;
    }

    public void liigu(String sisend, Maailm maailm) {
        switch (sisend) {
            case "w" -> suund = Suund.YLES;
            case "s" -> suund = Suund.ALLA;
            case "a" -> suund = Suund.VASAKULE;
            case "d" -> suund = Suund.PAREMALE;
        }
        switch (suund) {
            case YLES -> {
                if (YCoord > 1) YCoord--;
            }
            case ALLA -> {
                if (YCoord < maailm.kaardiKorgus - 2) YCoord++;
            }
            case VASAKULE -> {
                if (XCoord > 1) XCoord--;
            }
            case PAREMALE -> {
                if (XCoord < maailm.kaardiLaius - 2) XCoord++;
            }
        }
    }
    public int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);
    }
}
