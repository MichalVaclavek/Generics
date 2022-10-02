package cz.michalv.generics;

public class MathT {

    public static <T extends Comparable<? super T>> T max(T prvni, T druhy) {
        return prvni.compareTo(druhy) > 0 ? prvni : druhy;
    }

    public static <T extends Comparable<? super T>> T min(T prvni, T druhy) {
        return prvni.compareTo(druhy) < 0 ? prvni : druhy;
    }
}
