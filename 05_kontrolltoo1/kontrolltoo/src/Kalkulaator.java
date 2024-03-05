import java.util.ArrayList;

public class Kalkulaator {
    public double korrutaJaRuutjuur(double arv1, double arv2) {
        double tulemus = arv1 * arv2;
        return Math.sqrt(tulemus);
    }

    public ArrayList<Double> arvud = new ArrayList<>();

    public void lisaArvud(ArrayList<Double> uuedArvud) {
        arvud.addAll(uuedArvud);
    }
    public double korrutaJaVotaJuurt() {
        double tulemus = 1.0;
        for (Double arv : arvud) {
            tulemus = tulemus * arv;
        }
        return Math.pow(tulemus, 1.0/arvud.size());
    }
}
