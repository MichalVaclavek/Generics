package cz.michalv.generics.comparables;

public class ComparableBarva implements Comparable<Barva> {

    Barva b;

    ComparableBarva(Barva b) {
        this.b = b;
    }

    @Override
    public int compareTo(Barva o) {
        return b.compareTo(o);
    }

    @Override
    public String toString() {
        return b.toString();
    }

}
