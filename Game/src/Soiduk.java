import java.util.Random;

public class Soiduk {
    String nimetus;
    int kiirus;
    int XCoord;
    int YCoord;
    char symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        // kodus x ja y saakoordinaat, kolm sõidukit ja kõik sama mis ese.java, maini üks for tsükkel juurde
        XCoord = saaKoordinaat(random, maailm.kaardiLaius);
        YCoord = saaKoordinaat(random, maailm.kaardiKorgus);
        this.symbol = 'S';
    }

    private int saaKoordinaat(Random random, int kaart) {
        return random.nextInt(1, kaart - 1);    }
}