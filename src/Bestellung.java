import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Bestellung {
    private static final String LINES = "------------------------------";
    private static boolean passed;
    private final LocalDate date = LocalDate.now();
    private final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final ArrayList<HashMap<Artikel, Integer>> bestellungen = new ArrayList<>();
    private final String datumFormatiert = date.format(format);
    public Bestellung(Warenkorb warenkorb){
        bestellungen.add(warenkorb.getWarenkorb());
        bestellungAbschicken(warenkorb);

    }
    public void bestellungAbschicken(Warenkorb warenkorb) {
        if (warenkorb.getWarenkorb().size() == 0) System.out.println("Der Warenkorb ist leer.");
        else {
            warenkorb.showWarenkorb();

            Adresse adresse = new Adresse();

            double bezahlen = 0;
            double rest = Math.round(warenkorb.getSumme() * 100.0D) / 100.0D;
            do {
                try {
                    System.out.print("Bitte bezahlen sie den geforderten Betrag: ");
                    bezahlen = Double.parseDouble(new Scanner(System.in).nextLine());
                    passed = true;
                } catch (NumberFormatException e) {
                    System.out.println("Etwas ist schief gelaufen. Versuche es erneut");
                    passed = false;
                }
                rest -= bezahlen;
                if (rest > 0) {
                    System.out.println("Sie haben zu wenig geld gegeben.");
                    System.out.println("Bitte zahlen sie die restlichen " + String.format("%.2f", rest) + "€");
                }
            } while (!passed || rest > 0);
            if (-rest > 0) System.out.println("Sie erhalten " + String.format("%.2f", -rest) + "€ zurück.");
            System.out.println(LINES);
            System.out.println("Vielen Dank für Ihren Einkauf.");
            bestellDetails(warenkorb, adresse);
        }
    }
    public void bestellDetails(Warenkorb warenkorb, Adresse adresse){
        System.out.println("Bestelldetails:");
        System.out.println("Bestelldatum: " + this.datumFormatiert);
        System.out.println(LINES);
        warenkorb.showWarenkorb();
        System.out.println(LINES);
        System.out.println(adresse);
        System.out.println(LINES);
        warenkorb.getWarenkorb().clear();
    }
}
