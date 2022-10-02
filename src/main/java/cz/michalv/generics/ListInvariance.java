package cz.michalv.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

interface Powerful {}

class Jedi implements Powerful {}

class Sith implements Powerful {}

public class ListInvariance {

    public static void main(String[] args) {
        List<Jedi> jedis = new LinkedList<>();
        jedis.add(new Jedi());

        List<? extends Powerful> powerfuls = jedis;
        //Sith sith = powerfuls.get(0); // nelze priradit, powerfuls je deklarovano jako list neznamych trid implementujiccih Powerful,
                                      // tj. vubec to nemusi byt zrovna Sith
        //powerfuls.add(new Sith()); // a ze stejneho duvodu nelze vlozit, nevime jestli v seznamu jsou zrovna objekty typu Sith


        List<Object> output = new ArrayList<>();
        List<Long>   input = new ArrayList<>();
        Collections.copy(output, input); // v pořádku; T:= Number & Serializabe & Comparable<Number>

        List<String> output2 = new ArrayList<>();
        List<Long>   input2 = new ArrayList<>();
        //Collections.copy(output2, input2); // chyba, ale napr. List<Number> output2 = new ArrayList<>(); by bylo OK

        List<Number> output3 = new ArrayList<>();
        List<Long>   input3 = new ArrayList<>();
        Collections.copy(output3, input3);

    }

}
