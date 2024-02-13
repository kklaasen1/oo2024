//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Main class + enda tehtud class
        // Classis constructor
        // vähemalt 2 omadust
        // vähemalt 2 funktsiooni
        // Mainis vähemalt kaks instantsi temast
        // Mainis vähemalt 2 funktsiooni väljakutset
        // vähemalt 2 System.out.println()
        Kasutaja kasutaja = new Kasutaja("M", true, 30, 'x', 0.0);
        Kasutaja kasutaja2 = new Kasutaja("S", false, 35, 'y', 25.0);

        kasutaja.muudaAktiivne();
        System.out.println(kasutaja.aktiivne);
        kasutaja2.lisaRaha(500.0);
        double kasutaja2Raha
        System.out.println(kasutaja2Raha);

        Tellimus tellimus1 = new Tellimus("M", 199.0, "Coca-Cola");
        Tellimus tellimus2 = new Tellimus("S", 299.5, "as");

        double dollarites = tellimus1.tellimuseSummaDollarites();
        System.out.println(dollarites);

        tellimus2.telljaNimeVahetus();
        System.out.println(tellimus2.tellija);
    }
}