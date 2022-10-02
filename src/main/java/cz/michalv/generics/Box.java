package cz.michalv.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;


class Box<T extends Comparable<T> & Cloneable> implements Comparable<Box<T>>, Cloneable {

    private T theObject;

    public Box() {
        theObject = null;
    }

    public Box(T arg) {
        theObject = arg;
    }


    public int compareTo(Box<T> other) {
        return theObject.compareTo(other.theObject);
    }

//    public int compareTo(Box<? extends T> other) {
//        return theObject.compareTo(other.theObject);
//    }

    public Box<T> clone() {
        Box<T> clonek = new Box<>();
        clonek.theObject = this.theObject;
        return clonek;
    }

}

@Slf4j
class Test3 {

    private static Collection<Box<?>> boxes;

    public static void main(String[] args) {

        boxes = new ArrayList<>();

        Box<Slon> box1 = new Box<>(new Slon("Bumbo"));
        boxes.add(box1);
        Box<Slon> box2 = new Box<>(new Slune("Bumbo2"));
        boxes.add(box2);

        box1.compareTo(box2);
        box2.compareTo(box1);
        //Box<Slune> box3 = new Box<>(new Slune("Bumbo2")); // nelze, Slune nevyhovuje T extends Comparable<T> & Cloneable
    }
}

class Slon implements Comparable<Slon>, Cloneable {

    String name;

    public Slon(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Slon o) {
        return 0;
    }
}


class Slune extends Slon  {

    String name;

    public Slune(String name) {
        super(name);
        this.name = name;
    }

}



