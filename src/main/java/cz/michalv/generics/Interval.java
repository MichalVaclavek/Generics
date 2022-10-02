package cz.michalv.generics;

import cz.michalv.generics.comparables.Barva;
import cz.michalv.generics.comparables.ComparableBarva;
import cz.michalv.generics.comparables.MyComparable1;
import lombok.extern.slf4j.Slf4j;

/**
 * Rudolf Pecinovsky, Java 9
 *
 * Trida predstavujici interval od - do objektu, ktere implementuji Comparable<? super T>
 *
 * @param <T> typ porovnavancyh objektu
 */
@Slf4j
public class Interval<T extends Comparable<? super T>> {

    private final T lowerEndpoint;

    private final T upperEndpoint;

    public Interval(T from, T to) {
        lowerEndpoint = from;
        upperEndpoint = to;
    }

    public T getLowerEndpoint() {
        return lowerEndpoint;
    }

    public T getUpperEndpoint() {
        return upperEndpoint;
    }

    /**
     * Obsahuje tento interval interval vlozeny jako parametr?
     *
     * @param interval
     * @return
     */
    public boolean contains(Interval<? extends T> interval) {
        return inside(interval.lowerEndpoint) && inside(interval.upperEndpoint);
    }

    /**
     * je tento interval intervalem, ktery je vlozeny jako parametr?
     *
     * @param interval
     * @return
     */
    public boolean isContainedIn(Interval<? super T> interval) {
        return interval.inside(lowerEndpoint) && interval.inside(upperEndpoint);
    }

    private boolean inside(T object) {
        return (lowerEndpoint.compareTo(object) < 0) && (upperEndpoint.compareTo(object) > 0);
    }

    public Interval<T> intersection(Interval<? extends T> interval) {
        return new Interval<>(
          MathT.max(this.lowerEndpoint, interval.lowerEndpoint),
          MathT.min(this.upperEndpoint, interval.upperEndpoint));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Interval interval
                && this.lowerEndpoint.equals(interval.lowerEndpoint)
                && this.upperEndpoint.equals(interval.upperEndpoint);
    }

    public String toString() {
        return "[" + lowerEndpoint + ", " + upperEndpoint + "]";
    }


    static class CompBarva implements Comparable<CompBarva> {

        protected Barva barva;

        CompBarva(Barva barva) {
            this.barva = barva;
        }

        public Barva getBarva() {
            return barva;
        }

        @Override
        public int compareTo(CompBarva o) {
            return barva == o.getBarva() ? 0 :
                    barva.ordinal() > o.getBarva().ordinal() ? 1 : -1;
        }

        @Override
        public String toString() {
            return barva.toString();
        }
    }


    static class CompBarva2 extends CompBarva {

        CompBarva2(Barva barva) {
            super(barva);
        }

        @Override
        public int compareTo(CompBarva o) {
            return barva == o.getBarva() ? 0 :
                    barva.ordinal() < o.getBarva().ordinal() ? 1 : -1;
        }

    }


    public static void main(String[] args) {
        MyComparable1 mc1 = new MyComparable1(Barva.CERVENA);
        MyComparable1 mc2 = new MyComparable1(Barva.CERNA);

        CompBarva compBarva1 = new CompBarva(Barva.CERVENA);
        CompBarva compBarva2 = new CompBarva(Barva.MODRA);


        Interval<CompBarva> i1 = new Interval<>(compBarva1, compBarva2);

        Interval<CompBarva> i2 = new Interval<>(new CompBarva(Barva.ZELENA), new CompBarva(Barva.FIALOVA));

        log.info("I1 contains i2? : " + i1.contains(i2));

        log.info("I1 intersection with i2? : " + i1.intersection(i2));

        log.info("******************************************************");

        CompBarva compBarva3 = new CompBarva(Barva.CERVENA);
        CompBarva2 compBarva24 = new CompBarva2(Barva.ZLUTA);


        Interval<CompBarva> i3 = new Interval<>(compBarva1, compBarva2);

        Interval<CompBarva2> i24 = new Interval<>(new CompBarva2(Barva.ORANZOVA), new CompBarva2(Barva.ZELENA));

        log.info("I3 contains i24? : " + i3.contains(i24));
        log.info("I24 is contained in i3? : " + i24.isContainedIn(i3));
        // log.info("I3 is contained in i24? : " + i3.isContainedIn(i24)); // nelze
        log.info("I24 is contained in i2? : " + i24.isContainedIn(i2));

        log.info("I3 intersection with i24? : " + i3.intersection(i24));
//        log.info("I24 intersection with i3? : " + i24.intersection(i3)); // nelze



    }

}
