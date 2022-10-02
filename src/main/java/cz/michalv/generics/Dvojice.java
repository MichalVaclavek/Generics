package cz.michalv.generics;

import java.util.Date;

/**
 * Nekompatibilita generickych typu se zolikem ?
 *
 * @param <S>
 * @param <T>
 */
class Dvojice<S, T> {

    private S prvni;
    private T druhy;

    public Dvojice(S s, T t) {
        prvni = s;
        druhy = t;
    }

    public static void flip(Dvojice<?, ?> pair) {
        Object tmp = pair.prvni;
        //pair.prvni = pair.druhy; // chyba: neslučitelné typy
        //pair.druhy = tmp;   // chyba: neslučitelné typy
    }
}

class Test {

    public static void test() {
            Dvojice<?, ?> vanoce = new Dvojice<>("Vanoce", new Date(104, 11, 24));
            Dvojice.flip(vanoce);

            Dvojice<?, ?> jmeno = new Dvojice<>("Pavel", "Riha");
            Dvojice.flip(jmeno);
        }
}