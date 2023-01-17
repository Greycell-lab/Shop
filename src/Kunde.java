import java.io.*;
import java.util.ArrayList;

public class Kunde implements Serializable {
    private String name;
    private String nachname;
    private Adresse adresse;
    private static ArrayList<Kunde> kunden = new ArrayList<>();
    public Kunde(){
        kunden.add(this);
    }
    public String getName() {
        return name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public static void serializeKunde(){
        try {
            FileOutputStream fileOut = new FileOutputStream("Kunden.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(kunden);
            out.close();
            fileOut.close();
        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void deserializeKunde(){
        try{
            FileInputStream fileIn = new FileInputStream("Kunden.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object test = in.readObject();
            if(test instanceof ArrayList<?>) kunden = (ArrayList)test;
            fileIn.close();
            in.close();
        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }catch(EOFException e){
            System.out.println(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Klasse nicht gefunden.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void kundenAusgabe(){
        System.out.println("Vorname\tNachname\tStraße\t\t\t\t\tOrt");
        for(var x : kunden) System.out.println(x.getName() + "\t" + x.getNachname() + "\t\t" + x.adresse.getStraße() + " " + x.adresse.getHausnummer() + "\t\t\t" + x.adresse.getPlz() + " " + x.adresse.getOrt());
    }
    public static ArrayList<Kunde> getKunden(){
        return kunden;
    }
}
