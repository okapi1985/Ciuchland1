
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pralnia {

    public List<Usługa> listaUslug;
    public Queue<Usługa> kolejkaUslug;

    public List<Usługa> getListaUslug() {
        return listaUslug;
    }

    public Queue<Usługa> getKolejkaUslug() {
        return kolejkaUslug;
    }

    public Pralnia(){
        listaUslug = new ArrayList<>();
        kolejkaUslug = new PriorityQueue<>();
    }

    public void dodajUsluge(Usługa usluga){
        listaUslug.add(usluga);
        kolejkaUslug.offer(usluga);
    }

    public void wykonanoUsluge(Usługa usluga){
        listaUslug.remove(usluga);
    }

    public void znajdzUslugiDlaKonkretnegoKlienta(Klient klient) {
        for (Usługa usluga : listaUslug) {
            if (usluga.getKlient().equals(klient)) {
                System.out.println("Test 4: Usługa " + usluga.getKlient() + " " + usluga.getUbranie());
                System.out.println();
            }
        }
    }

    public void znajdzUslugiZKonkretnymMaterialem(Ubranie.Materiał material){
        for (Usługa usluga : listaUslug){
            if (usluga.getUbranie().getMaterial().equals(material)){
                System.out.println("Test 5: Usługa "+ usluga.getUbranie().getMaterial()+" "+usluga.getUbranie());
                System.out.println();
            }
        }
    }

    public void wykonajWszystkieUslugi(){
        while (kolejkaUslug.peek() != null){
            Usługa usluga = kolejkaUslug.poll();
            System.out.println("Test 6: Wykonano usługę: "+usluga.getKlient()+" "+usluga.getUbranie());
            wykonanoUsluge(usluga);
        }
    }


    public static void main(String[] args) {
        Pralnia pralnia = new Pralnia();
        Klient klient = new Klient("Stanisław","Nowak");
        Ubranie ubranie = new Ubranie(Ubranie.Materiał.BAWEŁNA,"t-shirt","zielony");
        Usługa usluga = new Usługa(klient,ubranie);


        Usługa usluga1 = new Usługa(new Klient("Stefan","Mewa"),new Ubranie(Ubranie.Materiał.BAWEŁNA,"polo","niebieski"));
        Usługa usluga2 = new Usługa(new Klient("Joanna","Wydra"),new Ubranie(Ubranie.Materiał.LEN,"spódnica","czarna"));
        Usługa usluga3 = new Usługa(new Klient("Jan","Kozioł"),new Ubranie(Ubranie.Materiał.WEŁNA,"marynarka","brązowa"));

        pralnia.dodajUsluge(usluga);
        pralnia.dodajUsluge(usluga1);
        pralnia.dodajUsluge(usluga2);
        pralnia.dodajUsluge(usluga3);

        System.out.println("Test 1: Lista usług do wykonania w pralni: "+pralnia.listaUslug);
        System.out.println();
        System.out.println("Test 2: Kolejka usług do wykonania w pralni: "+pralnia.kolejkaUslug);
        System.out.println();

        pralnia.wykonanoUsluge(usluga3);

        System.out.println("Test 3: Lista pozostałych do wykonania usług: "+pralnia.listaUslug);
        System.out.println();

        pralnia.znajdzUslugiDlaKonkretnegoKlienta(klient);
        pralnia.znajdzUslugiZKonkretnymMaterialem(Ubranie.Materiał.BAWEŁNA);
        pralnia.wykonajWszystkieUslugi();



    }
}
