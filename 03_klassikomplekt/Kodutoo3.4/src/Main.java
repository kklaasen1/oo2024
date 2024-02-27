//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Mark mark = new Mark("Toyota", "Corolla", 1.6);
        Auto auto = new Auto(mark, 2015, "valge");
        auto.muudaV2rv("must");
        System.out.println("Auto uus värv on " + auto.v2rv);
        mark.muudaMudel("Avensis");
        System.out.println("Järgmine mudel on " + mark.mudel);
        int autoVanus = auto.arvutaVanus(2024);
        System.out.println("Auto vanus on " + autoVanus + " aastat");
    }
}