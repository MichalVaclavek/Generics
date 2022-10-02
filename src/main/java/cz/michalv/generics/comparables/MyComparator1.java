package cz.michalv.generics.comparables;

public class MyComparator1 extends MyComparator {

    public MyComparator1() {
    }

    @Override
    public int compare(ComparableBarva o1, ComparableBarva o2) {
        return o1.compareTo(o2.b) * 2;
    }

}
