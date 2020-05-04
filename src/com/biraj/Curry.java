package com.biraj;

public class Curry {

    static <A,B,C> Function<A, Function<B,C>> curry(Function<Tuple<A,B>,C> f){
        return a->b->f.apply(new Tuple<>(a,b));
    }


    public static void main(String[] args) {

    }
}

class Tuple<A,B>{

    public Tuple(A a, B b) {
    }
}