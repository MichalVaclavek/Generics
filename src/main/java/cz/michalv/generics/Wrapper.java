package cz.michalv.generics;

class Wrapper<T extends Comparable <T> > implements Comparable <Wrapper<T>> {
    private final T theObject;

    public Wrapper(T t) { theObject = t; }

    public T getWrapper() { return theObject; }

    public int compareTo(Wrapper <T> other) {
        return theObject.compareTo(other.theObject); }
}

/**
    Wrapper <String>          wrapper1 = new Wrapper <String> ("Oystein"); Wrapper <? extends Number> wrapper2 = new Wrapper <Long> (0L); Wrapper <?>               wrapper3 = new Wrapper <Date> (new Date()); Wrapper <Number>          Wrapper <int>            wrapper4 = new Wrapper <Number> (new Long(0L)); // chyba wrapper5 = new Wrapper <int> (5); // chyba
 */