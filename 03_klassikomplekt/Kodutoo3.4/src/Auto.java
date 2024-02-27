public class Auto {
    Mark mark;
    int aasta;
    String v2rv;

    public Auto(Mark mark, int aasta, String v2rv) {
        this.mark = mark;
        this.aasta = aasta;
        this.v2rv = v2rv;
    }

    public void muudaV2rv(String v2rv) {
        this.v2rv = v2rv;
    }

    public int arvutaVanus(int praeguneAasta) {
        return praeguneAasta - this.aasta;
    }
}
