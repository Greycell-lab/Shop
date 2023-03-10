import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Adresse implements Serializable {
    private static boolean passed;
    private String straße;
    private int hausnummer;
    private int plz;
    private String ort;
    private final Kunde kunde;
    private final ArrayList<Adresse> adressen = new ArrayList<>();
    public Adresse(){
        kunde = new Kunde();
        adresseEingeben();
        adressen.add(this);
        kunde.setAdresse(this);
        kunde.serializeKunde();
    }
    public void adresseEingeben(){
        System.out.println("Ihre Adresse:");
        do {
            try{
                System.out.print("Name: ");
                kunde.setName(new Scanner(System.in).nextLine());
                System.out.print("Nachname: ");
                kunde.setNachname(new Scanner(System.in).nextLine());
                System.out.print("Straße: ");
                this.straße = new Scanner(System.in).nextLine();
                System.out.print("Hausnummer: ");
                this.hausnummer = Integer.parseInt(new Scanner(System.in).nextLine());
                System.out.print("PLZ: ");
                this.plz = Integer.parseInt(new Scanner(System.in).nextLine());
                System.out.print("Ort: ");
                this.ort = new Scanner(System.in).nextLine();
                passed = true;
            }catch(NoSuchElementException e){
                System.out.println("Bitte geben sie die Informationen ein.");
                passed = false;
            }catch(IllegalStateException e){
                System.out.println("Etwas ist schief gelaufen.");
                passed = false;
            }catch(NumberFormatException e){
                System.out.println("Kein gültiger Wert.");
                passed = false;
            }
        }while(!passed);
    }
    @Override
    public String toString(){
        return "Name: " + kunde.getName() + " " + kunde.getNachname() + "\nStraße: " + this.straße + " " + this.hausnummer + "\nPLZ Ort: " + plz + " " + ort;
    }

    public String getStraße() {
        return straße;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public int getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }
}
