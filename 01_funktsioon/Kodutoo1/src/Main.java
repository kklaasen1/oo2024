//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Kodus 3 funktsiooni, milles on kasutatud vähemalt nelja erinevat tüüpi:
        //void, String, int, char, long, double, float, boolean.
        //tagastab int, parameetriks boolean
        //tagastab void, parameetriks boolean, int
        //tagastab String, parameetriks String
        //teha igast funktsioonist 2 erineva sisendiga väljakutset

        String s6na1 = "Tere";
        String s6na2 = "Tervist";
        System.out.println("Esimese sõna pikkus on: " + tagastaPikkus(s6na1));
        System.out.println("Teise sõna pikkus on :" + tagastaPikkus(s6na2));

        System.out.println("Arv ruudus = " + arvutaRuut(3));
        System.out.println("Arv ruudus = " + arvutaRuut(25));

        System.out.println("On 'a': " + kontrolliA('a'));
        System.out.println("On 'a': " + kontrolliA('x'));
    }


    private static int tagastaPikkus(String s6na) {
        return s6na.length();
    }
    private static long arvutaRuut(long number) {
        return number * number;
    }
    private static boolean kontrolliA(char t2ht) {
        return t2ht == 'a';
    }
}