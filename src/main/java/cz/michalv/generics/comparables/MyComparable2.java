package cz.michalv.generics.comparables;


public class MyComparable2 extends ComparableBarva {

    public MyComparable2(Barva b) {
        super(b);
    }

    @Override
    public int compareTo(Barva o) {
        return b == o ? 0 :
                b.ordinal() - 2 > o.ordinal() ? 1 : -1;
    }
}
