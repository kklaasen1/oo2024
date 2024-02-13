public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius){
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(Mangija mangija, Draakon draakon, Ork ork) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus -1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius -1) {
                    symbol = '|';
                } else {
                    if (x == mangija.XCoord && y == mangija.YCoord) {
                        symbol = mangija.Symbol;
                    } else if (x == draakon.XCoord && y == draakon.YCoord) {
                        symbol = draakon.Symbol;
                    } else if (x == ork.XCoord && y == ork.YCoord) {
                        symbol = ork.Symbol;
                    } else  {
                        symbol = ' ';
                    }
                }
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
