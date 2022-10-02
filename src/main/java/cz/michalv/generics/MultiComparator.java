package cz.michalv.generics;

import cz.michalv.generics.comparables.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

public class MultiComparator<T extends Comparable<?>, E extends Comparator<? super T>> implements Comparator<T> {

    Collection<E> comparators;

    T comparable1;
    T comparable2;


    MultiComparator() {
        comparators = new ArrayList<>();
    }

    public MultiComparator(T comparable1, T comparable2, E comparator1) {
        this();
        this.comparable1 = comparable1;
        this.comparable2 = comparable2;
        comparators.add(comparator1);
    }

    public void addComparator(E c) {
        comparators.add(c);
    }

    public int countCompares() {
        return comparators.stream().map(comparator -> comparator.compare(comparable1, comparable2)).reduce(0, Integer::sum);
    }

    public Optional<E> getFirstComparator() {
        return comparators.stream().findFirst();
    }

    @Override
    public int compare(T o1, T o2) {
        return comparators.stream().map(comparator -> comparator.compare(o1, o2)).reduce(0, Integer::sum);
    }
}


@Slf4j
class Test4 {

    private static MultiComparator<ComparableBarva, MyComparator> tridicka;

    public static void main(String[] args) {
        ComparableBarva myComparable1 = new MyComparable1(Barva.ZELENA);
        ComparableBarva myComparable2 = new MyComparable2(Barva.CERVENA);

        MyComparator comparator1 = new MyComparator1();
        MyComparator comparator2 = new MyComparator2();

        tridicka = new MultiComparator<>(myComparable1, myComparable2, comparator1);

        tridicka.addComparator(comparator2);

        log.info("MyCompar: {}", tridicka);
        log.info("MyCompar: {}", tridicka.getFirstComparator().map(e -> e.getClass().toString()));
        log.info("Compare {}", tridicka.countCompares());

        log.info("******************");

        List<ComparableBarva> barvy = Arrays.stream(Barva.values()).map(MyComparable1::new).collect(Collectors.toList());
        barvy.sort(tridicka);

        log.info("Sorted barvy. Comparator: {}, Comparable: {}, barvy: {}", comparator2, barvy.get(0).getClass(), barvy);


        Collection<Barva> barvySet = EnumSet.allOf(Barva.class);

    }
}