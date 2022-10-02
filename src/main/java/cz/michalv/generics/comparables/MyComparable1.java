package cz.michalv.generics.comparables;

public class MyComparable1 extends ComparableBarva {

    public MyComparable1(Barva b) {
        super(b);
    }

    @Override
    public int compareTo(Barva o) {
        return b == o ? 0 :
                b.ordinal() > o.ordinal() + 2 ? 1 : -1;
    }
}
