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
            if(in.readObject() instanceof ArrayList<?>) kunden = (ArrayList) in.readObject();
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
    public static ArrayList<Kunde> getKunden(){
        return kunden;
    }
}
