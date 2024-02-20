public class Kasutaja {
    String nimi;
    String kontoNumber;
    double kontoSeis;

    public Kasutaja(String nimi, String kontoNumber, double kontoSeis) {
        this.nimi = nimi;
        this.kontoNumber = kontoNumber;
        this.kontoSeis = kontoSeis;
    }

    public void sisseMakse(double summa) {
        this.kontoSeis = this.kontoSeis + summa;
        System.out.println("Sissemakse tehtud summas " + summa + " EUR");
    }

    public void v2ljaMakse(double summa) {
        if (summa <= kontoSeis) {
            this.kontoSeis = this.kontoSeis - summa;
            System.out.println("Sularaha väljavõtt õnnestus summas " + summa + " EUR");
        } else {
            System.out.println("Kontol puuduvad piisavad vahendid. Ei saa väljastada sularaha summas " + summa + " EUR");
        }
    }

    public double getKontoSeis() {
        return kontoSeis;
    }
}