import java.util.List;

public class Maailm {
    int kaardiKorgus;
    int kaardiLaius;

    public Maailm(int korgus, int laius) {
        kaardiKorgus = korgus;
        kaardiLaius = laius;
    }

    public void prindiKaart(List<Tegelane> tegelased, List<Ese> esemed, List<Soiduk> soidukid) {
        for (int y = 0; y < kaardiKorgus; y++) {
            for (int x = 0; x < kaardiLaius; x++) {
                char symbol;
                if (y == 0 || y == kaardiKorgus - 1) {
                    symbol = '-';
                } else if (x == 0 || x == kaardiLaius - 1) {
                    symbol = '|';
                } else {
                    symbol = ' ';
                    for (Ese e : esemed) {
                        if (e.XCoord == x && e.YCoord == y) {
                            symbol = e.symbol;
                        }
                    }
                    for (Tegelane t : tegelased) {
                        if (t.XCoord == x && t.YCoord == y) {
                            symbol = t.Symbol;
                        }
                    }
                    for (Soiduk v : soidukid) {
                        if (v.XCoord == x && v.YCoord == y) {
                            symbol = v.symbol;
                        }
                    }
                    System.out.print(symbol);
                }
                System.out.println();
            }
        }
    }
}
