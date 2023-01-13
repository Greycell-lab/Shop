import java.util.ArrayList;
import java.util.HashMap;

public class Kunde {
    private String name;
    private String nachname;
    private Adresse adresse;
    private ArrayList<Kunde> kunden = new ArrayList<>();
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
}
