public class Mark {
    String nimi;
    String mudel;
    double mootoriMaht;

    public Mark(String nimi, String mudel, double mootoriMaht) {
        this.nimi = nimi;
        this.mudel = mudel;
        this.mootoriMaht = mootoriMaht;
    }
    public void muudaMudel(String uusMudel) {
        mudel = uusMudel;
    }
}
