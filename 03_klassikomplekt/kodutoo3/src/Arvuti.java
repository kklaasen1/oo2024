//maksumus ja pood võivad olla muutuvuses
public class Arvuti {
    Info info; //klassikomplekt
    int maksumus;
    String pood;

    public Arvuti(Info info, int maksumus, String pood) {
        this.info = info;
        this.maksumus = maksumus;
        this.pood = pood;
    }

    public void muudaPoodi(String pood) {
        this.pood = pood;
    }

    public int paneAllahindlus(int allahindlus) {
        this.maksumus = this.maksumus - allahindlus;
        return this.maksumus;
    }
}
