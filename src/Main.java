public class Main {
    public static void main(String[] args) {
        Warenkorb warenkorb = new Warenkorb();
        Kunde.deserializeKunde();
        //while(true) warenkorb.showMenu();
        Kunde.kundenAusgabe();
    }
}