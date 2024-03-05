import java.io.*;
import java.util.ArrayList;


// Koosta klass ja tema sisse funktsioon, mis korrutab parameetritena antud kaks arvu ning võtab neist ruutjuure (Math.sqrt). Katseta.
//Koosta klassi sisse teine funktsioon, kuhu võib arve rohkem sisestada, need antakse ette kogumina. Arvud korrutatakse kokku ning võetakse niimitmes juur (astendaja pöördväärtus, Math.pow), kuimitu arvu oli.
//Failis on viie aasta kohta koefitsiendid, kui palju igal aastal palk muutus (ise koosta testandmed). Samuti esimese aasta palk. Anna nii alg- kui ka lõppsumma klassi sees asuvatesse muutujatesse. Seejärel väljasta teise faili palk igal aastal neist ning võrdlusena kõrvale palk, kui palk oleks tõusnud iga aasta järel eelmistest koefitsentidest 2 korda kiiremini (kõik koefitsendid kahega korrutatult).
public class Main {
    public static void main(String[] args) throws IOException {
        Kalkulaator kalkulaator = new Kalkulaator();
        double arv1 = 9.6;
        double arv2 = 5.2;

        double tulemus = kalkulaator.korrutaJaRuutjuur(arv1, arv2);
        System.out.println("Antud arvude " + arv1 + " ja " + arv2 + " korrutuse ruutjuur on: " + tulemus);

        Kalkulaator kalkulaator2 = new Kalkulaator();
        ArrayList<Double> uuedArvud = new ArrayList<>();
        uuedArvud.add(2.0);
        uuedArvud.add(3.0);
        uuedArvud.add(4.0);

        kalkulaator2.lisaArvud(uuedArvud);
        System.out.println("Korrutatud arvude niimitmes juur: " + kalkulaator2.korrutaJaVotaJuurt());


        ArrayList<Double> koefitsiendid = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("koefitsiendid.txt"));
        String firstLine = br.readLine();
        double esimeneAastaPalk = Double.parseDouble(firstLine);
        double loppPalk = esimeneAastaPalk;
        String rida;
        while ((rida = br.readLine()) != null) {
            koefitsiendid.add(Double.parseDouble(rida));
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("palgad.txt"));
        bw.write("Aasta\tPalk\tKorrutatud palk");
        bw.newLine();

        double korrutamiseKordaja = 2.0;
        double korrutatudPalk = esimeneAastaPalk;

        for (int i = 0; i < koefitsiendid.size(); i++) {
            loppPalk = loppPalk * (1 + koefitsiendid.get(i));
            korrutatudPalk = korrutatudPalk * (1 + koefitsiendid.get(i) * korrutamiseKordaja);

            bw.write((i + 1) + "\t" + loppPalk + "\t" + korrutatudPalk + "\n");
        }

        br.close();
        bw.close();
    }

}