import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void serializeKunde(){
        try {
            FileOutputStream fileOut = new FileOutputStream("Kunden.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public static void deserializeKunde(){
        Kunde kunde = new Kunde();
        try{
            FileInputStream fileIn = new FileInputStream("Kunden.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            kunde = (Kunde)in.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println("Klasse nicht gefunden.");
        }
    }
    public static ArrayList<Kunde> getKunden(){
        return kunden;
    }
    public Adresse getAdresse(){
        return adresse;
    }
}
