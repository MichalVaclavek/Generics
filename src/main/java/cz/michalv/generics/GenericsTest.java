package cz.michalv.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class GenericsTest {

    public static void main(String[] args) {

        Wrapper<String>          wrapper1 = new Wrapper<>("Oystein");
        Wrapper<? extends Number> wrapper2 = new Wrapper<>(0L);
        Wrapper<?>               wrapper3 = new Wrapper<>(new Date());
        //Wrapper <Number>        wrapper4 = new Wrapper <Number> (new Long(0L)); // cyba Number neimplementuje Comparable<Number>
        // chyba wrapper5 = new Wrapper <int> (5); // chyba
    }
}
