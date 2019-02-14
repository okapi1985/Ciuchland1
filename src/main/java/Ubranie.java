
public class Ubranie implements Comparable<Ubranie>{
    private Materiał material;
    private String rodzaj;
    private String kolor;

    public Ubranie(Materiał material, String rodzaj, String kolor) {
        this.material = material;
        this.rodzaj = rodzaj;
        this.kolor = kolor;
    }

    public Materiał getMaterial() {
        return material;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public String getKolor() {
        return kolor;
    }

    @Override
    public int compareTo(Ubranie o) {

        return getMaterial().compareTo(o.getMaterial());
    }

    @Override
    public String toString() {
        return "\n"+"Ubranie{" +
                "material=" + material +
                ", rodzaj='" + rodzaj + '\'' +
                ", kolor='" + kolor + '\'' +
                '}';
    }

    enum Materiał{
        BAWEŁNA,
        POLIESTER,
        WEŁNA,
        JEDWAB,
        LEN,

    }
}
