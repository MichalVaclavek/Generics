package cz.michalv.generics.comparables;

import java.util.Comparator;

public class MyComparator implements Comparator<ComparableBarva> {

    @Override
    public int compare(ComparableBarva o1, ComparableBarva o2) {
        return 0;
    }

    @Override
    public Comparator<ComparableBarva> reversed() {
        return Comparator.super.reversed();
    }
}
