
public class Usługa implements Comparable<Usługa>{
    private Klient klient;
    private Ubranie ubranie;

    public Usługa(Klient klient, Ubranie ubranie) {
        this.klient = klient;
        this.ubranie = ubranie;
    }

    public Klient getKlient() {
        return klient;
    }

    public Ubranie getUbranie() {
        return ubranie;
    }

    @Override
    public int compareTo(Usługa o) {

        return getUbranie().compareTo(o.getUbranie());
    }

    @Override
    public String toString() {
        return "\n"+"Usługa{" +
                "" + klient +
                "" + ubranie +
                '}';
    }
}
