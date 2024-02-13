import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        Maailm maailm = new Maailm(5, 10);

        Mangija mangija = new Mangija(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Draakon draakon = new Draakon(random, maailm.kaardiKorgus, maailm.kaardiLaius);
        Ork ork = new Ork(random, maailm.kaardiKorgus, maailm.kaardiLaius);

        // import java.util.Scanner;
        Scanner scanner = new Scanner(System.in); // järgmine tund selgitame lähemalt

        maailm.prindiKaart(mangija, draakon, ork);
        String sisend = scanner.nextLine();

        mangija.liigu(sisend, maailm);

//        if (sisend.equals("w")) {
//            mangijaYCoord--;
//        } else if (sisend.equals("s")) {
//            mangijaYCoord++;
//        }  else if (sisend.equals("a")) {
//            mangijaXCoord--;
//        } else if (sisend.equals("d")) {
//            mangijaXCoord++;
//        }

        // if (boolean || andbmebaasiKüsimine())
        // if (boolean && andbmebaasiKüsimine())
        while (!sisend.equals("end")) { // .equals --> ==    !m.equals() --> !=
            maailm.prindiKaart(mangija, draakon, ork);
            sisend = scanner.nextLine();
            mangija.liigu(sisend, maailm);
        }



    } // main (args[])

    //private static int saaKoordinaat(Random random, int kaart) {
    //    return random.nextInt(1, kaart - 1);
    //}
} // Main ()