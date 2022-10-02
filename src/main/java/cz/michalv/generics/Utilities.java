package cz.michalv.generics;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Nekompatibilita generickych typu se zolikem ?
 *
 */
class Utilities {

    public static void method(Collection<? extends CharSequence> coll, Class<? extends CharSequence> type) throws InstantiationException, IllegalAccessException {

        //coll.add(type.newInstance()); // chyba: neslučitelné typy ...
    }
}

class TestU {

    public static void test() throws InstantiationException, IllegalAccessException {
        List<StringBuilder> stringList = new LinkedList<>();
        Utilities.method(stringList, String.class);
    }
}
