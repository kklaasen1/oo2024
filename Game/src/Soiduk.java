import java.util.Random;

public class Soiduk {
    int kiirus;
    String nimetus;
    int XCoord;
    int YCoord;
    int symbol;

    public Soiduk(int kiirus, String nimetus, Random random, Maailm maailm) {
        this.kiirus = kiirus;
        this.nimetus = nimetus;
        // kodus x ja y saakoordinaat, kolm sõidukit ja kõik sama mis ese.java, maini üks for tsükkel juurde
        this.symbol = 'S';
    }
}
