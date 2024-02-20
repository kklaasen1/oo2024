public class Main {
    public static void main(String[] args) {
        Kasutaja kasutaja = new Kasutaja("Mari Maasikas", "EE987654321", 1500.0);
        Kasutaja kasutaja2 = new Kasutaja("Peeter Porgand", "EE123456789", 987.0);

        System.out.println("Kontonumbrile " + kasutaja.kontoNumber + " tehakse sissemakse ja võetakse sularaha");
        kasutaja.sisseMakse(500);
        kasutaja.v2ljaMakse(2500);
        System.out.println("Hetke kontoseis: " + kasutaja.getKontoSeis() + " EUR");

        System.out.println("Kontonumbrile " + kasutaja2.kontoNumber + " tehakse Sissemakse");
        kasutaja2.sisseMakse(123.0);
        System.out.println("Hetke kontoseis: " + kasutaja2.getKontoSeis() + " EUR");
    }
}